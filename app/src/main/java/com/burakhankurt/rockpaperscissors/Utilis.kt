package com.burakhankurt.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity



//navigate
import android.content.Context
import android.content.Intent
import androidx.viewbinding.ViewBinding

object Utils {
    //generic binding
    fun < T : ViewBinding> genericBinding(activity: AppCompatActivity, binding: T): T {
        val view = binding.root
        activity.setContentView(view)
        return binding
    }


    fun navigate(context: Context, activityClass: Class<*>) {
        val intent = Intent(context, activityClass)
        context.startActivity(intent)
    }






}