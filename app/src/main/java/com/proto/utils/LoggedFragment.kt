package com.proto.utils

import android.content.Context
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment

open class LoggedFragment : Fragment() {

    companion object {
        private const val TAG = "lifecycle"
    }

    init {
        log("init")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        log("onActivityCreated")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        log("onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        log("onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        log("onStart")
    }

    override fun onResume() {
        super.onResume()
        log("onResume")
    }

    override fun onPause() {
        super.onPause()
        log("onPause")
    }

    override fun onStop() {
        super.onStop()
        log("onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        log("onSaveInstanceState")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("onDestroy")
    }

    private fun log(event : String) {
        val className = this::class.simpleName
        val objectHash = System.identityHashCode(this)
        val threadId = Thread.currentThread().id
        val isThreadMain = when (Thread.currentThread()) {
            Looper.getMainLooper().thread -> "is UI"
            else -> "is not UI"
        }
        Log.d(TAG, "[Class:$className:$objectHash][Thread $isThreadMain; id=$threadId] $event")
    }
}