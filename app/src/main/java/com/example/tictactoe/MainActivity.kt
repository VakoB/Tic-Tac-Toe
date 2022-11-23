package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Nickname.NAME
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
lateinit var submitButton: Button
class MainActivity : AppCompatActivity() {
    private lateinit var p1: EditText
    private lateinit var p2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        p1 = findViewById(R.id.p1)
        p2 = findViewById(R.id.p2)
        submitButton = findViewById(R.id.submitButton)
        submitButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
            val intent = Intent(this@MainActivity,SecondActivity::class.java)
            val p1 = p1.text.toString()
            val p2 = p2.text.toString()
            intent.putExtra(SecondActivity.FPLAYER,p1)
            intent.putExtra(SecondActivity.SPLAYER,p2)
            startActivity(intent)
        }


    }
}