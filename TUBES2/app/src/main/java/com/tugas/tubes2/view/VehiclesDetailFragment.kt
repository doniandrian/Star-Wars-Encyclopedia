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
import com.tugas.tubes2.databinding.VehiclesDetailBinding


class VehiclesDetailFragment : Fragment() {
    private lateinit var binding: VehiclesDetailBinding
    private lateinit var namaitem: TextView
    private lateinit var image : ImageView
    private lateinit var model: TextView
    private lateinit var vehicleClass: TextView
    private lateinit var manufacturer: TextView
    private lateinit var costInCredit: TextView
    private lateinit var length: TextView
    private lateinit var crew: TextView
    private lateinit var passenger: TextView
    private lateinit var maxSpeed: TextView
    private lateinit var cargoCapacity: TextView
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
        binding = VehiclesDetailBinding.inflate(inflater, container, false)
        namaitem = binding.namaItem
        image = binding.imageItem
        model = binding.model
        vehicleClass = binding.vehicleClass
        manufacturer = binding.manufacturer
        costInCredit = binding.costInCredit
        length = binding.length
        crew = binding.crew
        passenger = binding.passenger
        maxSpeed = binding.maxSpeed
        cargoCapacity = binding.cargoCapacity
        consumables = binding.consumables
        description = binding.description


        val mainActivity = activity as MainActivity
        val bundle = this.arguments
        if (bundle != null) {
            val url = bundle.getString("url")
            val nomor = url?.substringAfterLast("/")

            //glide
            Glide.with(this)
                .load("$BASE_IMAGE_URL/vehicles/$nomor.jpg")
                .into(image)

            APICall.getVehiclesDetail(mainActivity, "vehicles/$nomor") { vehilesDetail ->
                val vehiclesDetails = vehilesDetail.result
                namaitem.text = vehiclesDetails.properties.name
                model.text = "Model: " + vehiclesDetails.properties.model
                vehicleClass.text = "Vehicle Class: " + vehiclesDetails.properties.vehicle_class
                manufacturer.text = "Manufacturer: " + vehiclesDetails.properties.manufacturer
                costInCredit.text = "Cost In Credit: " + vehiclesDetails.properties.cost_in_credits
                length.text = "Length: " + vehiclesDetails.properties.length
                crew.text = "Crew: " + vehiclesDetails.properties.crew
                passenger.text = "Passenger: " + vehiclesDetails.properties.passengers
                maxSpeed.text = "Max Speed: " + vehiclesDetails.properties.max_atmosphering_speed
                cargoCapacity.text = "Cargo Capacity: " + vehiclesDetails.properties.cargo_capacity
                consumables.text = "Consumables: " + vehiclesDetails.properties.consumables
                description.text = "Description: " + vehiclesDetails.description

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