package com.agoda.sample

import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.runner.AndroidJUnit4
import com.agoda.sample.screen.IntentActivityScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class IntentActivityTest {
    @Rule
    @JvmField
    val rule = IntentsTestRule(IntentActivity::class.java)

    val screen = IntentActivityScreen()

    @Test
    fun testContentScreen() {
        screen {
            resultText { hasText("No result") }

            startActivityButton { click() }
            normalIntent { intended() }
            pressBack()

            okResultIntent { intending() }
            startActivityForResultButton { click() }
            resultText { hasText("SUCCESS") }

            errorResultIntent { intending() }
            startActivityForResultButton { click() }
            resultText { hasText("null") }
        }
    }
}