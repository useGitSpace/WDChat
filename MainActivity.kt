package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    internal var dbHelper= DatabaseHelper(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // get reference to button
        val btn_click_me = findViewById<Button>(R.id.register)
        var editTextName = findViewById<EditText>(R.id.editText)
        // set on-click listener
        btn_click_me.setOnClickListener {
            // your code to perform when the user clicks on the button
            //  Toast.makeText(this@MainActivity, "Welcome", Toast.LENGTH_SHORT).show()

            if (editTextName.length() > 0) {
                Toast.makeText(this, "Welcome " + editTextName.text, Toast.LENGTH_SHORT).show()

                handleInserts(editTextName)


                val intent = Intent(this, Main2Activity::class.java)
                finish()
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter your name.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Main2Activity::class.java)    // change in production
                finish()
                startActivity(intent)   //change in production

            }
        }
    }

    private fun handleInserts(name: EditText){
            try {
                dbHelper.insertIntoUserInfo(name.text.toString(),"0000000000")
            }
            catch (e:Exception){

            }
    }
}
