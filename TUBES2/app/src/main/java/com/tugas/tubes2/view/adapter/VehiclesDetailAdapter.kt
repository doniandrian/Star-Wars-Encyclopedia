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
class VehiclesDetailAdapter(val VehiclesDetail: List<String>, val presenter: DetailAdapterPresenter): RecyclerView.Adapter<VehiclesDetailAdapter.VehiclesDetailViewHolder>() {

    class VehiclesDetailViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val namaitem = view.findViewById<TextView>(R.id.listName)
        val image = view.findViewById<ImageView>(R.id.listImg)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiclesDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.template_listview, parent, false)
        return VehiclesDetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return VehiclesDetail.size
    }

    override fun onBindViewHolder(holder: VehiclesDetailViewHolder, position: Int) {
        presenter.getDataVehicles(holder, VehiclesDetail, position)
    }

}