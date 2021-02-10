package com.louis993546.habittracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import com.louis993546.habittracker.model.Dummy
import com.louis993546.habittracker.ui.component.HabitCard
import com.louis993546.habittracker.ui.theme.HabitTrackerTheme

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
        this.items(Dummy.habits) {
            HabitCard(habit = it, onClick = { /*TODO*/ })
        }
    }
}

//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    HabitTrackerTheme {
//        Greeting("Android")
//    }
//}