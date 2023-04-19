package com.powersoft.miuexamprep.utils

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.powersoft.miuexamprep.R
import com.powersoft.miuexamprep.listeners.AnimationEndListener

class AnimUtils {
    companion object {
        fun bounce(context: Context?, listener: AnimationEndListener?): Animation? {
            val animation = AnimationUtils.loadAnimation(context, R.anim.anim_bounce)
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    listener?.onAnimationEnd()
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
            return animation
        }
    }
}