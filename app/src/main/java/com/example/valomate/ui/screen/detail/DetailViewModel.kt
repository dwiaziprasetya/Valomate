package com.example.valomate.ui.screen.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valomate.data.remote.response.AgentsDetailResponse
import com.example.valomate.repository.AgentsRepository
import kotlinx.coroutines.launch

class DetailViewModel(uuid: String) : ViewModel() {
    private val repository = AgentsRepository()

    private val _agent = MutableLiveData<AgentsDetailResponse>()
    val agent: LiveData<AgentsDetailResponse> = _agent

    init {
        getAgentById(uuid)
    }

    private fun getAgentById(uuid: String) {
        viewModelScope.launch {
            try {
                val agent = repository.getAgentById(uuid)
                _agent.value = agent
            } catch (_: Exception){

            }
        }
    }
}