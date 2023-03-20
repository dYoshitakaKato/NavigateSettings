package com.example.navigatesettings

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigatesettings.data.Setting
import com.example.navigatesettings.ui.theme.NavigateSettingsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigateSettingsTheme {
                MyApp(modifier = Modifier.fillMaxSize(), listOf())
           }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier, settings: List<Setting>) {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        SettingList(settings = settings)
    }
}

@Preview(showBackground = true,
    widthDp = 320,
    heightDp = 320,
    uiMode = UI_MODE_NIGHT_NO,
    name = "PreviewLight")
@Composable
fun LightPreviewApp() {
    NavigateSettingsTheme {
        PreviewApp()
    }
}

@Preview(showBackground = true,
    widthDp = 320,
    heightDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "PreviewDark")
@Composable
fun DarkPreviewApp() {
    NavigateSettingsTheme {
        PreviewApp()
    }
}

@Composable
fun PreviewApp() {
    MyApp(settings = listOf(Setting(name = "aiueo"), Setting("yoshitaka")))
}

@Composable
    fun SettingList(settings: List<Setting>) {
    LazyColumn {
        items(settings) {
            Setting(it)
        }
    }
}

@Composable
fun Setting(setting: Setting) {
    Text(text = setting.name)
}
