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
import com.tugas.tubes2.databinding.StarShipsDetailBinding
import com.tugas.tubes2.presenter.DetailPresenter


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
        presenter = DetailPresenter()

        val bundle = this.arguments
        presenter.retriveDataStarShips(bundle, mainActivity, this, image, namaitem, modelTxt, starShipClass, manufacturer, costInCredit, length, crew, passenger, hyperDriveRating, MGLT, cargoCap, consumables, description)
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