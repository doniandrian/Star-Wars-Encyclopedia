package com.tugas.tubes2

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class FilmsListAdapter(private val activity: Activity, private val filmList: List<FilmsResult.Film>) : BaseAdapter() {

    private val titles: List<String> = filmList.map { it.properties.title }
    private val releaseDates: List<String> = filmList.map { it.properties.release_date }
    private val uid: List<String> = filmList.map { it.uid }
    override fun getCount(): Int {
        return filmList.size
    }

    override fun getItem(position: Int): Any {
        return filmList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: activity.layoutInflater.inflate(R.layout.item_list, null)
        val viewHolder = ViewHolder(view)

        viewHolder.name.text = titles[position]
        viewHolder.uid.text = "Release Date: " + releaseDates[position]

        //ambil category dari url
        val category = filmList[position].properties.url.split("/")[4]
        Glide.with(viewHolder.image.context)
            .load(APICall_Films.BASE_IMAGE_URL2 + category + "/" + uid[position] + ".jpg")
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .centerCrop()

            .into(viewHolder.image)

        return view
    }

    private class ViewHolder(view: View) {
        val name: TextView = view.findViewById(R.id.name)
        val uid: TextView = view.findViewById(R.id.uid)
        val image: ImageView = view.findViewById(R.id.item_img)
    }
}
