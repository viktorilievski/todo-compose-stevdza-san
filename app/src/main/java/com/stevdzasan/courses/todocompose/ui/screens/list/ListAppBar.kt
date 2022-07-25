package com.stevdzasan.courses.todocompose.ui.screens.list

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.stevdzasan.courses.todocompose.ui.theme.topAppBarBackgroundColor
import com.stevdzasan.courses.todocompose.ui.theme.topAppBarContentColor

@Composable
fun ListAppBar() {
    DefaultListAppBar()
}

@Composable
fun DefaultListAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Tasks",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Composable
@Preview
fun DefaultListAppBarPreview() {
    DefaultListAppBar()
}