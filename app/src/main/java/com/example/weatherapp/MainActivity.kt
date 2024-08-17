package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.routes.Routes
import com.example.weatherapp.screens.ForecastScreen
import com.example.weatherapp.screens.HomeScreen
import com.example.weatherapp.screens.SearchScreen
import com.example.weatherapp.screens.SettingsScreen
import com.example.weatherapp.screens.SplashScreen
import com.example.weatherapp.screens.WeatherDetailsScreen

/**
 * MainActivity is the entry point of the weather application.
 * It extends ComponentActivity and is responsible for setting up
 * the navigation between different screens using Jetpack Compose.
 */
class MainActivity : ComponentActivity() {
    /**
     * onCreate is called when the activity is first created.
     * It initializes the UI and sets up the navigation host for the application.
     *
     * @param savedInstanceState A Bundle containing the activity's previously saved state.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enable edge-to-edge display for the activity.
        enableEdgeToEdge()

        // Set the content of the activity using Jetpack Compose.
        setContent {
            WeatherAppNavigation()
        }
    }
}

@Composable
fun WeatherAppNavigation() {
    // Create a NavController to manage app navigation.
    val navController = rememberNavController()

    // Set up the navigation host and define the composable destinations.
    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH_SCREEN,
        builder = {
            // splash screen route
            composable(Routes.SPLASH_SCREEN) {
                SplashScreen(navController = navController)
            }
            // home screen route
            composable(Routes.HOME_SCREEN) {
                HomeScreen(navController = navController)
            }
            // forecast screen route
            composable(Routes.FORECAST_SCREEN) {
                ForecastScreen(navController = navController)
            }
            // search screen route
            composable(Routes.SEARCH_SCREEN) {
                SearchScreen(navController = navController)
            }
            // weather details screen route
            composable(Routes.WEATHER_DETAILS_SCREEN) {
                WeatherDetailsScreen(navController = navController)
            }
            // settings screen route
            composable(Routes.SETTINGS_SCREEN) {
                SettingsScreen(navController = navController)
            }
        },
    )
}