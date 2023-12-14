package com.demo.quoteabletest

import android.content.Intent
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.hamcrest.core.AllOf.*

class SplashScreenTest {

    @get:Rule
    val activityRule = activityScenarioRule<SplashScreen>()

    @Test
    fun onCloudClick_startAnimation() {
        onView(withId(R.id.ic_cloud)).perform(click())
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
    }

    @Test
    fun onCloudClick_WaitAndIntentMovetoNextActivity(){
        Thread.sleep(7000)
        onView(withId(R.id.quoteRecyclerView)).check(matches(isDisplayed()))
    }

}