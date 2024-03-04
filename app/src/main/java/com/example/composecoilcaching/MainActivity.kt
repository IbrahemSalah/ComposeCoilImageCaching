package com.example.composecoilcaching

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.example.composecoilcaching.ui.theme.ComposeCoilCachingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val imgURL =
            "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/255755136/original/e573208a97e1ba1a4590f9491b52b4a0bf2fa34c/be-your-android-app-developer-for-android-apps-mobile-app-development.png"


        setContent {
            ComposeCoilCachingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    AsyncImage(
                        model = imgURL, // image source
                        contentDescription = "Cached Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(383 / 680f)
                    )
                }
            }
        }
    }
}

