package com.example.personale.firebaseim.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by personale on 7/18/17.
 */

fun ViewGroup.inflate(layout: Int): View = LayoutInflater.from(context).inflate(layout, null)