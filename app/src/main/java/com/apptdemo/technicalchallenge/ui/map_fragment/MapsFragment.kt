package com.apptdemo.technicalchallenge.ui.map_fragment

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apptdemo.technicalchallenge.R
import com.apptdemo.technicalchallenge.databinding.FragmentMapsBinding

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

private const val Latitude = "latitude"
private const val Longitude = "longitude"

class MapsFragment : Fragment() {
    private var latitude: Double? = null
    private var longitude: Double? = null
    private lateinit var binding: FragmentMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            latitude = it.getDouble(Latitude)
            longitude = it.getDouble(Longitude)
        }
    }
    private val callback = OnMapReadyCallback { googleMap ->
        val sydney = LatLng(latitude!!, longitude!!)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapsBinding.inflate(inflater, container, false)
        binding.submit.setOnClickListener(View.OnClickListener { view ->
            getParentFragmentManager().popBackStackImmediate()
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    companion object {
        @JvmStatic
        fun newInstance(
            latitude: Double,
            longitude: Double,
        ) = MapsFragment().apply {
            arguments = Bundle().apply {
                putDouble(Latitude, latitude)
                putDouble(Longitude, longitude)
            }
        }
    }
}