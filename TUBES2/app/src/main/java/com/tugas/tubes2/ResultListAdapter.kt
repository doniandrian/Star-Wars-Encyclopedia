package com.tugas.tubes2

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import android.widget.Filter
import android.widget.Filterable
import java.util.ArrayList

class ResultListAdapter(private val activity: Activity, private val resultList: List<DataResult.Result>) : BaseAdapter(), Filterable {

    private var filteredResults: List<DataResult.Result> = resultList

    override fun getCount(): Int {
        return filteredResults.size
    }

    override fun getItem(position: Int): Any {
        return filteredResults[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: activity.layoutInflater.inflate(R.layout.item_list, null)
        val viewHolder = ViewHolder(view)

        viewHolder.name.text = filteredResults[position].name
        viewHolder.uid.text = "UID : " + filteredResults[position].uid

        if (filteredResults[position].url.contains("people")) {
            Glide.with(viewHolder.image.context)
                .load(APICall.BASE_IMAGE_URL + "characters/" + filteredResults[position].uid + ".jpg")
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(viewHolder.image)
        }
        else {
            //ambil category dari url
            val category = filteredResults[position].url.split("/")[4]

            Glide.with(viewHolder.image.context)
                .load(APICall.BASE_IMAGE_URL + category + "/" + filteredResults[position].uid + ".jpg")
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(viewHolder.image)
        }

        return view
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResults = FilterResults()

                if (constraint.isNullOrEmpty()) {
                    filterResults.values = resultList
                    filterResults.count = resultList.size
                }
                else {
                    val filteredList = ArrayList<DataResult.Result>()
                    val filterPattern = constraint.toString().lowercase().trim()

                    for (result in resultList) {
                        if (result.name.lowercase().contains(filterPattern)) {
                            filteredList.add(result)
                        }
                    }

                    filterResults.values = filteredList
                    filterResults.count = filteredList.size
                }

                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredResults = results?.values as List<DataResult.Result>
                notifyDataSetChanged()
            }
        }
    }

    private class ViewHolder(view: View) {
        val name: TextView = view.findViewById(R.id.name)
        val uid: TextView = view.findViewById(R.id.uid)
        var image: ImageView = view.findViewById(R.id.item_img)
    }
}
