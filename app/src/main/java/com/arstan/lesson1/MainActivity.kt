package com.arstan.lesson1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var button : Button
    lateinit var et : EditText
    lateinit var etText : String

    var resultLauncher = registerForActivityResult(ActivityResultContracts
        .StartActivityForResult()) {result ->}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et = findViewById(R.id.et_type)
        button = findViewById(R.id.btn)
        etText = intent.getStringExtra("key2").toString()

        val intent = Intent(this, SecondActivity::class.java)

        if (etText == "null"){
        }else{
            et.hint = etText
        }

        button.setOnClickListener(View.OnClickListener {
            if (et.text.isEmpty()){

                Toast.makeText(this, "type text", Toast.LENGTH_LONG).show()

            } else {

                intent.putExtra("key1", et.text.toString())
                resultLauncher.launch(intent)

            }
        })

    }
}