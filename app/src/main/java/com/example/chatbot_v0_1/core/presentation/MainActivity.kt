package com.example.chatbot_v0_1.core.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.chatbot_v0_1.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findNavController(R.id.nav_host_fragment).navigate(R.id.loginFragment)
    }
}
