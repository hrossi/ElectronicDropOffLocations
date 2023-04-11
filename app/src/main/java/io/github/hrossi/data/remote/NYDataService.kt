package io.github.hrossi.data.remote

import io.github.hrossi.data.remote.dto.DropOffLocationDTO
import retrofit2.http.GET

interface NYDataService {

    @GET("resource/wshr-5vic.json")
    suspend fun getElectronicsDropOffLocations() : List<DropOffLocationDTO>
}