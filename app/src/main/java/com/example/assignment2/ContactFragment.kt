package com.example.assignment2

import android.widget.*
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment


class ContactFragment : DialogFragment(R.layout.fragment_contact) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val okbt : Button = view.findViewById(R.id.btnOk);

        okbt.setOnClickListener{
            dismiss()
        }
    }

}