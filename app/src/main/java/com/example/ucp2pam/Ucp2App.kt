package com.example.ucp2pam

import android.app.Application
import com.example.ucp2pam.dependeciesinjection.ContainerApp




class Ucp2App : Application() {
    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this) // Membuat instace(pembuat object)
        //Instance adalah object yang dibuat dari class
    }
}