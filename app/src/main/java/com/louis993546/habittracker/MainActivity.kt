package com.louis993546.habittracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.activity.compose.setContent
import androidx.compose.runtime.Providers
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.jetsnack.ui.utils.LocalSysUiController
import com.example.jetsnack.ui.utils.SystemUiController
import com.louis993546.habittracker.model.Dummy
import com.louis993546.habittracker.ui.component.HabitCard
import com.louis993546.habittracker.ui.theme.HabitTrackerTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import dev.chrisbanes.accompanist.insets.statusBarsPadding
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.navigationBarColor = resources.getColor(android.R.color.transparent)
        setContent {
            val systemUiController = remember { SystemUiController(window) }
            Providers(LocalSysUiController provides systemUiController) {
                HabitTrackerTheme {
                    ProvideWindowInsets {
                        Surface(color = MaterialTheme.colors.background) {
                            Scaffold(
                                topBar = {
                                    TopAppBar(
                                        modifier = Modifier.statusBarsPadding(),
                                        title = { Text(text = "Habit Tracker") }
                                    )
                                },
                            ) {
                                HabitList()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HabitList(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(count = Dummy.habits.size, key = { index -> index }) {
            HabitCard(
                habit = Dummy.habits[it],
                onPlusClick = { Timber.tag("Habit").d("onPlusClick") }, // TODO not working
                onClick = { Timber.tag("Habit").d("onClick") }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HabitTrackerTheme {
        HabitList()
    }
}

