package com.lwemzy.cvApplication.ui.about

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lwemzy.cvApplication.R
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_about.view.*

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val aboutFragment = inflater.inflate(R.layout.fragment_about, container, false)

        val preferences = activity?.getSharedPreferences("profession", Context.MODE_PRIVATE)

        aboutFragment.btn_about_add.setOnClickListener {
            val editor = preferences?.edit()
            editor?.putString("name", about_pro.text.toString())
            editor?.putString("school", about_school.text.toString())
            editor?.putString("year", about_year.text.toString())
            editor?.apply()
            clearFields()
            displayInfo()
        }

        aboutFragment.card_view.setOnClickListener{
            about_pro.setText(preferences?.getString("name", ""))
            about_school.setText(preferences?.getString("school", ""))
            about_year.setText(preferences?.getString("year", ""))
        }

        return aboutFragment
    }

    private fun clearFields() {
        about_pro.text.clear()
        about_school.text.clear()
        about_year.text.clear()
    }

    override fun onStart() {
        super.onStart()
        displayInfo()
    }

    private fun displayInfo() {
        var name: String? = ""
        var school: String? = ""
        var year: String? = ""

        val spf = activity?.getSharedPreferences("profession", Context.MODE_PRIVATE)
        name = spf?.getString("name", "")
        school = spf?.getString("school", "")
        year = spf?.getString("year", "")

        project_name?.text = name
        school_attended?.text = school
        school_year?.text = year
    }
}