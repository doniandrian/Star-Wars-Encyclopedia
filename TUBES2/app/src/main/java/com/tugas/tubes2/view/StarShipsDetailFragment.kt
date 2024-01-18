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
import com.tugas.tubes2.databinding.StarShipsDetailBinding


class StarShipsDetailFragment : Fragment() {
    private lateinit var binding: StarShipsDetailBinding
    private lateinit var namaitem: TextView
    private lateinit var image : ImageView
    private lateinit var modelTxt: TextView
    private lateinit var starShipClass: TextView
    private lateinit var manufacturer: TextView
    private lateinit var costInCredit: TextView
    private lateinit var length: TextView
    private lateinit var crew: TextView
    private lateinit var passenger: TextView
    private lateinit var hyperDriveRating: TextView
    private lateinit var MGLT: TextView
    private lateinit var cargoCap: TextView
    private lateinit var consumables: TextView
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
        binding = StarShipsDetailBinding.inflate(inflater, container, false)
        namaitem = binding.namaItem
        image = binding.imageItem
        modelTxt = binding.modelTxt
        starShipClass = binding.starShipClass
        manufacturer = binding.manufacturer
        costInCredit = binding.costInCredit
        length = binding.length
        crew = binding.crew
        passenger = binding.passenger
        hyperDriveRating = binding.hyperDriveRating
        MGLT = binding.MGLT
        cargoCap = binding.cargoCap
        consumables = binding.consumables
        description = binding.description


        val mainActivity = activity as MainActivity
        val bundle = this.arguments
        if (bundle != null) {
            val url = bundle.getString("url")
            val nomor = url?.substringAfterLast("/")

            //glide
            Glide.with(this)
                .load("$BASE_IMAGE_URL/starships/$nomor.jpg")
                .error(R.drawable.picture_error_icon)
                .into(image)

            APICall.getStarshipsDetail(mainActivity, "starships/$nomor") { starshipsDetail ->
                val starShipDetail = starshipsDetail.result
                namaitem.text = starShipDetail.properties.name
                modelTxt.text = "Model: " + starShipDetail.properties.model
                starShipClass.text = "Starship Class: " + starShipDetail.properties.starship_class
                manufacturer.text = "Manufacturer: " + starShipDetail.properties.manufacturer
                costInCredit.text = "Cost In Credit: " + starShipDetail.properties.cost_in_credits
                length.text = "Length: " + starShipDetail.properties.length
                crew.text = "Crew: " + starShipDetail.properties.crew
                passenger.text = "Passenger: " + starShipDetail.properties.passengers
                hyperDriveRating.text = "Hyperdrive Rating: " + starShipDetail.properties.hyperdrive_rating
                MGLT.text = "MGLT: " + starShipDetail.properties.MGLT
                cargoCap.text = "Cargo Capacity: " + starShipDetail.properties.cargo_capacity
                consumables.text = "Consumables: " + starShipDetail.properties.consumables
                description.text = "Description: " + starShipDetail.description

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