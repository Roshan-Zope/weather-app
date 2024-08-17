package com.example.weatherapp.screens

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.R
import com.example.weatherapp.routes.Routes
import kotlinx.coroutines.delay

/**
 * SplashScreen is a composable function that displays the splash screen
 * of the weather application. It shows the application logo and a tagline,
 * and after a delay, it navigates to the Home screen.
 *
 * @param navController The NavController used to navigate between screens.
 */
@Composable
fun SplashScreen(
    navController: NavController
) {
    // LaunchedEffect triggers a side effect that runs when the composable is first composed.
    LaunchedEffect(Unit) {
        // Delay for 3 seconds to display the splash screen.
        delay(3000)

        // Navigate to the Home screen and remove the Splash screen from the back stack.
        navController.navigate(Routes.HOME_SCREEN) {
            popUpTo(Routes.SPLASH_SCREEN) {
                inclusive = true
            }
        }
    }

    // Box layout to center the content on the screen.
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Column layout to arrange the logo and text vertically.
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Display the application logo.
            Image(
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp),
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "application logo",
            )
            // Spacer to add vertical space between elements.
            Spacer(modifier = Modifier.height(16.dp))

            // Display the application name.
            Text(
                text = "My Weather App",
                style = MaterialTheme.typography.titleSmall,
            )

            // Spacer to add vertical space between elements.
            Spacer(modifier = Modifier.height(16.dp))

            // Display the application tagline
            Text(
                text = "Know the weather of your city!",
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontStyle = FontStyle.Italic,
                )
            )
        }
    }
}

// preview for splash screen
@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    // create a mock controller
    val navController = rememberNavController()

    // pass the mock controller to composable
    SplashScreen(navController)
}
