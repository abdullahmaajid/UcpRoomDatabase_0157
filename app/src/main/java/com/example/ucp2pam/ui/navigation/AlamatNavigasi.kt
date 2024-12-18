package com.example.ucp2pam.ui.navigation

interface AlamatNavigasi {
    val route: String
}


object DestinasiDosenHome : AlamatNavigasi {
    override val route = "home_dosen"
}

object DestinasiDosenDetail : AlamatNavigasi {
    override val route = "detail_dosen"
    const val NIDN = "nidn"
    val routeWithArg = "$route/{$NIDN}"
}

object DestinasiDosenUpdate : AlamatNavigasi {
    override val route = "update_dosen"
    const val NIDN = "nidn"
    val routeWithArg = "$route/{$NIDN}"
}


object DestinasiMataKuliahHome : AlamatNavigasi {
    override val route = "home_mata_kuliah"
}

object DestinasiMataKuliahDetail : AlamatNavigasi {
    override val route = "detail_mata_kuliah"
    const val KODE = "kode"
    val routeWithArg = "$route/{$KODE}"
}

object DestinasiMataKuliahUpdate : AlamatNavigasi {
    override val route = "update_mata_kuliah"
    const val KODE = "kode"
    val routeWithArg = "$route/{$KODE}"
}

