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
import androidx.recyclerview.widget.RecyclerView
import com.tugas.tubes2.R
import com.tugas.tubes2.databinding.SpeciesDetailBinding
import com.tugas.tubes2.presenter.DetailPresenter

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
    private lateinit var presenter: DetailPresenter

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
        presenter = DetailPresenter()

        val bundle = this.arguments
        presenter.retriveDataSpecies(bundle, mainActivity, this, image, namaitem, classification, designation, averageHeight, averageLifeSpan, hairColor, skinColor, eyeColor, homeWorld, language, description, list)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: android.view.MenuInflater) {
        inflater.inflate(R.menu.menu_back, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list_back -> {
                activity?.supportFragmentManager?.popBackStack()
                return true
            }
        }
        return super.onOptionsItemSelected(item)

        //referensi:
        //https://developer.android.com/guide/topics/ui/menus?hl=id
    }
}