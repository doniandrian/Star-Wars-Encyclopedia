package com.tugas.tubes2.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tugas.tubes2.R
import com.tugas.tubes2.presenter.DetailAdapterPresenter

//adapter untuk menampilkan list planet di film
class SpeciesDetailAdapter(val SpeciesDetail: List<String>, val presenter: DetailAdapterPresenter): RecyclerView.Adapter<SpeciesDetailAdapter.SpeciesDetailViewHolder>() {

    class SpeciesDetailViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val namaitem = view.findViewById<TextView>(R.id.listName)
        val image = view.findViewById<ImageView>(R.id.listImg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeciesDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.template_listview, parent, false)
        return SpeciesDetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return SpeciesDetail.size
    }

    override fun onBindViewHolder(holder: SpeciesDetailViewHolder, position: Int) {
        presenter.getDataSpecies(holder, SpeciesDetail, position)
    }
}