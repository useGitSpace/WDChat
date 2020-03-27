package com.example.myapp.ui.ledger

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.R
import kotlinx.android.synthetic.main.activity_take_input.*


class TakeInput : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_input)

        // Single checked box

    }

    fun onCheckboxClicked(view: View) {
        var checked = view as CheckBox

    }
    fun message(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }

    fun onButtonClick(view: View) {
        var location = text_location.text.toString()
        if(location.isNullOrEmpty()){
            text_location.requestFocus()
            return;
        }
        var landmark = text_landmark.text.toString()
        val intent = Intent()
        arrayOf(location, landmark)
        intent.putExtra("Location", location)
        intent.putExtra("Landmark", landmark)
        setResult(7070, intent)
        finish()
        this.finish()

    }

}
