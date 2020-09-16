package com.proto.presentation.screen.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.proto.R
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        onboarding_viewpager.adapter = OnboardingAdapter(this)

        TabLayoutMediator(tab_layout, onboarding_viewpager) { _, _ -> }.attach() //индикатор
    }
}