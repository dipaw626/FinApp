package com.mobile.myapplication.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.mobile.myapplication.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        title = "Menu Setting"
        val nama = findViewById<TextView>(R.id.tvnama)
        val nim = findViewById<TextView>(R.id.tvnim)
        val mail = findViewById<TextView>(R.id.tvemail)
        val nohp = findViewById<TextView>(R.id.tvhp)
        val jk = findViewById<TextView>(R.id.tvjk)
        val prodi = findViewById<TextView>(R.id.tvprodi)
        val org = findViewById<TextView>(R.id.tvorg)
        val status = findViewById<TextView>(R.id.tvstatus)

        val bukabundle = intent.extras
        if (bukabundle != null) {
            nama.setText(bukabundle.getString("nama"))
            nim.setText(bukabundle.getString("nim"))
            mail.setText(bukabundle.getString("mail"))
            nohp.setText(bukabundle.getString("nohp"))
            jk.setText(bukabundle.getString("jk"))
            prodi.setText(bukabundle.getString("prodi"))
            org.setText(bukabundle.getString("org"))
            status.setText(bukabundle.getString("status"))
        }
    }
}