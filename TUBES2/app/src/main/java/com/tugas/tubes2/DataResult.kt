package com.tugas.tubes2

import java.io.Serializable

data class DataResult(
    var results: List<Result>,
) : Serializable {
    data class Result(
        var uid: String,
        var name: String,
        var url: String,
    )
}