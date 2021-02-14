package com.louis993546.habittracker

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.louis993546.habittracker.model.Dummy
import com.louis993546.habittracker.ui.component.HabitCard
import timber.log.Timber

@Composable
fun HabitList(modifier: Modifier = Modifier, navController: NavController) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(
            items = Dummy.habits,
            key = { index, _ -> index }
        ) { _, item ->
            HabitCard(
                habit = item,
                onPlusClick = { Timber.tag("Habit").d("onPlusClick") },
                onClick = {
                    Timber.tag("Habit").d("onClick")
                    navController.navigate("create")
                }
            )
        }
    }
}

// TODO how to provide a fake nav controller?
// @Preview()
// @Composable
// fun HabitListPreview() {
//    HabitTrackerTheme {
//        HabitList(navController = navController)
//    }
// }
