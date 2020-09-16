package com.proto.presentation.screen.main.page.aaa

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.proto.presentation.screen.main.page.aaa.AaaViewModel.State.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
    При повороте экрана ViewModel не пересоздаётся, новая Activity получает от провайдера уже
    существующую.
    При сворчаивании экрана через onSaveInstanceState сохраняется состояние SavedStateHandle,
    котрое будет получено, когда экран восстановится после смерти процесса
*/
class AaaViewModel(private val state: SavedStateHandle) : ViewModel() {

    companion object {
        private const val STATE_KEY = "state_key"
    }

    sealed class State {
        class Loading : State()
        class Empty : State()
        class Error(val error: String) : State()
        class Content(val content: Int) : State()
    }

    val data : MutableLiveData<State> = MutableLiveData()

    fun onStart(){
        data.postValue(Loading())
        GlobalScope.launch {
            delay(3000)
            data.postValue(Content(1))
        }
    }
}