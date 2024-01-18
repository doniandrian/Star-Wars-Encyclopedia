package com.tugas.tubes2.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tugas.tubes2.APICall
import com.tugas.tubes2.BASE_IMAGE_URL
import com.tugas.tubes2.R
import com.tugas.tubes2.presenter.DetailAdapterPresenter

//adapter untuk menampilkan list planet di film
class StarshipsDetailAdapter(val StarShipsDetail: List<String>, val presenter: DetailAdapterPresenter): RecyclerView.Adapter<StarshipsDetailAdapter.StarShipsDetailViewHolder>() {

    class StarShipsDetailViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val namaitem = view.findViewById<TextView>(R.id.listName)
        val image = view.findViewById<ImageView>(R.id.listImg)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarShipsDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.template_listview, parent, false)
        return StarShipsDetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return StarShipsDetail.size
    }

    override fun onBindViewHolder(holder: StarShipsDetailViewHolder, position: Int) {
        presenter.getDataStarShips(holder, StarShipsDetail, position)
    }
    private fun getPersonIdFromUrl(url: String): String {
        //ambil id dari url
        return url.substringAfterLast("/").removeSuffix("/")
    }
}