package com.arstan.lesson1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.arstan.lesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var etText: String

    var resultLauncher = registerForActivityResult(
        ActivityResultContracts
            .StartActivityForResult()
    ) { result -> }

    companion object{
        private const val KEY1_ = "key1"
        private const val KEY2_ = "key2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        etText = intent.getStringExtra(KEY2_).toString()

        val intent = Intent(this, SecondActivity::class.java)

        if (etText != "null") {
            binding.etType.hint = etText
        }

        binding.btn.setOnClickListener(View.OnClickListener {
            if (binding.etType.text.isEmpty()) {
                Toast.makeText(this, "type text", Toast.LENGTH_LONG).show()
            } else {

                intent.putExtra(KEY1_, binding.etType.text.toString())
                resultLauncher.launch(intent)
            }
        })

    }
}