package com.example.myunittesting.view

import com.example.myunittesting.util.CuboidClass
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.Mockito.`when`

class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var cuboidClass: CuboidClass

    private val dummyVolume = 504.0
    private val dummyCircumference = 2016.0
    private val dummySurfaceArea = 266.0

    private val dummyWidth = 7.0
    private val dummyHeight = 6.0
    private val dummyLength = 12.0

    @Before
    fun before() {
        cuboidClass = mock(CuboidClass::class.java)
        mainViewModel = MainViewModel(cuboidClass)
    }

    @Test
    fun testVolume() {
        cuboidClass = CuboidClass()
        mainViewModel = MainViewModel(cuboidClass)
        mainViewModel.save(dummyWidth, dummyHeight, dummyLength)
        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun testCircumference() {
        cuboidClass = CuboidClass()
        mainViewModel = MainViewModel(cuboidClass)
        mainViewModel.save(dummyWidth, dummyHeight, dummyLength)
        val circumference = mainViewModel.getCircumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }

    @Test
    fun testSurfaceArea() {
        cuboidClass = CuboidClass()
        mainViewModel = MainViewModel(cuboidClass)
        mainViewModel.save(dummyWidth, dummyHeight, dummyLength)
        val surfaceArea = mainViewModel.getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

    @Test
    fun testMockVolume() {
        `when`(mainViewModel.getVolume()).thenReturn(dummyVolume)
        val volume = mainViewModel.getVolume()

        verify(cuboidClass).getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun testMockCircum() {
        `when`(mainViewModel.getCircumference()).thenReturn(dummyCircumference)
        val circumference = mainViewModel.getCircumference()

        verify(cuboidClass).getCircumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }

    @Test
    fun testMockSurface() {
        `when`(mainViewModel.getSurfaceArea()).thenReturn(dummySurfaceArea)
        val surfaceArea = mainViewModel.getSurfaceArea()

        verify(cuboidClass).getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }
}