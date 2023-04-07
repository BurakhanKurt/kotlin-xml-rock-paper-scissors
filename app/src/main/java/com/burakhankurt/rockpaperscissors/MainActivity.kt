package com.burakhankurt.rockpaperscissors
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.burakhankurt.rockpaperscissors.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //declare
    private lateinit var binding: ActivityMainBinding
    private lateinit var tabScoreManager : TabScoreManager

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //initiliaze
        binding = Utils.genericBinding(this,ActivityMainBinding.inflate(layoutInflater))
        tabScoreManager=TabScoreManager(this)


        tabScoreManager.getTabScore()
    }

    override fun onResume() {
        super.onResume()
        tabScoreManager.getTabScore()
    }

    fun goButtonClick(view: View){
        Utils.navigate(this, NextActivity::class.java)
    }



}