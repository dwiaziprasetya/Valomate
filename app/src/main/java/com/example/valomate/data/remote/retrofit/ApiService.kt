package com.example.valomate.data.remote.retrofit

import com.example.valomate.data.remote.response.AgentsDetailResponse
import com.example.valomate.data.remote.response.AgentsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("v1/agents")
    suspend fun getAgents(): AgentsResponse

    @GET("v1/agents/{uuid}")
    suspend fun getAgentById(
        @Path("uuid")
        uuid: String
    ): AgentsDetailResponse
}