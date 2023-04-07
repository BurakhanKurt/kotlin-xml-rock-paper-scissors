package com.burakhankurt.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//view
import android.view.View
import com.burakhankurt.rockpaperscissors.enums.ChoseType
//binding
import com.burakhankurt.rockpaperscissors.databinding.ActivityNextBinding





class NextActivity : AppCompatActivity() {

    //declare
    private lateinit var binding: ActivityNextBinding
    private lateinit var clickOperations: ClickOperations


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //initiliaze
        binding = Utils.genericBinding(this, ActivityNextBinding.inflate(layoutInflater))
        clickOperations= ClickOperations(this)

    }



    //stone button click
    fun rockClick(view: View){
        clickOperations.operatinon(R.id.rockButton, ChoseType.Rock)

    }
    //paper button click
    fun paperClick(view: View){
        clickOperations.operatinon(R.id.paperButton, ChoseType.Paper)

    }
    //scissors button click
    fun scissorsClick(view: View){
        clickOperations.operatinon(R.id.scissorsButton, ChoseType.Scissors)

    }








}