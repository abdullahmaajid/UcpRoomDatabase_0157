package com.example.ucp2pam.repository

import com.example.ucp2pam.data.dao.DosenDao
import com.example.ucp2pam.data.entity.Dosen
import kotlinx.coroutines.flow.Flow


/////
//MENGOLAH DATA DOSEN DENGAN OPERASI-OPERASI
/////

class LocalRepositoryDosen(
    private val dosenDao: DosenDao
) : RepositoryDosen {


    override suspend fun insertDosen(dosen: Dosen) {
        dosenDao.insertDosen(dosen)
    }


    override fun getAllDosen(): Flow<List<Dosen>> {
        return dosenDao.getAllDosen()
    }

    override fun getDosen(nidn: String) : Flow<Dosen>{
        return dosenDao.getDosen(nidn)
    }
}
