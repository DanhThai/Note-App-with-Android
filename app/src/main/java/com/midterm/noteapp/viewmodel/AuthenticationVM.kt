package com.midterm.noteapp.viewmodel

import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthenticationVM : ViewModel() {
    private lateinit var auth: FirebaseAuth
    fun checkUser(){
        var currentUser = auth.getCurrentUser()

    }
    fun login(email: String, password: String){
        auth = Firebase.auth
        auth.signInWithEmailAndPassword(email,password)


    }



}