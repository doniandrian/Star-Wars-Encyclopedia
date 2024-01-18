package com.tugas.tubes2.view

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import android.widget.Filter
import android.widget.Filterable
import com.tugas.tubes2.BASE_IMAGE_URL
import com.tugas.tubes2.R
import com.tugas.tubes2.model.FilmsResult
import java.util.ArrayList

class FilmsListAdapter(private val activity: Activity, private val filmList: List<FilmsResult.Film>) : BaseAdapter(), Filterable {

    private var filteredFilms: List<FilmsResult.Film> = filmList
    override fun getCount(): Int {
        return filteredFilms.size
    }

    override fun getItem(position: Int): Any {
        return filteredFilms[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: activity.layoutInflater.inflate(R.layout.item_list, null)
        val viewHolder = ViewHolder(view)

        viewHolder.name.text = filteredFilms[position].properties.title
        viewHolder.uid.text = "Release Date: " + filteredFilms[position].properties.release_date

        //ambil category dari url
        val category = filteredFilms[position].properties.url.split("/")[4]
        Glide.with(viewHolder.image.context)
            .load(BASE_IMAGE_URL + category + "/" + filteredFilms[position].uid + ".jpg")
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.picture_error_icon)
            .centerCrop()

            .into(viewHolder.image)

        return view
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResults = FilterResults()

                if (constraint.isNullOrEmpty()) {
                    filterResults.values = filmList
                    filterResults.count = filmList.size
                }
                else {
                    val filteredList = ArrayList<FilmsResult.Film>()
                    val filterPattern = constraint.toString().lowercase().trim()

                    for (result in filmList) {
                        if (result.properties.title.lowercase().contains(filterPattern)) {
                            filteredList.add(result)
                        }
                    }

                    filterResults.values = filteredList
                    filterResults.count = filteredList.size
                }

                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredFilms = results?.values as List<FilmsResult.Film>
                notifyDataSetChanged()
            }
        }
    }

    private class ViewHolder(view: View) {
        val name: TextView = view.findViewById(R.id.name)
        val uid: TextView = view.findViewById(R.id.uid)
        val image: ImageView = view.findViewById(R.id.item_img)
    }
}
