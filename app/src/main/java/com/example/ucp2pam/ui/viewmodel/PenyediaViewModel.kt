package com.example.ucp2pam.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ucp2pam.Ucp2App
import com.example.ucp2pam.repository.LocalRepositoryDosen
import com.example.ucp2pam.repository.LocalRepositoryMataKuliah
import com.example.ucp2pam.ui.viewmodel.dosen.DsnViewModel
import com.example.ucp2pam.ui.viewmodel.dosen.HomeDsnViewModel
import com.example.ucp2pam.ui.viewmodel.matakuliah.DetailMkViewModel
import com.example.ucp2pam.ui.viewmodel.matakuliah.HomeMkViewModel
import com.example.ucp2pam.ui.viewmodel.matakuliah.MkViewModel
import com.example.ucp2pam.ui.viewmodel.matakuliah.UpdateMkViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            DsnViewModel(
                Ucp2App().containerApp.RepositoryDosen as LocalRepositoryDosen
            )
        }
        initializer {
            HomeDsnViewModel(
                Ucp2App().containerApp.RepositoryDosen
            )
        }
        initializer {
            MkViewModel(
                Ucp2App().containerApp.RepositoryMataKuliah,
                Ucp2App().containerApp.RepositoryDosen
            )
        }
        initializer {
            HomeMkViewModel(
                Ucp2App().containerApp.RepositoryMataKuliah,
            )
        }
        initializer {
            DetailMkViewModel(
                createSavedStateHandle(),
                Ucp2App().containerApp.RepositoryMataKuliah,
            )
        }
        initializer {
            UpdateMkViewModel(
                createSavedStateHandle(),
                Ucp2App().containerApp.RepositoryMataKuliah as LocalRepositoryMataKuliah,
                Ucp2App().containerApp.RepositoryDosen as LocalRepositoryDosen,
            )
        }
    }
}

fun CreationExtras.Ucp2App(): Ucp2App =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as Ucp2App)
