package com.proto.screens.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.proto.screens.onboarding.pages.Page0Fragment
import com.proto.screens.onboarding.pages.Page1Fragment
import com.proto.screens.onboarding.pages.Page2Fragment

class OnboardingAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> Page0Fragment()
        1 -> Page1Fragment()
        else -> Page2Fragment()
    }
}