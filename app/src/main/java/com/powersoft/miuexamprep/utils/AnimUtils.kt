package com.powersoft.miuexamprep.utils

import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.powersoft.miuexamprep.R
import com.powersoft.miuexamprep.listeners.AnimationEndListener

class AnimUtils {
    companion object {
        fun bounce(view: View, listener: AnimationEndListener?) {
            val animation = AnimationUtils.loadAnimation(view.context, R.anim.anim_bounce)
            view.startAnimation(animation)
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    listener?.onAnimationEnd()
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
        }
    }
}