package com.lwemzy.cvApplication.ui.conf

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.lwemzy.cvApplication.R
import kotlinx.android.synthetic.main.fragment_home_conf.*
import kotlinx.android.synthetic.main.fragment_home_conf.view.*

class ConfigurationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val configurationFragment = inflater.inflate(R.layout.fragment_home_conf, container, false)

        configurationFragment.btn_add_conf.setOnClickListener {
            val configPreferences = activity?.getSharedPreferences("home", Context.MODE_PRIVATE)
            val editor = configPreferences?.edit()
            editor?.putString("name", conf_name.text.toString())
            editor?.putString("qualification", conf_qual.text.toString())
            editor?.putString("position", conf_pos.text.toString())
            editor?.putString("linkedIn", config_linkedin.text.toString())
            editor?.apply()
            clearFields()

            Toast.makeText(context, "saved successfully", Toast.LENGTH_LONG).show()
        }

        return configurationFragment
    }

    private fun clearFields() {
        conf_name.text.clear()
        conf_qual.text.clear()
        conf_pos.text.clear()
        config_linkedin.text.clear()
    }
}