package io.github.hrossi.domain

data class DropOffLocation(
    val name: String,
    val address: String,
    val latitude: Double?,
    val longitude: Double?
)