package com.tugas.tubes2.view

import android.util.Log
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

//adapter untuk menampilkan list planet di film
class StarshipsDetailAdapter(val StarShipsDetail: List<String>): RecyclerView.Adapter<StarshipsDetailAdapter.StarShipsDetailViewHolder>() {

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
        //call api
        //ambil data people dari api
        APICall.getPeopleDetail(holder.itemView.context, "starships/" + getPersonIdFromUrl(StarShipsDetail[position])){ starShipsDetail ->
            holder.namaitem.text = starShipsDetail.result.properties.name

            Glide.with(holder.itemView.context)
                .load(BASE_IMAGE_URL + "starships/" + starShipsDetail.result.uid + ".jpg")
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.picture_error_icon)
                .centerCrop()
                .into(holder.image)


        }


    }
    private fun getPersonIdFromUrl(url: String): String {
        //ambil id dari url
        return url.substringAfterLast("/").removeSuffix("/")
    }

}