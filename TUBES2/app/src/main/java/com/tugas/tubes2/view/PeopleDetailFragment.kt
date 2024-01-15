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
import com.tugas.tubes2.databinding.PeopleDetailBinding


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

        //retrive data from bundle
        val bundle = this.arguments
        if (bundle != null) {
            val url = bundle.getString("url")
            val nomor = url?.substringAfterLast("/")
            //glide
            Glide.with(this)
                .load("$BASE_IMAGE_URL/characters/$nomor.jpg")
                .into(image)

            APICall.getPeopleDetail(mainActivity, "people/$nomor") { PeopleDetail ->
                val peopleDetail = PeopleDetail.result
                namaitem.text = peopleDetail.properties.name
                height.text ="Height: " + peopleDetail.properties.height
                mass.text = "Mass: " +peopleDetail.properties.mass
                haircolor.text ="Hair Color: " + peopleDetail.properties.hair_color
                skincolor.text = "Skin Color: " +peopleDetail.properties.skin_color
                eyecolor.text = "Eye Color: " +peopleDetail.properties.eye_color
                birthyear.text ="BirthYear: " + peopleDetail.properties.birth_year
                gender.text ="Gender: " + peopleDetail.properties.gender
                homeworld.text ="HomeWorld: " + peopleDetail.properties.homeworld
                description.text ="Description: " + peopleDetail.description

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