package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.btnGo);
        val txtEdit: EditText = findViewById(R.id.edtxtValue);
        val txtView: TextView = findViewById(R.id.txtResult);

        var flag:String = "USD to Jod";
        val spinner: Spinner = findViewById(R.id.spUnit);
        var options = arrayOf("USD to Jod","Jod to USD","USD to Euro","Euro to USD","USD to Ruble","Ruble to USD");

        spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options);
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2);
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        button.setOnClickListener{view->
            var value:Double = txtEdit.text.toString().toDouble();

            when(flag){
                "USD to Jod"-> txtView.text = String.format("%.2f",(value*0.7).toBigDecimal()) + " Jod";
                "Jod to USD"-> txtView.text = String.format("%.2f",(value*1.41).toBigDecimal()) + " USD";
                "USD to Euro"-> txtView.text = String.format("%.2f",(value*0.92).toBigDecimal())  + " Euro";
                "Euro to USD"-> txtView.text = String.format("%.2f",(value*1.08).toBigDecimal())  + " USD";
                "USD to Ruble"-> txtView.text = String.format("%.2f",(value*68.95).toBigDecimal())  + " Ruble";
                "Ruble to USD"-> txtView.text = String.format("%.2f",(value*0.015).toBigDecimal())  + " USD";


            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var dialog_rate = UsedFragment()
        var dialog_contact = ContactFragment()
        when(item.itemId){
            R.id.Currancy -> dialog_rate.show(supportFragmentManager, "rate Dialog")
            R.id.Contact -> dialog_contact.show(supportFragmentManager, "contact Dialog")
        }
        return true;
    }


}


