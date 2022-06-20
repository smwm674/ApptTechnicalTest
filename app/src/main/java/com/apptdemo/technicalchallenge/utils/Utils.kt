package com.apptdemo.technicalchallenge.utils

import android.text.TextUtils

object Utils {
     fun isValidData(latitude: String, longitude: String): Boolean {
        return !TextUtils.isEmpty(latitude) && !TextUtils.isEmpty(longitude)
    }
}