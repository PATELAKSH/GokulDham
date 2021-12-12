package com.uvpce.a107_gokuldham

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_addcontacts.*

class addcontactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcontacts)

        sendData()
    }

    private fun sendData() {

        var name: EditText = findViewById(R.id.contactname)
        var num: EditText = findViewById(R.id.number)

        add_btn.setOnClickListener {
            val auth = Firebase.auth
            if (name.text.toString().isNotEmpty() && num.text.toString().isNotEmpty()) {
                if (auth.currentUser != null) {
                    val databaseRef = FirebaseDatabase.getInstance().getReference("Contacts/${name.text}")
                    databaseRef.setValue(num.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Contact Added Successfully", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }else {
                name.error = "Please Enter Name"
                name.requestFocus()

                num.error = "Please Enter Number"
                num.requestFocus()
            }
        }
    }
}