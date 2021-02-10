package com.louis993546.habittracker.model

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate

data class Habit(
    val id: ID,
    val name: String,
    val color: Color,
    val createdAt: Instant,
    val type: Type,
    val goal: Int,
    val period: Period,
    val history: Map<LocalDate, Count>,
) {
    enum class Type {
        MoreThan, LessThan
    }

    enum class Period {
        Daily, Weekly, Monthly, Yearly
    }
}

typealias Count = Int

inline class ID(val id: String)

// TODO I need a better color container
data class Color(val r: Int, val g: Int, val b: Int)

object Dummy {
    val habit = Habit(
        id = ID("id"),
        name = "name",
        color = Color(100, 100, 100),
        createdAt = Clock.System.now(),
        type = Habit.Type.MoreThan,
        goal = 1,
        period = Habit.Period.Daily,
        history = emptyMap()
    )

    val habits = (0..100).map { habit }
}