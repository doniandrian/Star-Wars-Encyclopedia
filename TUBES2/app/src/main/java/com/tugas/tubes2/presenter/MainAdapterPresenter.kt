package com.tugas.tubes2.presenter

import com.bumptech.glide.Glide
import com.tugas.tubes2.BASE_IMAGE_URL
import com.tugas.tubes2.R
import com.tugas.tubes2.model.DataResult
import com.tugas.tubes2.model.FilmsResult
import com.tugas.tubes2.view.adapter.FilmsListAdapter
import com.tugas.tubes2.view.adapter.ResultListAdapter
import com.tugas.tubes2.view.presenterInterface.IMainAdapter

class MainAdapterPresenter: IMainAdapter.Presenter {
    override fun addImage(filteredResults: List<DataResult.Result>, position: Int, viewHolder: ResultListAdapter.ViewHolder) {
        if (filteredResults[position].url.contains("people")) {
            Glide.with(viewHolder.image.context)
                .load(BASE_IMAGE_URL + "characters/" + filteredResults[position].uid + ".jpg")
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(viewHolder.image)
        }
        else {
            //ambil category dari url
            val category = filteredResults[position].url.split("/")[4]

            Glide.with(viewHolder.image.context)
                .load(BASE_IMAGE_URL + category + "/" + filteredResults[position].uid + ".jpg")
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(viewHolder.image)
        }
    }

    override fun addImageFilms(filteredFilms: List<FilmsResult.Film>, position: Int, viewHolder: FilmsListAdapter.ViewHolder) {
        //ambil category dari url
        val category = filteredFilms[position].properties.url.split("/")[4]
        Glide.with(viewHolder.image.context)
            .load(BASE_IMAGE_URL + category + "/" + filteredFilms[position].uid + ".jpg")
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .centerCrop()

            .into(viewHolder.image)
    }
}