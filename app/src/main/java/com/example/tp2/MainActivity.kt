package com.example.tp

import android.R
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), FragmentExample.MessageListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragment: FragmentExample =
                FragmentExample.newInstance("Bonjour Fragment !")

            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }
    }

    public override fun onMessageReceived(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}