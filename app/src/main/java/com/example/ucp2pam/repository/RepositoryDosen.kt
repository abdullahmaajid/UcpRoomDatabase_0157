package com.example.ucp2pam.repository

import com.example.ucp2pam.data.entity.Dosen
import kotlinx.coroutines.flow.Flow

interface RepositoryDosen {
    suspend fun insertDosen(dosen: Dosen)
    fun getAllDosen(): Flow<List<Dosen>>
    fun getDosen(nidn: String): Flow<Dosen>
    suspend fun deleteDosen(dosen: Dosen)
    suspend fun updateDosen(dosen: Dosen)
}
