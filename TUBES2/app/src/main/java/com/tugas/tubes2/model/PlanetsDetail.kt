package com.tugas.tubes2.model

import java.io.Serializable

data class PlanetsDetail(
    var message: String,
    var result: Planet
) : Serializable {
    data class Planet(
        var properties: Properties,
        var description: String,
        var _id: String,
        var uid: String,
        var __v: Int
    ) : Serializable {
        data class Properties(
            var name: String,
            var diameter: String,
            var rotation_period: String,
            var orbital_period: String,
            var gravity: String,
            var population: String,
            var climate: String,
            var terrain: String,
            var surface_water: String,
            var created: String,
            var edited: String,
            var url: String
        ) : Serializable
    }
}

