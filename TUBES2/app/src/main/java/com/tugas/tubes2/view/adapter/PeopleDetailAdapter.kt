package com.tugas.tubes2.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tugas.tubes2.R
import com.tugas.tubes2.presenter.DetailAdapterPresenter

class PeopleDetailAdapter(val PeopleDetail: List<String>, val presenter: DetailAdapterPresenter): RecyclerView.Adapter<PeopleDetailAdapter.PeopleDetailViewHolder>() {
    class PeopleDetailViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val namaitem = view.findViewById<TextView>(R.id.listName)
        val image = view.findViewById<ImageView>(R.id.listImg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.template_listview, parent, false)
        return PeopleDetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return PeopleDetail.size
    }

    override fun onBindViewHolder(holder: PeopleDetailViewHolder, position: Int) {
        //call api
        //ambil data people dari api
        presenter.getDataPeople(holder, PeopleDetail, position)
    }
}