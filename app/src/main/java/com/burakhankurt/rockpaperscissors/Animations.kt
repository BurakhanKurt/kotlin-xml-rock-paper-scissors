package com.burakhankurt.rockpaperscissors

import android.app.Activity
//view
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.burakhankurt.rockpaperscissors.enums.ChoseType
import com.burakhankurt.rockpaperscissors.enums.ResultMatchType
//coroutine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Animations(private val activity: Activity) {

    private fun randomWinImageIndex() : Int{
        return (0..5).random()
    }

    fun computerAnimate(computerChoseType : ChoseType, resultMatchType: ResultMatchType, onAnimationEnd: () -> Unit) = CoroutineScope(
        Dispatchers.Main).launch {
        var currentIndex = 0 //hand iamges animate loop counter
        val handImages = arrayOf(R.drawable.rock, R.drawable.paper, R.drawable.scissors,R.drawable.wait)
        val winImages = arrayOf(R.drawable.win1, R.drawable.win2, R.drawable.win3,R.drawable.win4,R.drawable.win5,R.drawable.win6)
        val loseImage = R.drawable.lose
        val drawImage = R.drawable.drav
        val computerImagesView = activity.findViewById<ImageView>(R.id.computer)
        //hand images animate loop
        while (currentIndex<4) {
            delay(500)
            computerImagesView.setImageResource(handImages[currentIndex])
            currentIndex ++
        }
        delay(1000)
        //computer chose image
        computerImagesView.setImageResource(handImages[computerChoseType.get])
        delay(1500)
        //win or lose or draw images
        if(resultMatchType == ResultMatchType.Draw)//draw state
            computerImagesView.setImageResource(drawImage)
        if(resultMatchType == ResultMatchType.Win)//win state
            computerImagesView.setImageResource(winImages[randomWinImageIndex()])
        if (resultMatchType == ResultMatchType.Lose){// lose state
            computerImagesView.setImageResource(loseImage)
        }
        //after the animate
        onAnimationEnd()
    }

    //button click animate
    fun buttonClickAnimate(buttonClickId : Int){
        val buttonView = activity.findViewById<CardView>(buttonClickId)
        //change color
        buttonView.setCardBackgroundColor(activity.getColor(R.color.buttonClick))
    }

    //button after click animate
    fun buttonClickAfterAnimate(buttonClickId : Int){
        val cardView = activity.findViewById<CardView>(buttonClickId)
        //before color
        cardView.setCardBackgroundColor(activity.getColor(R.color.background))
    }
}