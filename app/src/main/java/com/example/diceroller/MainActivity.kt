package com.example.diceroller

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceRollAnimation.addAnimatorListener(object: Animator.AnimatorListener {
            override fun onAnimationRepeat(Animation: Animator) {
            }

            override fun onAnimationEnd(Animation: Animator) {
                hideDice()
                var randomNumber = (1..6).random()
                tvResult.text = randomNumber.toString()
            }

            override fun onAnimationCancel(Animation: Animator) {
            }

            override fun onAnimationStart(Animation: Animator) {
            }
        })
    }
    private fun showDice(view: View){
        diceRollAnimation.visibility = View.VISIBLE
        tvResult.visibility = View.GONE
        btnRollDice.visibility = View.GONE
    }

    private fun hideDice(){
        diceRollAnimation.visibility = View.GONE
        tvResult.visibility = View.VISIBLE
        btnRollDice.visibility = View.VISIBLE
    }

    fun rollDice(view: View){
        showDice(view)
        diceRollAnimation.playAnimation()
    }
}
