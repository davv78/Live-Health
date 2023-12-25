package com.nashir.massive_project.NonEmergency.Pelatihan.Login

import DbHelper
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import com.nashir.massive_project.NonEmergency.Pelatihan.Register.RegisterActivity
import com.nashir.massive_project.R
import com.nashir.massive_project.nonEmergency.pelatihan.PelatihanActivity

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val PREF_NAME = "LoginPrefs"
    private val KEY_IS_LOGGED_IN = "isLoggedIn"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val backlogin: ImageView = findViewById(R.id.back_login)
        backlogin.setOnClickListener(this)

        val login: Button = findViewById(R.id.login)
        login.setOnClickListener(this)

        val btn_daftar: TextView = findViewById(R.id.btn_daftar)
        btn_daftar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.login -> {
                    val emailInputLayout = findViewById<TextInputLayout>(R.id.input_login_email)
                    val passwordInputLayout = findViewById<TextInputLayout>(R.id.password)

                    val emailInput = emailInputLayout.editText?.text.toString()
                    val passwordInput = passwordInputLayout.editText?.text.toString()

                    doLoginProcess(emailInput, passwordInput)
                }
                R.id.btn_daftar -> {
                    val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun doLoginProcess(email: String, password: String) {
        val dbHelper = DbHelper(this@LoginActivity)
        val isLoggedIn = dbHelper.userLogin(email, password)

        if (isLoggedIn) {
            saveLoginStatus()
            val intent = Intent(this@LoginActivity, PelatihanActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this@LoginActivity, "Login gagal", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveLoginStatus() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean(KEY_IS_LOGGED_IN, true)
        editor.apply()
    }

    override fun onResume() {
        super.onResume()

        val sharedPreferences: SharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        val isLoggedIn: Boolean = sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)

        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, PelatihanActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
