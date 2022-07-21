package com.stevdzasan.courses.todocompose.data.models

import androidx.compose.ui.graphics.Color
import com.stevdzasan.courses.todocompose.ui.theme.HighPriorityColor
import com.stevdzasan.courses.todocompose.ui.theme.LowPriorityColor
import com.stevdzasan.courses.todocompose.ui.theme.MediumPriorityColor
import com.stevdzasan.courses.todocompose.ui.theme.NonePriorityColor


enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}