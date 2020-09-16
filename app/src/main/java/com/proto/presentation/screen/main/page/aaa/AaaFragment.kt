package com.proto.presentation.screen.main.page.aaa

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.proto.R
import com.proto.presentation.screen.main.page.aaa.AaaViewModel.State
import com.proto.utils.BaseFragment
import com.proto.utils.gone
import com.proto.utils.show
import kotlinx.android.synthetic.main.fragment_aaa.*

//TODO: список элементов из сети, с лоадером, плейсхолдером, пагинацией, pull-to-refresh
//TODO: с переходом на детальную страницу и передачей туда параметров
class AaaFragment : BaseFragment(R.layout.fragment_aaa) {

    private lateinit var viewModel: AaaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AaaViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        viewModel.data.observe(viewLifecycleOwner, Observer { state -> onStateUpdated(state) })
        viewModel.onStart()
    }

    private fun onStateUpdated(state: State) = when (state) {
        is State.Loading -> {
            progress_bar.show()
            tv_content.gone()
            tv_placeholder.gone()
        }
        is State.Empty -> {
            progress_bar.gone()
            tv_content.gone()
            tv_placeholder.show()
        }
        is State.Error -> {
            progress_bar.gone()
            tv_content.gone()
            tv_placeholder.gone()
            //todo: show error dialog
        }
        is State.Content -> {
            progress_bar.gone()
            tv_content.show()
            tv_placeholder.gone()
        }
    }
}