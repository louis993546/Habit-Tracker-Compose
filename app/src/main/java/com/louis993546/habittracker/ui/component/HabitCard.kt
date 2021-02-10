package com.louis993546.habittracker.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.louis993546.habittracker.model.Dummy
import com.louis993546.habittracker.model.Habit
import com.louis993546.habittracker.ui.theme.HabitTrackerTheme

@Composable
fun HabitCard(
    modifier: Modifier = Modifier,
    habit: Habit,
    onClick: () -> Unit,
) {
    Card(modifier = modifier
        .clickable(onClick = onClick)
        .fillMaxWidth()
        .padding(4.dp)
    ) {
        Column {
            Text(text = habit.name)
            Text(text = habit.subtitle)
        }
    }
}

private val Habit.subtitle: String
    get() = "${type.something} $goal ${goal.timeOrTimes} per ${period.something}"

// TODO delegate it to system
private val Int.timeOrTimes: String
    get() = if (this == 1) "time" else "times"

private val Habit.Type.something: String
    get() = when (this) {
        Habit.Type.MoreThan -> "More than"
        Habit.Type.LessThan -> "Less than"
    }

private val Habit.Period.something: String
    get() = when (this) {
        Habit.Period.Daily -> "day"
        Habit.Period.Weekly -> "week"
        Habit.Period.Monthly -> "month"
        Habit.Period.Yearly -> "year"
    }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HabitTrackerTheme {
        HabitCard(habit = Dummy.habit, onClick = {})
    }
}