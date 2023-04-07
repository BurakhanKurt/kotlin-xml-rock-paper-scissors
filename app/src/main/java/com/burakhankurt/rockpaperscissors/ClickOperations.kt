package com.burakhankurt.rockpaperscissors

import android.annotation.SuppressLint
import android.app.Activity
//view
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.burakhankurt.rockpaperscissors.enums.ChoseType
import com.burakhankurt.rockpaperscissors.enums.ResultMatchType

class ClickOperations (private val activity: Activity) {

    private val animations = Animations(activity)
    private  var tabScoreManager =TabScoreManager(activity)

    //clickState
    private var isClickable = true

    fun operatinon(onClickId : Int, playerChoseType : ChoseType) {

        animations.buttonClickAnimate(onClickId)
        //click state change
        clickState()
        //computer chose
        val computerChoseType: ChoseType = computerChoseType()
        //match result
        val resultMatch = resultMatch(computerChoseType,playerChoseType)

        //animated
        animations.computerAnimate(computerChoseType, resultMatch) {
            /*---await method---*/

            //score count
            countScore(resultMatch)
            //click state change
            clickState()
            //buttonClickAfterAnimate
            animations.buttonClickAfterAnimate(onClickId)
            tabScoreManager.putTabScore()
        }
    }

    //click state
    private fun clickState() {
        activity.findViewById<CardView>(R.id.rockButton).isEnabled = !isClickable
        activity.findViewById<CardView>(R.id.paperButton).isEnabled = !isClickable
        activity.findViewById<CardView>(R.id.scissorsButton).isEnabled = !isClickable
        isClickable = !isClickable
    }

    //computer
    private fun computerChoseType() : ChoseType {
        //random chose
        val computerChose = (0..2).random()
        //rock-paper-scissors
        return enumValues<ChoseType>().find { it.value == computerChose }!!
    }

    //win-lose-draw
    private fun resultMatch (computerChoseType : ChoseType, playerChoseType : ChoseType) : ResultMatchType {

        if(computerChoseType == playerChoseType)//draw
            return ResultMatchType.Draw

        if(playerChoseType == ChoseType.Rock && computerChoseType == ChoseType.Scissors)//win stone aganist scissors
            return ResultMatchType.Win
        if(playerChoseType == ChoseType.Paper && computerChoseType == ChoseType.Rock)//win paper aganist stone
            return ResultMatchType.Win
        if(playerChoseType == ChoseType.Scissors && computerChoseType == ChoseType.Paper)//win scissors aganist paper
            return ResultMatchType.Win

        return ResultMatchType.Lose
    }

    //score +1 or same or 0

    private fun countScore(resultMatchType: ResultMatchType){
        //score text
        val scoreText = activity.findViewById<TextView>(R.id.scoreText)
        //score +1
        if (resultMatchType == ResultMatchType.Win){//win state
            val score = scoreText.text.toString().toInt()
            scoreText.text = (score + 1).toString()
        }
        //score 0
        if(resultMatchType== ResultMatchType.Lose)//lose state
            scoreText.text = (0).toString()
        //else score same
    }




}