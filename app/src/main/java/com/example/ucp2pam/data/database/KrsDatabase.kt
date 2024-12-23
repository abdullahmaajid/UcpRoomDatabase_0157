package com.example.ucp2pam.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ucp2pam.data.dao.DosenDao
import com.example.ucp2pam.data.dao.MataKuliahDao
import com.example.ucp2pam.data.entity.Dosen
import com.example.ucp2pam.data.entity.MataKuliah

/////
// MEMBERI AKSES KEPADA DOSENDAO DAN MATAKULIAHDAO
/////

@Database(entities = [Dosen::class, MataKuliah::class], version = 1, exportSchema = false)
abstract class KrsDatabase : RoomDatabase() {
    abstract fun dosenDao(): DosenDao
    abstract fun mataKuliahDao(): MataKuliahDao

    companion object {
        @Volatile
        private var Instance: KrsDatabase? = null

        fun getDatabase(context: android.content.Context): KrsDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    KrsDatabase::class.java,
                    "KrsDatabase"
                )
                    .build().also { Instance = it }
            }
        }
    }
}
