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

class PeopleDetailAdapter(val PeopleDetail: List<String>): RecyclerView.Adapter<PeopleDetailAdapter.PeopleDetailViewHolder>() {
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
        APICall.getPeopleDetail(holder.itemView.context, "people/" + getPersonIdFromUrl(PeopleDetail[position])){ peopleDetail ->
            Log.d("PeopleDetail", peopleDetail.result.properties.name)
            holder.namaitem.text = peopleDetail.result.properties.name

            Glide.with(holder.itemView.context)
                .load(BASE_IMAGE_URL + "characters/" + peopleDetail.result.uid + ".jpg")
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(holder.image)


        }


    }
    private fun getPersonIdFromUrl(url: String): String {
        //ambil id dari url
        return url.substringAfterLast("/").removeSuffix("/")
    }

}