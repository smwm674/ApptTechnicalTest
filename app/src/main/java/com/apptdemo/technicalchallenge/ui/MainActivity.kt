package com.apptdemo.technicalchallenge.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.apptdemo.technicalchallenge.utils.Utils.isValidData
import android.widget.Toast
import com.apptdemo.technicalchallenge.R
import com.apptdemo.technicalchallenge.databinding.ActivityMainBinding
import com.apptdemo.technicalchallenge.ui.map_fragment.MapsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var bindingMainActivity: ActivityMainBinding
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMainActivity.root)
        context = this@MainActivity

        with(bindingMainActivity) {
            submit.setOnClickListener(View.OnClickListener { view ->
                if (isValidData(latitude.text.toString(), longitude.text.toString()))
                    mapFragment (latitude.text.toString().toDouble(),longitude.text.toString().toDouble())
                else
                Toast.makeText(
                    context,
                    "Latitude and Longitude can not be null",
                    Toast.LENGTH_LONG
                ).show()
            })
        }
    }

    private fun mapFragment(latitude: Double, longitude: Double) {
        val bundle = Bundle()
        bundle.putDouble("latitude", latitude)
        bundle.putDouble("longitude", longitude)
        val mapsFragment = MapsFragment()
        mapsFragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.root_container, mapsFragment, mapsFragment.tag)
            .addToBackStack(mapsFragment.tag).commit()
    }
}