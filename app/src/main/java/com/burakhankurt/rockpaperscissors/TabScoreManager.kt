package com.burakhankurt.rockpaperscissors

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
//activity
import android.widget.TextView

class TabScoreManager (private val activity: Activity){

    private val _key  =  "tabScoreKey"
    private val _name = "com.burakhankurt.RockPer"

    private val sharedPreferences = activity.getSharedPreferences(_name,
        AppCompatActivity.MODE_PRIVATE
    )


    private fun isScoreGreaterThanTabScore(): Boolean{
        val scoreTextView= activity.findViewById<TextView>(R.id.scoreText)
        val score = scoreTextView.text.toString().toInt()
        val tabScore = sharedPreferences.getInt(_key, 0)
        return  (score > tabScore)
    }

    //tab score update
    fun putTabScore(){

        if (isScoreGreaterThanTabScore()){
           //text to be updated
            val scoreTextView= activity.findViewById<TextView>(R.id.scoreText)

            sharedPreferences.edit().putInt(_key,scoreTextView.text.toString().toInt()).apply()
        }
    }

    //tab score get
    fun getTabScore(){
        val tabScorePreferences = sharedPreferences.getInt(_key,0)
        val tabScoreTextView = activity.findViewById<TextView>(R.id.tabScoreText)
        tabScoreTextView.text = tabScorePreferences.toString()
    }

}