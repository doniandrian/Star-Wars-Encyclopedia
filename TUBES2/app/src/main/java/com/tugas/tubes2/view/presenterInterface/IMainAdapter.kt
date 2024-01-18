package com.tugas.tubes2.view.presenterInterface

import com.tugas.tubes2.model.DataResult
import com.tugas.tubes2.model.FilmsResult
import com.tugas.tubes2.view.adapter.FilmsListAdapter
import com.tugas.tubes2.view.adapter.ResultListAdapter

interface IMainAdapter {
    interface Presenter {
        fun addImage(filteredResults: List<DataResult.Result>, position: Int, viewHolder: ResultListAdapter.ViewHolder)

        fun addImageFilms(filteredFilms: List<FilmsResult.Film>, position: Int, viewHolder: FilmsListAdapter.ViewHolder)
    }
}