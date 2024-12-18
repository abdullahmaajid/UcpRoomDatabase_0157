package com.example.ucp2pam.repository

import com.example.ucp2pam.data.dao.MataKuliahDao
import com.example.ucp2pam.data.entity.MataKuliah
import kotlinx.coroutines.flow.Flow

class LocalRepositoryMataKuliah(
    private val mataKuliahDao: MataKuliahDao
) : RepositoryMataKuliah {

    override suspend fun insertMataKuliah(mataKuliah: MataKuliah) {
        mataKuliahDao.insertMataKuliah(mataKuliah)
    }

    override fun getAllMataKuliah(): Flow<List<MataKuliah>> {
        return mataKuliahDao.getAllMataKuliah()
    }

    override fun getMataKuliah(kode: String): Flow<MataKuliah> {
        return mataKuliahDao.getMataKuliah(kode)
    }

    override fun getMataKuliahBySemester(semester: Int): Flow<List<MataKuliah>> {
        return mataKuliahDao.getMataKuliahBySemester(semester)
    }

    override fun getMataKuliahByDosen(dosenPengampu: String): Flow<List<MataKuliah>> {
        return mataKuliahDao.getMataKuliahByDosen(dosenPengampu)
    }

    override suspend fun deleteMataKuliah(mataKuliah: MataKuliah) {
        mataKuliahDao.deleteMataKuliah(mataKuliah)
    }

    override suspend fun updateMataKuliah(mataKuliah: MataKuliah) {
        mataKuliahDao.updateMataKuliah(mataKuliah)
    }
}
