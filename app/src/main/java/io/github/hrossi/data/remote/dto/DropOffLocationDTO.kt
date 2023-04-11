package io.github.hrossi.data.remote.dto

data class DropOffLocationDTO(
    val borough: String,
    val ntaname: String,
    val zipcode: String,
    val dropoff_sitename: String,
    val address: String,
    val number: String,
    val street: String,
    val borocd: String,
    val councildist: String,
    val ct2010: String,
    val bbl: String,
    val bin: String,
    val latitude: String,
    val longitude: String,
    val policeprec: String,
)