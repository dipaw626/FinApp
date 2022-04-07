package com.mobile.myapplication.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.mobile.myapplication.R

class HomeActivity : AppCompatActivity() {

    private lateinit var btnHome: Button
    private lateinit var btnProfile: Button
    private lateinit var btnSetting: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnHome = findViewById(R.id.btnHome)
        btnProfile = findViewById(R.id.btnProfile)
        btnSetting = findViewById(R.id.btnSetting)


//        btnProfile.setOnClickListener{
//            val intent = Intent(this, ProfileActivity::class.java)
//            startActivity(intent)
//        }
//
//        btnSetting.setOnClickListener{
//            val intent = Intent(this, ProfileActivity::class.java)
//            startActivity(intent)
//        }
//
//        btnHome.setOnClickListener{
//            val intent = Intent( this, HomeActivity::class.java)
//            intent.putExtra("username","Dipa")
//            startActivity(intent)
//        }

        btnHome.setOnClickListener{
            loadFragment(HomeFragment())
        }

    }

    private  fun  loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }
}