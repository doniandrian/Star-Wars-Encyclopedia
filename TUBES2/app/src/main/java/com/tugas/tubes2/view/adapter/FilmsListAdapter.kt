package com.tugas.tubes2.view.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Filter
import android.widget.Filterable
import com.tugas.tubes2.databinding.ItemListBinding
import com.tugas.tubes2.model.FilmsResult
import com.tugas.tubes2.presenter.MainAdapterPresenter
import java.util.ArrayList

class FilmsListAdapter(private val activity: Activity, private val filmList: List<FilmsResult.Film>, private val presenter: MainAdapterPresenter) : BaseAdapter(), Filterable {

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
        val binding = ItemListBinding.inflate(activity.layoutInflater)
        val viewHolder = ViewHolder(binding)

        viewHolder.name.text = filteredFilms[position].properties.title
        viewHolder.uid.text = "Release Date: " + filteredFilms[position].properties.release_date

        presenter.addImageFilms(filteredFilms, position, viewHolder)

        return binding.root
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

    class ViewHolder(binding: ItemListBinding) {
        val name = binding.name
        val uid = binding.uid
        var image = binding.itemImg
    }
}

// REFERENSI
// 1. https://stackoverflow.com/questions/12456525/how-to-filter-listview-using-getfilter-in-baseadapter (getFilter())