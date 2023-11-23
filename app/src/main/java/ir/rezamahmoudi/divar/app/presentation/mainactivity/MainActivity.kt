package ir.rezamahmoudi.divar.app.presentation.mainactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ir.rezamahmoudi.divar.app.presentation.DivarApp
import ir.rezamahmoudi.divar.core.presentation.designsystem.DivarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DivarTheme {
                DivarApp()
            }
        }
    }
}
