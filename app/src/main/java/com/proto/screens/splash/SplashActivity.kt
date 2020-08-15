package com.proto.screens.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proto.R
import com.proto.screens.onboarding.OnboardingActivity
import kotlinx.coroutines.*
import kotlin.concurrent.thread

/**
 * Хорошая статья про стартовые экраны — https://habr.com/ru/post/345380/
 */

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        someDataLoadingSimulation()
    }

    private fun someDataLoadingSimulation() {
        processingWithCoroutines()
    }

    private fun processingWithCoroutines() {
        GlobalScope.launch {
            delay(3000L)
            navigateToOnboardingScreen()
        }
    }

    private fun processingWithThreads(){
        thread {
            Thread.sleep(3000L)
            runOnUiThread { navigateToOnboardingScreen() }
        }
    }

    private fun navigateToOnboardingScreen() {
        startActivity(Intent(this, OnboardingActivity::class.java))
        finish()
    }

}