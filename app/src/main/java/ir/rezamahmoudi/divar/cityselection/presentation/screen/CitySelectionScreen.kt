package ir.rezamahmoudi.divar.cityselection.presentation.screen

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import ir.rezamahmoudi.divar.R
import ir.rezamahmoudi.divar.cityselection.presentation.component.CityItem
import ir.rezamahmoudi.divar.cityselection.presentation.viewmodel.CitySelectionContract
import ir.rezamahmoudi.divar.cityselection.presentation.viewmodel.CitySelectionViewModel
import ir.rezamahmoudi.divar.core.presentation.designsystem.AppTheme
import ir.rezamahmoudi.divar.core.presentation.screen.Screen
import ir.rezamahmoudi.divar.core.presentation.widget.navbar.NavBar
import ir.rezamahmoudi.divar.core.util.compose.collectInLaunchedEffect
import ir.rezamahmoudi.divar.core.util.compose.use
import ir.rezamahmoudi.divar.core.util.location.getCurrentLocation
import kotlinx.coroutines.InternalCoroutinesApi

@OptIn(
    InternalCoroutinesApi::class,
    ExperimentalPermissionsApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun CitySelectionScreen(
    viewModel: CitySelectionViewModel = hiltViewModel(),
    onNavigateToScreen: (String) -> Unit,
    navigateUp: () -> Unit
) {
    val (state, effect, dispatcher) = use(viewModel = viewModel)

    val context = LocalContext.current
    val permissionState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
    )

    val requestPermissionLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {}

    effect.collectInLaunchedEffect {
        when (it) {
            CitySelectionContract.Effect.NavigateUp -> {
                navigateUp()
            }

            CitySelectionContract.Effect.NavigateToHome -> {
                onNavigateToScreen(Screen.Home.route)
            }

            is CitySelectionContract.Effect.CheckLocationPermission -> {
                if (permissionState.allPermissionsGranted.not()) {
                    requestPermissionLauncher.launch(
                        arrayOf(
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        )
                    )
                }
            }
        }
    }

    LaunchedEffect(key1 = permissionState.allPermissionsGranted) {
        if (permissionState.allPermissionsGranted) {
            dispatcher.invoke(
                CitySelectionContract.Event.UpdateIsPermissionGranted(isGranted = true)
            )
        } else {
            return@LaunchedEffect
        }

        context.getCurrentLocation { location ->
            dispatcher.invoke(
                CitySelectionContract.Event.LocationReceived(
                    lat = location.latitude,
                    long = location.longitude
                )
            )
        }
    }

    Scaffold(
        topBar = {
            NavBar(
                text = stringResource(id = R.string.select_city_title),
                navigateUp = {
                    dispatcher(CitySelectionContract.Event.OnBackPressed)
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = AppTheme.dimensions.mainContentPadding)
                .fillMaxSize()
        ) {
            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            if (state.isLocationPermissionGranted.not()) {
                                dispatcher.invoke(CitySelectionContract.Event.OnRequestLocationPermission)
                            } else {
                                state.currentCity?.id?.let {
                                    dispatcher.invoke(CitySelectionContract.Event.OnSelectCity(it.toString()))
                                }
                            }
                        }
                        .padding(vertical = 12.dp, horizontal = 2.dp),
                    text = if (state.isLocationPermissionGranted) {
                        state.currentCity?.name?.let { "${stringResource(id = R.string.your_city_title)}: $it" }
                            ?: stringResource(id = R.string.get_your_city_title)
                    } else {
                        stringResource(id = R.string.my_current_city_title)
                    },
                    style = AppTheme.typography.text14Bold,
                    color = AppTheme.colors.designSystem.primaryText
                )
            }
            items(items = state.cities, key = { it.id }) { city ->
                CityItem(
                    city = city,
                    onSelectCity = {
                        dispatcher.invoke(CitySelectionContract.Event.OnSelectCity(it))
                    }
                )
            }
        }
    }
}
