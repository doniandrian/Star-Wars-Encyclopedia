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
class PlanetsDetailAdapter(val PlanetsDetail: List<String>, val presenter: DetailAdapterPresenter): RecyclerView.Adapter<PlanetsDetailAdapter.PlanetsDetailViewHolder>() {

    class PlanetsDetailViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val namaitem = view.findViewById<TextView>(R.id.listName)
        val image = view.findViewById<ImageView>(R.id.listImg)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetsDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.template_listview, parent, false)
        return PlanetsDetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return PlanetsDetail.size
    }

    override fun onBindViewHolder(holder: PlanetsDetailViewHolder, position: Int) {
        //call api
        //ambil data people dari api
        presenter.getDataPlanets(holder, PlanetsDetail, position)
    }
}