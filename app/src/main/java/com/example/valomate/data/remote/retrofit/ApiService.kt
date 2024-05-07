package com.example.valomate.data.remote.retrofit

import com.example.valomate.data.remote.response.AgentsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("v1/agents")
    suspend fun getAgents(): AgentsResponse
}