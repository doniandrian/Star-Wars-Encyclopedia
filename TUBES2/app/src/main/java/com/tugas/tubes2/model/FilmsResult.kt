package com.tugas.tubes2.model

import java.io.Serializable

data class FilmsResult(
    var message: String,
    var result: List<Film>
) : Serializable {
    data class Film(
        var properties: Properties,
        var description: String,
        var _id: String,
        var uid: String,
        var __v: Int
    ) : Serializable {
        data class Properties(
            var characters: List<String>,
            var planets: List<String>,
            var starships: List<String>,
            var vehicles: List<String>,
            var species: List<String>,
            var created: String,
            var edited: String,
            var producer: String,
            var title: String,
            var episode_id: Int,
            var director: String,
            var release_date: String,
            var opening_crawl: String,
            var url: String
        ) : Serializable
    }
}