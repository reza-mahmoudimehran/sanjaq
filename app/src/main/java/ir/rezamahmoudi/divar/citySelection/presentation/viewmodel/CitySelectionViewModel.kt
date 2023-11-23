package ir.rezamahmoudi.divar.cityselection.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.rezamahmoudi.divar.cityselection.domain.usecase.FetchCitiesUseCase
import ir.rezamahmoudi.divar.cityselection.domain.usecase.SaveSelectedCityIdUseCase
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
) : ViewModel(), CitySelectionContract {

    private val _mutableState = MutableStateFlow(CitySelectionContract.State.EMPTY)
    override val state: StateFlow<CitySelectionContract.State> = _mutableState.asStateFlow()

    private val effectChannel = Channel<CitySelectionContract.Effect>(Channel.UNLIMITED)
    override val effect: Flow<CitySelectionContract.Effect> = effectChannel.receiveAsFlow()

    init {
        fetchCities()
    }

    private fun fetchCities() {
        viewModelScope.launch {
            fetchCitiesUseCase().onSuccess { cities ->
                _mutableState.update { it.copy(cities = cities) }
            }
        }
    }

    override fun event(event: CitySelectionContract.Event) {
        when (event) {
            is CitySelectionContract.Event.OnSelectCity -> {
                onSelectCity(cityId = event.cityId)
            }
        }
    }

    private fun onSelectCity(cityId: String) {
        viewModelScope.launch {
            saveSelectedCityIdUseCase(defaultCityId = cityId)
            effectChannel.send(CitySelectionContract.Effect.NavigateToHome)
        }
    }
}
