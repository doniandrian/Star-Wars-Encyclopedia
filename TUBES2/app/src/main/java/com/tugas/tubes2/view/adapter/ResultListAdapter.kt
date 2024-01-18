package com.tugas.tubes2.view.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Filter
import android.widget.Filterable
import com.tugas.tubes2.model.DataResult
import com.tugas.tubes2.databinding.ItemListBinding
import com.tugas.tubes2.presenter.MainAdapterPresenter
import java.util.ArrayList

class ResultListAdapter(private val activity: Activity, private val resultList: List<DataResult.Result>, private val presenter: MainAdapterPresenter) : BaseAdapter(), Filterable {

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
        val binding = ItemListBinding.inflate(activity.layoutInflater)
        val viewHolder = ViewHolder(binding)

        viewHolder.name.text = filteredResults[position].name
        viewHolder.uid.text = "UID : " + filteredResults[position].uid

        presenter.addImage(filteredResults, position, viewHolder)
        return binding.root
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
    class ViewHolder(binding: ItemListBinding) {
        val name = binding.name
        val uid = binding.uid
        var image = binding.itemImg
    }
}

// REFERENSI
// 1. https://stackoverflow.com/questions/12456525/how-to-filter-listview-using-getfilter-in-baseadapter (getFilter())