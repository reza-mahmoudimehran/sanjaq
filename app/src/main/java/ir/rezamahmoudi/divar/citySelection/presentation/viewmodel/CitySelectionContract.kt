package ir.rezamahmoudi.divar.cityselection.presentation.viewmodel

import androidx.compose.runtime.Stable
import ir.rezamahmoudi.divar.cityselection.presentation.model.CityUiModel
import ir.rezamahmoudi.divar.core.util.compose.UnidirectionalViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

interface CitySelectionContract :
    UnidirectionalViewModel<CitySelectionContract.Event, CitySelectionContract.Effect, CitySelectionContract.State> {

    interface Event {
        data class OnSelectCity(val cityId: String) : Event
        data class LocationReceived(val lat: Double, val long: Double) : Event
    }

    interface Effect {
        object PopBackStack : Effect
        object NavigateToHome : Effect
        object CheckLocationPermission : Effect
    }

    @Stable
    data class State(
        val cities: ImmutableList<CityUiModel>
    ) {
        companion object {
            val EMPTY = State(
                cities = persistentListOf()
            )
        }
    }
}
