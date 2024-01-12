package com.tugas.tubes2

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ResultListAdapter(private val activity: Activity, private val resultList: List<DataResult.Result>) : BaseAdapter() {

    private val names: List<String> = resultList.map { it.name }
    private val uids: List<String> = resultList.map { it.uid }

    override fun getCount(): Int {
        return resultList.size
    }

    override fun getItem(position: Int): Any {
        return resultList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: activity.layoutInflater.inflate(R.layout.item_list, null)
        val viewHolder = ViewHolder(view)

        viewHolder.name.text = names[position]
        viewHolder.uid.text = "UID : " + uids[position]

        if(resultList[position].url.contains("people")){
            Glide.with(viewHolder.image.context)
                .load(APICall.BASE_IMAGE_URL + "characters/" + uids[position] + ".jpg")
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()

                .into(viewHolder.image)
        }else{
            //ambil category dari url
            val category = resultList[position].url.split("/")[4]

            Glide.with(viewHolder.image.context)
                .load(APICall.BASE_IMAGE_URL + category + "/" + uids[position] + ".jpg")
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()

                .into(viewHolder.image)

        }


        return view
    }

    private class ViewHolder(view: View) {
        val name: TextView = view.findViewById(R.id.name)
        val uid: TextView = view.findViewById(R.id.uid)
        var image: ImageView =  view.findViewById(R.id.item_img)
    }
}