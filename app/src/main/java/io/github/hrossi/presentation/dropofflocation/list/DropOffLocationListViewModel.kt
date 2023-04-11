package io.github.hrossi.presentation.dropofflocation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.hrossi.data.remote.NYDataRepository
import io.github.hrossi.domain.DropOffLocation
import kotlinx.coroutines.launch

class DropOffLocationListViewModel(
    private val repository: NYDataRepository
) : ViewModel() {

    private val _state = MutableLiveData<ScreenState>()
    val state: LiveData<ScreenState> = _state

    init {
        getDropOffLocations()
    }

    private fun getDropOffLocations() {
        viewModelScope.launch {
            _state.value = ScreenState.Loading

            runCatching {
                repository.getDropOffLocations()
            }.onSuccess {
                _state.value = ScreenState.Data(it)
            }.onFailure {
                _state.value = ScreenState.Error
            }
        }
    }

    fun onClickTryAgain() {
        getDropOffLocations()
    }
}

sealed class ScreenState {
    object Loading : ScreenState()

    data class Data(
        val locations: List<DropOffLocation>
    ) : ScreenState()

    object Error : ScreenState()
}
