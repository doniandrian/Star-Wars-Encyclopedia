package com.tugas.tubes2

data class DataResult(
    var results: List<Result>,
) : java.io.Serializable {
    data class Result(
        var uid: String,
        var name: String,
        var url: String
    )
}

