package com.tugas.tubes2.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.tugas.tubes2.APICall
import com.tugas.tubes2.BASE_IMAGE_URL
import com.tugas.tubes2.R
import com.tugas.tubes2.databinding.FilmDetailBinding
import com.tugas.tubes2.databinding.PeopleDetailBinding


class FilmDetailFragment : Fragment() {
    private lateinit var binding: FilmDetailBinding
    private lateinit var namaitem: TextView
    private lateinit var image : ImageView
    private lateinit var producerTxt: TextView
    private lateinit var episodeTxt: TextView
    private lateinit var directorTxt: TextView
    private lateinit var releaseDateTxt: TextView
    private lateinit var description: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FilmDetailBinding.inflate(inflater, container, false)
        namaitem = binding.namaItem
        image = binding.imageItem
        producerTxt = binding.producerTxt
        episodeTxt = binding.episodeTxt
        directorTxt = binding.directorTxt
        releaseDateTxt = binding.releaseDateTxt
        description = binding.description


        val mainActivity = activity as MainActivity

        val bundle = this.arguments
        if (bundle != null) {
            val url = bundle.getString("url")
            val nomor = url?.substringAfterLast("/")
            //glide
            Glide.with(this)
                .load("$BASE_IMAGE_URL/films/$nomor.jpg")
                .into(image)

            APICall.getFilmsDetail(mainActivity, "films/$nomor") { filmsDetail ->
                val FilmsDetail = filmsDetail.result
                namaitem.text = FilmsDetail.properties.title
                producerTxt.text = "Producer: " + FilmsDetail.properties.producer
                episodeTxt.text = "Episode: " + FilmsDetail.properties.episode_id.toString()
                directorTxt.text = "Director: " + FilmsDetail.properties.director
                releaseDateTxt.text = "Release Date: " + FilmsDetail.properties.release_date
                description.text ="Description: " + FilmsDetail.description
            }

        }else{
            namaitem.text = "Data tidak ditemukan"
        }

        return binding.root


    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: android.view.MenuInflater) {
        inflater.inflate(R.menu.menu_back, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list_back -> {
                val activity = requireActivity() as MainActivity
                activity.changePage(MainFragment())
            }
        }
        return super.onOptionsItemSelected(item)

        //referensi:
        //https://developer.android.com/guide/topics/ui/menus?hl=id
    }


}