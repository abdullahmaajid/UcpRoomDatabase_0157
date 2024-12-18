package com.example.ucp2pam.dependeciesinjection

import android.content.Context
import com.example.ucp2pam.data.database.KrsDatabase
import com.example.ucp2pam.repository.LocalRepositoryDosen
import com.example.ucp2pam.repository.LocalRepositoryMataKuliah
import com.example.ucp2pam.repository.RepositoryDosen
import com.example.ucp2pam.repository.RepositoryMataKuliah

// Interface to include all repositories
interface InterfaceContainerApp {
    val repositoryDosen: RepositoryDosen
    val repositoryMataKuliah: RepositoryMataKuliah
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {


    override val repositoryDosen: RepositoryDosen by lazy {
        LocalRepositoryDosen(KrsDatabase.getDatabase(context).dosenDao())
    }


    override val repositoryMataKuliah: RepositoryMataKuliah by lazy {
        LocalRepositoryMataKuliah(KrsDatabase.getDatabase(context).mataKuliahDao())
    }
}