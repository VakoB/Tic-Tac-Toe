package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.security.PKCS12Attribute

class SecondActivity : AppCompatActivity(),View.OnClickListener {
    companion object{
        const val FPLAYER = "FPLAYER"
        const val SPLAYER = "SPLAYER"
    }
    private lateinit var score1: TextView
    private lateinit var score2: TextView
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetButton: Button
    private lateinit var p1: TextView
    private lateinit var p2: TextView
    private var winnerPlayer: Int = 0
    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()
    private var m: Int = 0
    private var gameActive = true
    private var buttonNumber = 0
    var filledPosition = intArrayOf(0,0,0,0,0,0,0,0,0,0)
    private var f = 1
    private var s = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        init()
        resetButton.setOnClickListener {
            filledPosition = intArrayOf(0,0,0,0,0,0,0,0,0,0)
            activePlayer = 1
            firstPlayer.clear()
            secondPlayer.clear()
            gameActive = true
            button1.setText("")
            button2.setText("")
            button3.setText("")
            button4.setText("")
            button5.setText("")
            button6.setText("")
            button7.setText("")
            button8.setText("")
            button9.setText("")
            button1.setBackgroundColor(Color.GRAY)
            button2.setBackgroundColor(Color.GRAY)
            button3.setBackgroundColor(Color.GRAY)
            button4.setBackgroundColor(Color.GRAY)
            button5.setBackgroundColor(Color.GRAY)
            button6.setBackgroundColor(Color.GRAY)
            button7.setBackgroundColor(Color.GRAY)
            button8.setBackgroundColor(Color.GRAY)
            button9.setBackgroundColor(Color.GRAY)
        }




        p1 = findViewById(R.id.p1)
        p2 = findViewById(R.id.p2)

        val playerNumber1 = intent.getStringExtra(FPLAYER)
        val playerNumber2 = intent.getStringExtra(SPLAYER)
        p1.text = "$playerNumber1"
        p2.text = "$playerNumber2"


    }
    private fun init() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        button1.setBackgroundColor(Color.GRAY)
        button2.setBackgroundColor(Color.GRAY)
        button3.setBackgroundColor(Color.GRAY)
        button4.setBackgroundColor(Color.GRAY)
        button5.setBackgroundColor(Color.GRAY)
        button6.setBackgroundColor(Color.GRAY)
        button7.setBackgroundColor(Color.GRAY)
        button8.setBackgroundColor(Color.GRAY)
        button9.setBackgroundColor(Color.GRAY)
        resetButton = findViewById(R.id.buttonReset)
        score1 = findViewById(R.id.playerOne)
        score2 = findViewById(R.id.playerTwo)


        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
    }
    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {



            if (!gameActive){
                return
            }
            buttonNumber = 0

            when (clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9

            }
            if (buttonNumber != 0) {
                playGame(clickedView, buttonNumber)
            }

        }

    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if(filledPosition[buttonNumber]!= 0){
            return
        }
        filledPosition[buttonNumber] = activePlayer

        if (activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.RED)
            activePlayer = 2
            firstPlayer.add(buttonNumber)

        } else if (activePlayer == 2) {
            clickedView.text = "O"
            clickedView.setBackgroundColor(Color.GREEN)
            activePlayer = 1
            secondPlayer.add(buttonNumber)                                                                  //ამ მასივში შეინახავს

        }



        check(clickedView)


    }

    private fun check(value: Button) {
        winnerPlayer = 0
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2

        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2

        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        //__________________________________WINNER MESSAGE_______________________________________


        if (winnerPlayer == 1) {    //x
            Toast.makeText(this, "გამარჯვებული: 1", Toast.LENGTH_SHORT).show()
            gameActive = false
            score1.text = "$f"
            f+=1


        }


        if (winnerPlayer == 2) {     //o
            Toast.makeText(this, "გამარჯვებული: 2", Toast.LENGTH_SHORT).show()
            gameActive = false
            score2.text = "$s"
            s+=1

        }


        if (firstPlayer.size + secondPlayer.size == 9 && winnerPlayer == 0) {
            Toast.makeText(this, "ფრეა", Toast.LENGTH_LONG).show()

        }
    }






}


