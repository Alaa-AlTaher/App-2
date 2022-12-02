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

        var flag:String = "kg to lb";
        val spinner: Spinner = findViewById(R.id.spUnit);
        var options = arrayOf("kg to lb","lb to kg","km to mile","mile to km","m to ft","ft to m","cm to inch","inch to cm");

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
                "kg to lb"-> txtView.text = String.format("%.2f",(value*2.2).toBigDecimal()) + " lb";
                "lb to kg"-> txtView.text = String.format("%.2f",(value/2.2).toBigDecimal()) + " kg";
                "km to mile"-> txtView.text = String.format("%.2f",(value/1.609344).toBigDecimal())  + " mile";
                "mile to km"-> txtView.text = String.format("%.2f",(value*1.609344).toBigDecimal())  + " km";
                "m to ft"-> txtView.text = String.format("%.2f",(value*3.28084).toBigDecimal())  + " ft";
                "ft to m"-> txtView.text = String.format("%.2f",(value/3.28084).toBigDecimal())  + " m";
                "cm to inch"-> txtView.text = String.format("%.2f",(value*0.393701).toBigDecimal())  + " inch";
                "inch to cm"-> txtView.text = String.format("%.2f",(value/0.393701).toBigDecimal())  + " cm";

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var dialog_rate = RateFragment()
        var dialog_contact = ContactFragment()
        when(item.itemId){
            R.id.Rate -> dialog_rate.show(supportFragmentManager, "rate Dialog")
            R.id.Contact -> dialog_contact.show(supportFragmentManager, "contact Dialog")
        }
        return true;
    }


}


