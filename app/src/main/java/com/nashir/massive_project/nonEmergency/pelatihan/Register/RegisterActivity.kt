package com.nashir.massive_project.NonEmergency.Pelatihan.Register

import DbHelper
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import com.nashir.massive_project.NonEmergency.Pelatihan.Login.LoginActivity
import com.nashir.massive_project.NonEmergency.Pelatihan.model.UserModel
import com.nashir.massive_project.R

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var inputNama: TextInputLayout
    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputNoTelepon: TextInputLayout
    private lateinit var inputAlamat: TextInputLayout
    private lateinit var radioGroup: RadioGroup
    private lateinit var inputPassword: TextInputLayout
    private lateinit var inputConfirmPassword: TextInputLayout
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        inputNama = findViewById(R.id.input_nama)
        inputEmail = findViewById(R.id.input_email)
        inputNoTelepon = findViewById(R.id.input_no_telepon)
        inputAlamat = findViewById(R.id.input_alamat)
        radioGroup = findViewById(R.id.radioGroupJenisKelamin)
        inputPassword = findViewById(R.id.input_password)
        inputConfirmPassword = findViewById(R.id.input_password_confirm)
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val btnRegister: Button = findViewById(R.id.btn_register)
        btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.btn_register -> {
                    val selectedRadioButtonId: Int = radioGroup.checkedRadioButtonId

                    if (selectedRadioButtonId != -1) {
                        val radioButton: RadioButton = findViewById(selectedRadioButtonId)
                        val jenisKelamin: String = radioButton.text.toString()

                        val nama = inputNama.editText?.text.toString()
                        val email = inputEmail.editText?.text.toString()
                        val noTelepon = inputNoTelepon.editText?.text.toString()
                        val alamat = inputAlamat.editText?.text.toString()
                        val password = inputPassword.editText?.text.toString()
                        val confirmPassword = inputConfirmPassword.editText?.text.toString()

                        if (nama.isEmpty() || email.isEmpty() || noTelepon.isEmpty() ||
                            alamat.isEmpty() || jenisKelamin.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()
                        ) {
                            showErrorMessage("Harap lengkapi semua form")
                        } else if (password == confirmPassword) {
                            registerUser(nama, email, noTelepon, alamat, jenisKelamin, password)
                        } else {
                            showErrorMessage("Konfirmasi password tidak cocok")
                        }
                    } else {
                        showErrorMessage("Pilih jenis kelamin terlebih dahulu")
                    }
                }
            }
        }

    }

    private fun showErrorMessage(message: String) {
        val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialogBuilder.setMessage(message)
        alertDialogBuilder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun registerUser(
        nama: String,
        email: String,
        noTelepon: String,
        alamat: String,
        jenisKelamin: String,
        password: String,
    ) {
        val dbHelper = DbHelper(this@RegisterActivity)
        val user = UserModel(nama, email, noTelepon, alamat, password, jenisKelamin)
        val id = dbHelper.addUser(user)

        if (id != -1L) {
            // Registrasi berhasil
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLoggedIn", true)
            editor.apply()

            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            showErrorMessage("Registrasi gagal")
        }
    }
}
