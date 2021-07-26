package com.example.tictactoegame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random as KotlinRandomRandom

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View){
        val btnSelected = view as Button
        var cellID = 0
        when (btnSelected.id){
            R.id.btn1 -> cellID = 1
            R.id.btn2 -> cellID = 1
            R.id.btn3 -> cellID = 1
            R.id.btn4 -> cellID = 1
            R.id.btn5 -> cellID = 1
            R.id.btn6 -> cellID = 1
            R.id.btn7 -> cellID = 1
            R.id.btn8 -> cellID = 1
            R.id.btn9 -> cellID = 1
        }
//        Toast.makeText(this, "Cell ID :"+cellID, Toast.LENGTH_LONG).show()
        playGame(cellID,btnSelected)


    }
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var activePlayer = 1

    private fun playGame(cellID: Int, btnSelected: Button) {

        if (activePlayer == 1){
            btnSelected.text = "X"
            btnSelected.setBackgroundColor(Color.parseColor("#009193"))
            player1.add(cellID)
            activePlayer = 2
            AutoPlay()
        }else{
            btnSelected.text = "O"
            btnSelected.setBackgroundColor(Color.parseColor("#FF9300"))
            player2.add(cellID)
            activePlayer = 1
        }

        btnSelected.isEnabled = false

        checkWinner()

    }

    private fun checkWinner() {
        var winner = - 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
        }

        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2
        }

        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2
        }

        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner=2
        }

        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
        }


        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
        }

        if (winner != -1){
            if (winner == 1){
                Toast.makeText(this, "Player 1 won the game", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Player 2 won the game", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun AutoPlay(){
        var emptyCells = ArrayList<Int>()
        for(cellID in 1..9){
            if (!(player1.contains(cellID) || player2.contains(cellID))){
                emptyCells.add(cellID)
            }
        }
        val r = Random()
        val randIndex = r.nextInt(emptyCells.size-0)+0
        val cellID = emptyCells[randIndex]

        val btnSelected:Button
        when(cellID){
            1->btnSelected = btn1
            2->btnSelected = btn2
            3->btnSelected = btn3
            4->btnSelected = btn4
            5->btnSelected = btn5
            6->btnSelected = btn6
            7->btnSelected = btn7
            8->btnSelected = btn8
            9->btnSelected = btn9
            else -> btnSelected = btn1
        }
        playGame(cellID, btnSelected)
    }
}