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
import com.tugas.tubes2.R
import com.tugas.tubes2.databinding.PeopleDetailBinding
import com.tugas.tubes2.presenter.DetailPresenter


class PeopleDetailFragment : Fragment() {
    private lateinit var binding: PeopleDetailBinding
    private lateinit var namaitem: TextView
    private lateinit var image : ImageView
    private lateinit var height: TextView
    private lateinit var mass: TextView
    private lateinit var haircolor: TextView
    private lateinit var skincolor: TextView
    private lateinit var eyecolor: TextView
    private lateinit var birthyear: TextView
    private lateinit var gender: TextView
    private lateinit var homeworld: TextView
    private lateinit var description: TextView
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
        binding = PeopleDetailBinding.inflate(inflater, container, false)
        namaitem = binding.namaItem
        image = binding.imageItem
        height = binding.heightTxt
        mass = binding.massTxt
        haircolor = binding.hairColorTxt
        skincolor = binding.skinColorTxt
        eyecolor = binding.eyeColorTxt
        birthyear = binding.birthYearTxt
        gender = binding.genderTxt
        homeworld = binding.homeWorldTxt
        description = binding.description

        val mainActivity = activity as MainActivity
        presenter = DetailPresenter()


        //retrive data from bundle
        val bundle = this.arguments
        presenter.retriveDataPeople(bundle, image, mainActivity, this, namaitem, height, mass, haircolor, skincolor, eyecolor, birthyear, gender, homeworld, description)
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