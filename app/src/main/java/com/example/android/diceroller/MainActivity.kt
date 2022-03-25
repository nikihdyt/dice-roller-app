package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            // kode dibawah membuat fungsi rollDice() dijalankan saat rollButton di klik
            rollDice()
        }

        // acak dadu sekali saat aplikasi dibuka tanpa harus meng-klik tombol "roll"
        rollDice()
    }

    // acak dadu dan perbarui tampilan layar sesuai dengan hasil acakan dadu
    private fun rollDice() {
        // membuat objek Dice baru dengan 6 sisi dan mengacaknya
        val dice0 = Dice(6)
        val diceRolled = dice0.roll()

        // menemukan ImageView di dalam layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        // menentukan drawable resouce mana yang digunakan tergantung dari hasil acakan dadu
        val drawableResource = when (diceRolled) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // memperbarui ImageView dengan ID drawable resource yang benar
        diceImage.setImageResource(drawableResource)
        // memperbarui deskripsi dari konten image yang muncul
        diceImage.contentDescription = diceRolled.toString()
    }

}

// membuat class untuk merandom nilai dadu yang akan muncul
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}