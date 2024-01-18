package com.tugas.tubes2.model

import java.io.Serializable

data class StarShipsDetail(
    var message: String,
    var result: Starship
) : Serializable {
    data class Starship(
        var properties: Properties,
        var description: String,
        var _id: String,
        var uid: String,
        var __v: Int
    ) : Serializable {
        data class Properties(
            var model: String,
            var starship_class: String,
            var manufacturer: String,
            var cost_in_credits: String,
            var length: String,
            var crew: String,
            var passengers: String,
            var max_atmosphering_speed: String,
            var hyperdrive_rating: String,
            var MGLT: String,
            var cargo_capacity: String,
            var consumables: String,
            var pilots: List<String>,
            var created: String,
            var edited: String,
            var name: String,
            var url: String
        ) : Serializable
    }
}