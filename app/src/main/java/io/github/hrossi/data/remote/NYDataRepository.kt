package io.github.hrossi.data.remote

import io.github.hrossi.domain.DropOffLocation

class NYDataRepository(private val service: NYDataService) {

    suspend fun getDropOffLocations(): List<DropOffLocation> {
        return service.getElectronicsDropOffLocations().map {
            DropOffLocation(it.ntaname, it.address, it.latitude.toDouble(), it.longitude.toDouble())
        }
    }
}