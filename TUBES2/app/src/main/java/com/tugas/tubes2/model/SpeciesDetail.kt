package com.tugas.tubes2.model

import java.io.Serializable

data class SpeciesDetail(
    var message: String,
    var result: Species
) : Serializable {
    data class Species(
        var properties: Properties,
        var description: String,
        var _id: String,
        var uid: String,
        var __v: Int
    ) : Serializable {
        data class Properties(
            var classification: String,
            var designation: String,
            var average_height: String,
            var average_lifespan: String,
            var hair_colors: String,
            var skin_colors: String,
            var eye_colors: String,
            var homeworld: String,
            var language: String,
            var people: List<String>,
            var created: String,
            var edited: String,
            var name: String,
            var url: String
        ) : Serializable
    }
}