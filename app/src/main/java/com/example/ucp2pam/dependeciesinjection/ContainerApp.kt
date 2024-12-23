package com.example.ucp2pam.dependeciesinjection



import android.content.Context
import com.example.ucp2pam.data.database.KrsDatabase
import com.example.ucp2pam.repository.LocalRepositoryDosen
import com.example.ucp2pam.repository.LocalRepositoryMataKuliah
import com.example.ucp2pam.repository.RepositoryDosen
import com.example.ucp2pam.repository.RepositoryMataKuliah


/////
// MENYEDIAKAN AKSES KE REPOSITORI DOSEN DAN MATA KULIAH
/////

interface InterfaceContainerApp {
    val RepositoryDosen: RepositoryDosen
    val RepositoryMataKuliah: RepositoryMataKuliah

}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val RepositoryDosen: RepositoryDosen by lazy {
        LocalRepositoryDosen(KrsDatabase.getDatabase(context).dosenDao())
    }

    override val RepositoryMataKuliah: RepositoryMataKuliah by lazy {
        LocalRepositoryMataKuliah(KrsDatabase.getDatabase(context).mataKuliahDao())
    }
}

