package ir.rezamahmoudi.divar.cityselection.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.rezamahmoudi.divar.cityselection.domain.usecase.FetchCitiesUseCase
import ir.rezamahmoudi.divar.cityselection.domain.usecase.SaveSelectedCityIdUseCase
import ir.rezamahmoudi.divar.core.util.log.showErrorLog
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitySelectionViewModel @Inject constructor(
    private val fetchCitiesUseCase: FetchCitiesUseCase,
    private val saveSelectedCityIdUseCase: SaveSelectedCityIdUseCase
//    private val locationService: LocationService,
) : ViewModel(), CitySelectionContract {

    private val _mutableState = MutableStateFlow(CitySelectionContract.State.EMPTY)
    override val state: StateFlow<CitySelectionContract.State> = _mutableState.asStateFlow()

    private val effectChannel = Channel<CitySelectionContract.Effect>(Channel.UNLIMITED)
    override val effect: Flow<CitySelectionContract.Effect> = effectChannel.receiveAsFlow()

    init {
        fetchCities()
        checkLocationPermission()
    }

    override fun event(event: CitySelectionContract.Event) {
        when (event) {
            is CitySelectionContract.Event.OnSelectCity -> {
                onSelectCity(cityId = event.cityId)
            }
            is CitySelectionContract.Event.LocationReceived -> {
                getCurrentLocationCityId(lat = event.lat, long = event.long)
            }
        }
    }

    private fun checkLocationPermission() {
        viewModelScope.launch {
            effectChannel.send(
                CitySelectionContract.Effect.CheckLocationPermission
            )
        }
    }
    private fun fetchCities() {
        viewModelScope.launch {
            fetchCitiesUseCase().onSuccess { cities ->
                _mutableState.update { it.copy(cities = cities) }
            }
        }
    }

    private fun getCurrentLocationCityId(lat: Double, long: Double) {
        showErrorLog("Current Location $lat $long")
    }

    private fun onSelectCity(cityId: String) {
        viewModelScope.launch {
            saveSelectedCityIdUseCase(defaultCityId = cityId)
            effectChannel.send(CitySelectionContract.Effect.NavigateToHome)
        }
    }
}
