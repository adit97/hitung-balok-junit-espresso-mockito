package com.example.myunittesting.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myunittesting.R
import com.example.myunittesting.util.CuboidClass
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainViewModel = MainViewModel(CuboidClass())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {

        onClickButton()

    }

    private fun onClickButton() {

        btnSimpan.setOnClickListener {

            when {
                etPanjang.text.isEmpty() -> etPanjang.error = "Field ini tidak boleh kosong"
                etLebar.text.isEmpty() -> etLebar.error = "Field ini tidak boleh kosong"
                etTinggi.text.isEmpty() -> etTinggi.error = "Field ini tidak boleh kosong"
                else -> {
                    view()

                    val width: Double = etLebar.text.toString().toDouble()
                    val height: Double = etTinggi.text.toString().toDouble()
                    val length: Double = etPanjang.text.toString().toDouble()

                    mainViewModel.save(width, height, length)
                }
            }

        }

        btnHitungKeliling.setOnClickListener {
            gone()
            tvHasil.text = mainViewModel.getCircumference().toString()
        }

        btnHitungLuas.setOnClickListener {
            gone()
            tvHasil.text = mainViewModel.getSurfaceArea().toString()
        }

        btnHitungVolume.setOnClickListener {
            gone()
            tvHasil.text = mainViewModel.getVolume().toString()
        }
    }

    private fun gone() {
        btnSimpan.visibility = View.VISIBLE
        linearLayout.visibility = View.GONE
    }

    private fun view() {
        btnSimpan.visibility = View.GONE
        linearLayout.visibility = View.VISIBLE
    }
}
