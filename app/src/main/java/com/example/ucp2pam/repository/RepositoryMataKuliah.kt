package com.example.ucp2pam.repository

import com.example.ucp2pam.data.entity.MataKuliah
import kotlinx.coroutines.flow.Flow

interface RepositoryMataKuliah {
    suspend fun insertMataKuliah(mataKuliah: MataKuliah)
    fun getAllMataKuliah(): Flow<List<MataKuliah>>
    fun getMataKuliah(kode: String): Flow<MataKuliah>
    fun getMataKuliahBySemester(semester: Int): Flow<List<MataKuliah>>
    fun getMataKuliahByDosen(dosenPengampu: String): Flow<List<MataKuliah>>
    suspend fun deleteMataKuliah(mataKuliah: MataKuliah)
    suspend fun updateMataKuliah(mataKuliah: MataKuliah)
}
