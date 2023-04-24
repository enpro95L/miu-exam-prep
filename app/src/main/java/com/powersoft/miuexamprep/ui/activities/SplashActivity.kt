package com.powersoft.miuexamprep.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.powersoft.miuexamprep.R
import com.powersoft.miuexamprep.databinding.ActivitySplashBinding
import com.powersoft.miuexamprep.utils.DataStoreManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this).load(R.drawable.loading).into(binding.imgLoading)

        lifecycleScope.launch {
            delay(4000)
            if (DataStoreManager.getName(this@SplashActivity) == null) {
                startActivity(Intent(this@SplashActivity, PersonalDetailActivity::class.java))
            } else {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                intent.putExtra("username", DataStoreManager.getName(this@SplashActivity))
                startActivity(intent)
            }
            finish()
        }
    }
}