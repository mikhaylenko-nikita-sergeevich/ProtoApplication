package com.proto.presentation.screen.onboarding.pages

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.proto.R
import com.proto.presentation.screen.main.MainActivity
import kotlinx.android.synthetic.main.fragment_onboarding_page_2.view.*

class Page2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_onboarding_page_2, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.accept_button.setOnClickListener {
            navigateToMainScreen()
        }
    }

    private fun navigateToMainScreen(){
        startActivity(Intent(context, MainActivity::class.java))
        activity?.finish()
    }
}