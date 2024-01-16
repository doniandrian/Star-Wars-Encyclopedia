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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tugas.tubes2.APICall
import com.tugas.tubes2.BASE_IMAGE_URL
import com.tugas.tubes2.R
import com.tugas.tubes2.databinding.SpeciesDetailBinding


class SpeciesDetailFragment : Fragment() {
    private lateinit var binding: SpeciesDetailBinding
    private lateinit var namaitem: TextView
    private lateinit var image : ImageView
    private lateinit var classification: TextView
    private lateinit var designation: TextView
    private lateinit var averageHeight: TextView
    private lateinit var averageLifeSpan: TextView
    private lateinit var hairColor: TextView
    private lateinit var skinColor: TextView
    private lateinit var eyeColor: TextView
    private lateinit var homeWorld: TextView
    private lateinit var language: TextView
    private lateinit var description: TextView

    private lateinit var list: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SpeciesDetailBinding.inflate(inflater, container, false)
        namaitem = binding.namaItem
        image = binding.imageItem
        classification = binding.classification
        designation = binding.designation
        averageHeight = binding.averageHeight
        averageLifeSpan = binding.averageLifeSpan
        hairColor = binding.hairColor
        skinColor = binding.skinColor
        eyeColor = binding.eyeColor
        homeWorld = binding.homeWorld
        language = binding.language
        description = binding.description
        list = binding.listViewSpecies

        val mainActivity = activity as MainActivity
        val bundle = this.arguments
        if (bundle != null) {
            val url = bundle.getString("url")
            val nomor = url?.substringAfterLast("/")

            //glide
            Glide.with(this)
                .load("$BASE_IMAGE_URL/species/$nomor.jpg")
                .into(image)

            APICall.getSpeciesDetail(mainActivity, "species/$nomor") { speciesDetail ->
                val speciesDetailList = speciesDetail.result
                namaitem.text = speciesDetailList.properties.name
                classification.text = "Classification: " + speciesDetailList.properties.classification
                designation.text = "Designation: " + speciesDetailList.properties.designation
                averageHeight.text = "Average Height: " + speciesDetailList.properties.average_height
                averageLifeSpan.text = "Average Life Span: " + speciesDetailList.properties.average_lifespan
                hairColor.text = "Hair Color: " + speciesDetailList.properties.hair_colors
                skinColor.text = "Skin Color: " + speciesDetailList.properties.skin_colors
                eyeColor.text = "Eye Color: " + speciesDetailList.properties.eye_colors
                homeWorld.text = "HomeWorld: " + speciesDetailList.properties.homeworld
                language.text = "Language: " + speciesDetailList.properties.language
                description.text = "Description: " + speciesDetailList.description



                val peopleDetailAdapter = PeopleDetailAdapter(speciesDetailList.properties.people)
                list.apply {
                    layoutManager = LinearLayoutManager(activity)
                    setHasFixedSize(true)
                    peopleDetailAdapter.notifyDataSetChanged()
                    adapter = peopleDetailAdapter

                }


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