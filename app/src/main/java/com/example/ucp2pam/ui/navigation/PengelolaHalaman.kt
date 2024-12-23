package com.example.ucp2pam.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ucp2pam.ui.view.HomeView
import com.example.ucp2pam.ui.view.dosen.DestinasiInsert
import com.example.ucp2pam.ui.view.dosen.HomeDsnView
import com.example.ucp2pam.ui.view.dosen.InsertDsnView
import com.example.ucp2pam.ui.view.matakuliah.DestinasiInsertMataKuliah
import com.example.ucp2pam.ui.view.matakuliah.DetailMkView
import com.example.ucp2pam.ui.view.matakuliah.HomeMkView
import com.example.ucp2pam.ui.view.matakuliah.InsertMkView
import com.example.ucp2pam.ui.view.matakuliah.UpdateMkViewModel
import com.example.ucp2pam.ui.viewmodel.matakuliah.UpdateMkViewModel

/////
// MENGATUR NAVIGASI ANTAR HALAMAN
/////

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute.route, // Sesuaikan dengan HomeRoute
        modifier = modifier
    ) {
        // Rute untuk HalamanView
        composable(route = HomeRoute.route) {
            HomeView(
                onDosenButton = {
                    navController.navigate(DestinasiHomeDosen.route) // Arahkan ke HomeDsnView
                },
                onMataKuliahButton = {
                    navController.navigate(DestinasiHomeMataKuliah.route) // Arahkan ke HomeMkView
                }
            )
        }

        // Rute untuk HomeDsnView
        composable(route = DestinasiHomeDosen.route) {
            HomeDsnView(
                onAddDosen = {
                    navController.navigate(DestinasiInsert.route)
                },
                onBack = { navController.popBackStack() },
                onDetailClick = { nidn ->
                    // Tambahkan logika navigasi ke detail
                    println("Navigasi ke detail dengan NIDN: $nidn")
                },
            )
        }
        composable(
            route = DestinasiInsert.route
        ) {
            InsertDsnView(
                onBack = { navController.popBackStack() },
                onNavigate = { navController.popBackStack() },
                modifier = modifier,
            )
        }

        // Rute untuk HomeMkView
        composable(route = DestinasiHomeMataKuliah.route) {
            HomeMkView(
                onAddMk = {
                    navController.navigate(DestinasiInsertMataKuliah.route)
                },
                onDetailClick = { kode ->
                    navController.navigate("${DestinasiDetailMataKuliah.route}/$kode")
                    println("PengelolaHalaman: kode =$kode")
                },
                onBack = { navController.popBackStack() },
                modifier = modifier,
            )
        }
        composable(
            route = DestinasiInsertMataKuliah.route
        ) {
            InsertMkView(
                onBack = { navController.popBackStack() },
                onNavigate = { navController.popBackStack() },
                modifier = modifier,
            )
        }
        composable(
            DestinasiDetailMataKuliah.routesWithArg,
            arguments = listOf(
                navArgument(DestinasiDetailMataKuliah.KODE_MATAKULIAH) {
                    type = NavType.StringType
                }
            )
        ) {
            val kode = it.arguments?.getString(DestinasiDetailMataKuliah.KODE_MATAKULIAH)
            kode?.let { kode ->
                DetailMkView(
                    onBack = { navController.popBackStack() },
                    onEditClick = { navController.navigate( "${DestinasiUpdateMataKuliah.route}/$it") },
                    modifier = modifier,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
        composable(
            DestinasiUpdateMataKuliah.routesWithArg,
            arguments = listOf(
                navArgument(DestinasiUpdateMataKuliah.KODE_MATAKULIAH) {
                    type = NavType.StringType
                }
            )
        ) {
            UpdateMkViewModel(
                onBack = { navController.popBackStack() },
                onNavigate = { navController.popBackStack() },
                modifier = modifier,
            )
        }
    }
}