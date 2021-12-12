package com.uvpce.a107_gokuldham

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        auth= FirebaseAuth.getInstance()

        var currentUser=auth.currentUser

        if(currentUser==null){
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }

        logout.setOnClickListener{
            auth.signOut()
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }


        gallery.setOnClickListener {
            startActivity(Intent(this,GalleryActivity::class.java))
        }

        notice.setOnClickListener {
            startActivity(Intent(this,NoticeActivity::class.java))
        }

        contact.setOnClickListener {
            startActivity(Intent(this,ContactActivity::class.java))
        }
        addcontact.setOnClickListener {
            startActivity(Intent(this,addcontactsActivity::class.java))
        }
    }
}