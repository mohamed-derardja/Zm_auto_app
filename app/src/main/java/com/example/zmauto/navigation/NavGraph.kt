package com.example.zmauto.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Onboarding : Screen("onboarding")
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
    object CarDetails : Screen("car_details/{carId}") {
        fun createRoute(carId: String) = "car_details/$carId"
    }
    object Booking : Screen("booking/{carId}") {
        fun createRoute(carId: String) = "booking/$carId"
    }
    object Profile : Screen("profile")
    object MyBookings : Screen("my_bookings")
    object Settings : Screen("settings")
    object Search : Screen("search")
    object Filter : Screen("filter")
    object Payment : Screen("payment")
    object BookingConfirmation : Screen("booking_confirmation")
}

object NavGraph {
    const val ROOT_ROUTE = "root"
    const val AUTH_ROUTE = "auth"
    const val MAIN_ROUTE = "main"
} 