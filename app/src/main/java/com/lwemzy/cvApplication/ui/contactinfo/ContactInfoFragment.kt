package com.lwemzy.cvApplication.ui.contactinfo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.lwemzy.cvApplication.R
import kotlinx.android.synthetic.main.fragment_contacts.*
import kotlinx.android.synthetic.main.fragment_contacts.view.*

class ContactInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val contactsFragment = inflater.inflate(R.layout.fragment_contacts, container, false)

        val preferences = activity?.getSharedPreferences("contact_info", Context.MODE_PRIVATE)

        contactsFragment.btn_contact_add.setOnClickListener() {
            val address: String? = contact_address.text.toString()
            val phone: String? = contact_phone.text.toString()
            val email: String? = contact_email.text.toString()

            val edit = preferences?.edit()
            edit?.putString("address", address)
            edit?.putString("phone", phone)
            edit?.putString("email", email)
            edit?.apply()
            Toast.makeText(activity, "Data Saved", Toast.LENGTH_LONG).show()
            clear()
            displayContact();
        }

        contactsFragment.contacts_card.setOnClickListener {
            contact_phone.setText(preferences?.getString("phone", ""))
            contact_address.setText(preferences?.getString("address", ""))
            contact_email.setText(preferences?.getString("email", ""))
        }

        return contactsFragment
    }

    override fun onStart() {
        super.onStart()
        displayContact();

    }

    private fun displayContact() {
        var phone: String? = null
        var address: String? = null
        var email: String? = null

        val sharedPreferences = activity?.getSharedPreferences("contact_info", Context.MODE_PRIVATE)
        phone = sharedPreferences?.getString("phone", null)
        address = sharedPreferences?.getString("address", null)
        email = sharedPreferences?.getString("email", null)

        personal_address?.text = address
        phone_number?.text = phone
        personal_email?.text = email

    }

    private fun clear() {
        contact_address.text.clear()
        contact_phone.text.clear()
        contact_email.text.clear()
    }
}