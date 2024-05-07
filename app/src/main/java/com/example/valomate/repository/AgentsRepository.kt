package com.example.valomate.repository

import com.example.valomate.data.remote.response.AgentsResponse
import com.example.valomate.data.remote.retrofit.ApiConfig

class AgentsRepository {
    private val agentsService = ApiConfig.getApiService()

    suspend fun getAgents(): AgentsResponse {
        return agentsService.getAgents()
    }
}