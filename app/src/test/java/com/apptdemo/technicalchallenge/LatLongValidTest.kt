package com.apptdemo.technicalchallenge

import com.apptdemo.technicalchallenge.utils.Utils.isValidData
import org.junit.Test

import org.junit.Assert.*



class LatLongValidTest {
    @Test
    fun correctData() {
        assertTrue(isValidData("34","2"))
    }

    @Test
    fun incorrectData() {
        assertTrue(isValidData("","2"))
    }
}