package com.ryvk.layoutrevision

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DayThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_day_three)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listViewButton: Button = findViewById<Button>(R.id.button17)
        listViewButton.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@DayThreeActivity,ListViewActivity::class.java))
        })

        val recyclerViewButton: Button = findViewById<Button>(R.id.button18)
        recyclerViewButton.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@DayThreeActivity,RecyclerViewActivity::class.java))
        })
        val dialogButton1: Button = findViewById<Button>(R.id.button19)
        dialogButton1.setOnClickListener(View.OnClickListener {
            AlertDialog.Builder(this@DayThreeActivity)
                .setTitle("Normal Alert")
                .setMessage("Sample content of a normal Alert Dialog")
                .setPositiveButton("OK",null)
                .show()
        })
        val dialogButton2: Button = findViewById<Button>(R.id.button25)
        dialogButton2.setOnClickListener(View.OnClickListener {
            AlertDialog.Builder(this@DayThreeActivity)
                .setTitle("Confirmation Dialog")
                .setMessage("Content of a confirmation dialog")
                .setPositiveButton("Confirm", DialogInterface.OnClickListener{ dialogInterface: DialogInterface, i: Int -> Toast.makeText(this@DayThreeActivity,"Confirmation successfull!",Toast.LENGTH_LONG).show() })
                .setNegativeButton("Decline",DialogInterface.OnClickListener{ dialog: DialogInterface?, which: Int -> Toast.makeText(this@DayThreeActivity,"Request declined",Toast.LENGTH_LONG).show() })
                .show()
        })

    }
}