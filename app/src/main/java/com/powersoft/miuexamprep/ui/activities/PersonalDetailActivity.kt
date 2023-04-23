package com.powersoft.miuexamprep.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.powersoft.miuexamprep.databinding.ActivityPersonalDetailBinding
import com.powersoft.miuexamprep.utils.DataStoreManager
import kotlinx.coroutines.launch

class PersonalDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonalDetailBinding
    private var name: String = ""
    private var email: String = ""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.tvTitle.text = ""
        binding.toolbar.imgBack.setOnClickListener { super.onBackPressed() }

        binding.btnNextSubmit.setOnClickListener {
            if (TextUtils.isEmpty(binding.etNameEmail.text)) {
                binding.etNameEmail.error = "Required!!"
                binding.etNameEmail.requestFocus()
                return@setOnClickListener;
            }
            if (name == "") {
                name = binding.etNameEmail.text.toString()
                binding.tvNameEmailTitle.text = "Enter email address"
                binding.btnNextSubmit.text = "Submit"
                binding.progressBar.progress = 100
                binding.etNameEmail.setText("")
                binding.etNameEmail.hint = "Email Address"
                binding.etNameEmail.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            } else {
                email = binding.etNameEmail.text.toString()
                lifecycleScope.launch {
                    DataStoreManager.saveNameAndEmail(this@PersonalDetailActivity, name, email)
                    startActivity(Intent(this@PersonalDetailActivity, MainActivity::class.java))
                    finish()
                }
            }
        }
    }
}