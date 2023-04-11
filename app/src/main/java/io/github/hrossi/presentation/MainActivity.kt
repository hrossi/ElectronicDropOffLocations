package io.github.hrossi.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.hrossi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityMainBinding.inflate(layoutInflater).also {
            binding = it
            setContentView(it.root)
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}