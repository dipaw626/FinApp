package com.mobile.myapplication.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.util.PatternsCompat.EMAIL_ADDRESS
import com.mobile.myapplication.R
import com.mobile.myapplication.profile.ProfileActivity
import java.util.regex.Pattern

class  SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        title = "Menu Setting"
        val btnsave = findViewById<Button>(R.id.btnsimpan)
        val nama = findViewById<EditText>(R.id.etnamalkp)
        val nim = findViewById<EditText>(R.id.etnim)
        val mail = findViewById<EditText>(R.id.etemail)
        val nohp = findViewById<EditText>(R.id.etnohp)
        val pass = findViewById<EditText>(R.id.etPW)
        val rgjk = findViewById<RadioGroup>(R.id.rgjk)
        val spiner = findViewById<Spinner>(R.id.spiner)
        val amcc = findViewById<CheckBox>(R.id.amcc)
        val himssi = findViewById<CheckBox>(R.id.himssi)
        val bem = findViewById<CheckBox>(R.id.bem)
        val togglebtn = findViewById<ToggleButton>(R.id.togglebtn)

        btnsave.setOnClickListener{
            val cekjk = rgjk.checkedRadioButtonId
            val jk = findViewById<RadioButton>(cekjk)

            val org = StringBuilder()
            if (amcc.isChecked) {
                org.append("AMCC\n")
            }
            if (himssi.isChecked) {
                org.append("HIMSSI\n")
            }
            if (bem.isChecked) {
                org.append("BEM AMIKOM\n")
            }

            val bundle = Bundle()
            bundle.putString("nama" , nama.text.toString())
            bundle.putString("nim" , nim.text.toString())
            bundle.putString("mail" , mail.text.toString())
            bundle.putString("nohp" , nohp.text.toString())
            bundle.putString("jk" , "${jk.text}")
            bundle.putString("prodi", spiner.selectedItem.toString())
            bundle.putString("org", org.toString())
            bundle.putString("status", togglebtn.text.toString())

            if (!Patterns.EMAIL_ADDRESS.matcher(mail.text.toString()).matches()) {
                mail.error = "Masukkan email dengan benar"
            }
            else if (pass.length()==0) {
                pass.error = "Password Tidak Boleh Kosong"
            }
            else {
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("Peringatan..!!")
                alertDialogBuilder.setMessage("Apakah Data Anda Sudah Benar..?")
                    .setCancelable(false)
                    .setPositiveButton("Yes") {
                        dialogInterface, i ->
                        val intent = Intent(this, ProfileActivity::class.java)
                        intent.putExtras(bundle)
                        startActivity(intent)
                        Toast.makeText(this, "Data Profil Berhasil Tersimpan", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("No") {
                        dialogInterface, i -> dialogInterface.cancel()
                    }
                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()

            }

        }
    }
}