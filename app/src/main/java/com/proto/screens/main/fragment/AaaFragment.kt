package com.proto.screens.main.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.proto.R

//TODO: список элементов из сети, с лоадером, плейсхолдером, пагинацией, pull-to-refresh
//TODO: с переходом на детальную страницу и передачей туда параметров
class AaaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_aaa, container, false)
}