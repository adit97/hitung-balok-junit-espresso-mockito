package com.example.myunittesting.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.myunittesting.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    private val dummyVolume = "504.0"
    private val dummyCircumference = "2016.0"
    private val dummySurfaceArea = "266.0"

    private val dummyWidth = "7"
    private val dummyHeight = "6"
    private val dummyLength = "12"

    private val emptyInput = ""
    private val fieldEmpty = "Field ini tidak boleh kosong"

    @Rule @JvmField
    val mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun getCircumference() {
        onView(withId(R.id.etPanjang)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.etLebar)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.etTinggi)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btnSimpan)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSimpan)).perform(click())

        onView(withId(R.id.btnHitungKeliling)).check(matches(isDisplayed()))
        onView(withId(R.id.btnHitungKeliling)).perform(click())

        onView(withId(R.id.tvHasil)).check(matches(isDisplayed()))
        onView(withId(R.id.tvHasil)).check(matches(withText(dummyCircumference)))
    }

    @Test
    fun emptyInput() {
        onView(withId(R.id.etPanjang)).perform(typeText(emptyInput), closeSoftKeyboard())

        onView(withId(R.id.btnSimpan)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSimpan)).perform(click())

        onView(withId(R.id.etPanjang)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.etPanjang)).perform(typeText(dummyLength), closeSoftKeyboard())

        onView(withId(R.id.etLebar)).perform(typeText(emptyInput), closeSoftKeyboard())
        onView(withId(R.id.btnSimpan)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSimpan)).perform(click())

        onView(withId(R.id.etLebar)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.etLebar)).perform(typeText(dummyWidth), closeSoftKeyboard())

        onView(withId(R.id.etTinggi)).perform(typeText(emptyInput), closeSoftKeyboard())

        onView(withId(R.id.btnSimpan)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSimpan)).perform(click())

        onView(withId(R.id.etTinggi)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.etTinggi)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btnSimpan)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSimpan)).perform(click())

        onView(withId(R.id.btnHitungKeliling)).check(matches(isDisplayed()))
        onView(withId(R.id.btnHitungKeliling)).perform(click())

        onView(withId(R.id.tvHasil)).check(matches(isDisplayed()))
        onView(withId(R.id.tvHasil)).check(matches(withText(dummyCircumference)))
    }
}