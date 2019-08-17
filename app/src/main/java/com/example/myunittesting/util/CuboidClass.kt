package com.example.myunittesting.util

open class CuboidClass(private val width: Double = 0.0, private val height: Double = 0.0, private val length: Double = 0.0) {

    open fun getVolume(): Double {
        return width * height * length
    }

    open fun getSurfaceArea(): Double {
        return 2 * ((width * height) + (width + length) + (height * length))
    }

    open fun getCircumference(): Double {
        return 4 * (width * height * length)
    }
}