package com.tugas.tubes2.model

import java.io.Serializable

data class VehiclesDetail(
    var message: String,
    var result: Vehicle
) : Serializable {
    data class Vehicle(
        var properties: Properties,
        var description: String,
        var _id: String,
        var uid: String,
        var __v: Int
    ) : Serializable {
        data class Properties(
            var name: String,
            var model: String,
            var vehicle_class: String,
            var manufacturer: String,
            var cost_in_credits: String,
            var length: String,
            var crew: String,
            var passengers: String,
            var max_atmosphering_speed: String,
            var cargo_capacity: String,
            var consumables: String,
            var created: String,
            var edited: String,
            var url: String
        ) : Serializable
    }
}
