package com.ipsoft.livros.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Livros
 *  Date:       15/01/2021
 */

abstract class BaseActivity : AppCompatActivity() {
    protected val fbAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private var hasInitCalled = false
    private var authListener: FirebaseAuth.AuthStateListener =
        FirebaseAuth.AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
            if (user != null) {
                if (!hasInitCalled) {
                    hasInitCalled = true
                    init()
                }
            } else {
                finish()
                val it = Intent(this, SignInActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                }
                startActivity(it)
            }
        }

    override fun onStart() {
        super.onStart()
        fbAuth.addAuthStateListener(authListener)
    }

    override fun onStop() {
        super.onStop()
        fbAuth.removeAuthStateListener(authListener)
    }

    protected abstract fun init()
}