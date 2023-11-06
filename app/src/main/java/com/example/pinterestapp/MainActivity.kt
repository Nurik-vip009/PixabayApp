package com.example.pinterestapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorlove.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PixabayView {

    private val presenter = PixabayPresenter(this)
    private lateinit var binding: ActivityMainBinding
    private val imageAdapter = ImageAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.attachView(this)

        binding.searchButton.setOnClickListener {
            val query = binding.searchEditText.text.toString()
            presenter.searchImages(query)
        }
    }
    override fun showImages(images: ArrayList<ImageModel>) {
        imageAdapter.addImage(images)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}