package com.proto.presentation.screen.onboarding.pages

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.proto.R
import kotlinx.android.synthetic.main.fragment_onboarding_page_1.view.*

class Page1Fragment : Fragment() {

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 12345
        private const val LOCATION_PERMISSION = Manifest.permission.ACCESS_FINE_LOCATION
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_onboarding_page_1, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initGeoPermissionButton(view.geo_preference_button)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            LOCATION_PERMISSION_REQUEST_CODE -> {
                if (
                    grantResults.isNotEmpty() &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                    //permission granted
                    Toast.makeText(context, "permission granted!", Toast.LENGTH_LONG).show()
                } else {
                    //permission declined
                    Toast.makeText(context, "permission declined :(", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    /**
     *  Появился более краткий и удобный способ получить разрешение
     *  https://developer.android.com/training/permissions/requesting
     */
    private fun initGeoPermissionButton(button: Button) {
        context?.let { context ->
            when (ContextCompat.checkSelfPermission(context, LOCATION_PERMISSION)) {
                PackageManager.PERMISSION_GRANTED -> disablePermissionButton(button)
                PackageManager.PERMISSION_DENIED -> enablePermissionButton(button)
            }
        }
    }

    private fun enablePermissionButton(button: Button) {
        button.isEnabled = true
        button.setOnClickListener {
            requestPermissions(
                arrayOf(LOCATION_PERMISSION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        }
    }

    private fun disablePermissionButton(button: Button) {
        button.isEnabled = false
        button.text = resources.getString(R.string.onboarding_page_two_permission_btn_label_granted)
    }
}