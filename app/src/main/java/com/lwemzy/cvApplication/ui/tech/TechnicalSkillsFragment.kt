package com.lwemzy.cvApplication.ui.tech


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.lwemzy.cvApplication.R
import kotlinx.android.synthetic.main.fragment_technical_skills.*
import kotlinx.android.synthetic.main.fragment_technical_skills.view.*


class TechnicalSkillsFragment : Fragment() {
    private var selectedType = "General"

    private val types = arrayOf(
        "General",
        "Web",
        "Web Services",
        "Web and Application Servers",
        "Frameworks",
        "Databases",
        "Design Patterns",
        "SDLC",
        "Tools",
        "Platforms",
        "Big Data"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val technicalSkillsFragment = inflater.inflate(R.layout.fragment_technical_skills, container, false)
        val spinner = technicalSkillsFragment.findViewById<Spinner>(R.id.spinner)

        spinner?.adapter = ArrayAdapter(
            activity!!.applicationContext,
            R.layout.support_simple_spinner_dropdown_item,
            types
        ) as SpinnerAdapter

        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("error")
                selectedType = "General"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedType = parent?.getItemAtPosition(position).toString()
                println(selectedType)
            }
        }

        technicalSkillsFragment.submit.setOnClickListener {
            val spf = activity?.getSharedPreferences("tec", Context.MODE_PRIVATE)

            val spe = spf?.edit()
            spe?.putString(
                selectedType,
                spf.getString(selectedType, "") + et1.text.toString() + ", "
            )
            spe?.apply()

            et1.text.clear()
            display();
        }

        return technicalSkillsFragment
    }

    override fun onStart() {
        super.onStart()
        display();
    }

    private fun display() {

        var str = ""
        var spf: SharedPreferences? = null
        var name: String? = ""
        types.forEach {
            spf = activity?.getSharedPreferences("tec", Context.MODE_PRIVATE)
            name = spf?.getString(it, null)
            if (name != null)
                str += it + " : " + name.toString().removeSuffix(",") + " \n "
        }
        tv.text = str
    }
}