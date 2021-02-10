package com.louis993546.habittracker.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
    onPlusClick: () -> Unit,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .clickable(onClick = onClick),
        backgroundColor = habit.color,
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // TODO image icon instead of text
            Text(modifier = Modifier.clickable(onClick = onPlusClick), text = "+")
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text(text = habit.name, style = MaterialTheme.typography.body1)
                Text(text = habit.subtitle, style = MaterialTheme.typography.caption)
            }
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
        HabitCard(
            habit = Dummy.habit,
            onPlusClick = {},
            onClick = {},
        )
    }
}