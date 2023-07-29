package com.example.designpatternsapp.mediatormodel.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var activityLoginBinding: ActivityLoginBinding
    private var account: String = ""
    private var password: String = ""
    private var isAuto = false
    private var isRemember = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(activityLoginBinding.root)
        activityLoginBinding.apply {
            accountText.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    account = "$s"
                    change()
                }

                override fun afterTextChanged(s: Editable?) {
                }
            })
            passwordText.isEnabled = false
            passwordText.addTextChangedListener(
                onTextChanged = {
                        s, _, _, _ ->
                    password = "$s"
                    change()
                }
            )
            confirmButton.isEnabled = false
            confirmButton.setOnClickListener {
                Toast.makeText(
                    this@LoginActivity ,
                    "登录成功",
                    Toast.LENGTH_SHORT
                ).show()
            }
            cancelButton.setOnClickListener {
                Toast.makeText(
                    this@LoginActivity ,
                    "取消登录",
                    Toast.LENGTH_SHORT
                ).show()
            }
            autoLoginButton.isEnabled = false
            autoLoginButton.setOnCheckedChangeListener { buttonView, isChecked ->
                isAuto = isChecked
                change()
            }
            rememberMeButton.isEnabled = false
            rememberMeButton.setOnCheckedChangeListener { buttonView, isChecked ->
                isRemember = isChecked
                change()
            }
        }
    }

    private fun change(){
        activityLoginBinding.apply {
            if(account.isEmpty()){
                passwordText.isEnabled = false
                autoLoginButton.isEnabled = false
                rememberMeButton.isEnabled = false
                confirmButton.isEnabled = false
            }else if(
                account.isNotBlank()
                && password.isEmpty()
            ) {
                passwordText.isEnabled = true
                autoLoginButton.isEnabled = false
                rememberMeButton.isEnabled = true
                confirmButton.isEnabled = false
            }else if(
                account.isNotBlank()
                && password.isNotBlank()
            ){
                passwordText.isEnabled = true
                autoLoginButton.isEnabled = true
                rememberMeButton.isEnabled = true
                confirmButton.isEnabled = true
            }
        }

    }
}