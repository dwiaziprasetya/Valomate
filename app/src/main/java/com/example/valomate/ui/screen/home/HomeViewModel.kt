package com.example.valomate.ui.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valomate.data.remote.response.AgentsResponse
import com.example.valomate.repository.AgentsRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repository = AgentsRepository()

    private val _agents = MutableLiveData<AgentsResponse>()
    val agents: LiveData<AgentsResponse> = _agents

    init {
        getAgents()
    }

    private fun getAgents() {
        viewModelScope.launch {
            try {
                val agents = repository.getAgents()
                _agents.value = agents
            } catch (_: Exception) {

            }
        }
    }
}