package com.tugas.tubes2.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface IMainFragment {
    interface Presenter {

    }
    interface Ui{
        fun changePage(fragment: Fragment)


    }
}