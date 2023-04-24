package com.powersoft.miuexamprep.utils

import com.powersoft.miuexamprep.R

object BackgroundShades {
    operator fun invoke(): List<Int>{
        return listOf(
            R.drawable.grad_chap_1,
            R.drawable.grad_chap_2,
            R.drawable.grad_chap_3,
            R.drawable.grad_chap_4,
            R.drawable.grad_chap_5,
            R.drawable.grad_chap_6,
            R.drawable.grad_chap_7,
            R.drawable.grad_chap_8
        )
    }
}