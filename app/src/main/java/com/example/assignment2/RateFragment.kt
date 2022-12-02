package com.example.assignment2

import android.widget.*
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment


class RateFragment : DialogFragment(R.layout.fragment_rate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cancelbt : Button = view.findViewById(R.id.btnCancel);
        val submitbt : Button = view.findViewById(R.id.btnSubmit);
        val radioGroup = view.findViewById<RadioGroup>(R.id.RatingRadioGroup)
        cancelbt.setOnClickListener{
            dismiss()
        }
        submitbt.setOnClickListener {
            val selectedOption: Int = radioGroup.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedOption)
            Toast.makeText(context,"your rating was \'"+radioButton.text+"\' thanks!",Toast.LENGTH_LONG).show()
            dismiss()
        }
    }

}