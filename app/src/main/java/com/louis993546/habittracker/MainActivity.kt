package com.louis993546.habittracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import com.louis993546.habittracker.model.Dummy
import com.louis993546.habittracker.ui.component.HabitCard
import com.louis993546.habittracker.ui.theme.HabitTrackerTheme
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabitTrackerTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(topBar = { TopAppBar(title = { Text(text = "Habit Tracker") }) }) {
                        HabitList()
                    }
                }
            }
        }
    }
}

@Composable
fun HabitList(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = Dummy.habits) {
            HabitCard(
                habit = it,
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

