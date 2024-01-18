package com.tugas.tubes2.model

import java.io.Serializable

data class PeopleDetail(
    var message: String,
    var result: People
) : Serializable {
    data class People(
        var properties: Properties,
        var description: String,
        var _id: String,
        var uid: String,
        var __v: Int
    ) : Serializable {
        data class Properties(
            var height: String,
            var mass: String,
            var hair_color: String,
            var skin_color: String,
            var eye_color: String,
            var birth_year: String,
            var gender: String,
            var homeworld: String,
            var species: List<String>,
            var starships: List<String>,
            var vehicles: List<String>,
            var created: String,
            var edited: String,
            var name: String,
            var url: String
        ) : Serializable
    }
}