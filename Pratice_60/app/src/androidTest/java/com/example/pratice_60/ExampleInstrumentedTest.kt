package com.example.pratice_60

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.pratice_60", appContext.packageName)
    }

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule<MainActivity>(MainActivity::class.java)

    @Test
    fun quadraticEquationCalculationTestOne(){
        onView(withId(R.id.aValue)).perform(typeText("1"))
        onView(withId(R.id.bValue)).perform(typeText("12"))
        onView(withId(R.id.cValue)).perform(typeText("36"))

        onView(withId(R.id.calculateButton)).perform(click())
        onView(withId(R.id.resultBlock)).check(matches(withText("x = -6")))
    }

    @Test
    fun quadraticEquationCalculationTestTwo(){
        onView(withId(R.id.aValue)).perform(typeText("0"))
        onView(withId(R.id.bValue)).perform(typeText("5"))
        onView(withId(R.id.cValue)).perform(typeText("-10"))

        onView(withId(R.id.calculateButton)).perform(click())
        onView(withId(R.id.resultBlock)).check(matches(withText("x = 2")))
    }

    @Test
    fun quadraticEquationCalculationTestThree(){
        onView(withId(R.id.aValue)).perform(typeText("1"))
        onView(withId(R.id.bValue)).perform(typeText("-7"))
        onView(withId(R.id.cValue)).perform(typeText("0"))

        onView(withId(R.id.calculateButton)).perform(click())
        onView(withId(R.id.resultBlock)).check(matches(withText("first x = -5; second x = 3")))
    }

    @Test
    fun quadraticEquationCalculationTestFour(){
        onView(withId(R.id.aValue)).perform(typeText("4"))
        onView(withId(R.id.bValue)).perform(typeText("0"))
        onView(withId(R.id.cValue)).perform(typeText("-9"))

        onView(withId(R.id.calculateButton)).perform(click())
        onView(withId(R.id.resultBlock)).check(matches(withText("x = +/-1")))
    }
}