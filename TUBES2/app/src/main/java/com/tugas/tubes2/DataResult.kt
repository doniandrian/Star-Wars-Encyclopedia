package com.tugas.tubes2

import java.io.Serializable


data class DataResult(
    var results: List<Result>,
) : Serializable {
    data class Result(
        var uid: String,
        var name: String,
        var url: String
    )
}

////data class FilmsResult(
////    var title: String,
////    var episode_id: Int,
////    override var url: String
////) : DisplayData, Serializable {
////    override val name: String
////        get() = title
////    override val uid: String
////        get() = episode_id.toString()
////}
//
