package com.nashir.massive_project.Emergency.customerService

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.nashir.massive_project.R

class CallCustomerServiceActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_customer_service)

        val call_end : ImageView = findViewById(R.id.call_end)
        call_end.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v != null)
            when(v.id) {
                R.id.call_end -> {
                    val backtoPrev = finish()
                    backtoPrev
                }
            }

    }
}