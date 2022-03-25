package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            // kode di bwh ini menampilkan toast
            //val toast = Toast.makeText(this, "Dice rolled!", Toast.LENGTH_SHORT)
            //toast.show()

            // kode dibawah menjadikan atribut text pada TextView yg ber id textView menjadi "6"
            //val resultTextView: TextView = findViewById(R.id.textView)
            //resultTextView.text = "6"

            // mengatur tulisan "Dadu 1" dan "Dadu 2" agar tampil
            val resultTextView3: TextView = findViewById(R.id.textView3)
            val resultTextView4: TextView = findViewById(R.id.textView4)

            // kode dibawah membuat fungsi rollDice() dijalankan saat rollButton di klik
            rollDice()

        }
    }

    // method rollDice digunakan untuk menampilkan isi TextView
    private fun rollDice() {
        // membuat objek Dice baru dengan 6 sisi dan merandomnya
        val dice0 = Dice0(6)
        val diceRolled = dice0.roll()
        // mengupdate isi TextView yang ber id textView agar berubah sesuai dengan hasil angka random
        val resultTextView0: TextView = findViewById(R.id.textView)
        resultTextView0.text = diceRolled.toString()

        // membuat objek Dice baru dengan 6 sisi
        val dice1 = Dice1(6)
        // merandom sisi dadu dan mengupdate isi TextView yang ber id textView2
        val resultTextView1: TextView = findViewById(R.id.textView2)
        resultTextView1.text = dice1.roll().toString()

    }

}

// membuat class untuk merandom nilai dadu yang akan muncul
class Dice0(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}

class Dice1(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}