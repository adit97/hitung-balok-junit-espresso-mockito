package com.example.myunittesting.view

import com.example.myunittesting.util.CuboidClass

class MainViewModel(var cuboidClass: CuboidClass) {

    fun save(w: Double, h: Double, l: Double) {
        cuboidClass = CuboidClass(w, h, l)
    }

    fun getVolume(): Double {
        return cuboidClass.getVolume()
    }

    fun getCircumference(): Double {
        return cuboidClass.getCircumference()
    }

    fun getSurfaceArea(): Double {
        return cuboidClass.getSurfaceArea()
    }

}