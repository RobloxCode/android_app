package com.example.testing_shit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testing_shit.ui.theme.Testing_shitTheme


// ============================================================
// DATA
// ============================================================

data class Task(
    val id: Int,
    val title: String,
    var completed: Boolean = false
)

enum class Priority {
    LOW,
    MEDIUM,
    HIGH
}


// ============================================================
// MAIN ACTIVITY
// ============================================================

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Testing_shitTheme {
                TodoApp()
            }
        }
    }
}


// ============================================================
// MAIN APP
// ============================================================

@Composable
fun TodoApp() {

    // --------------------------------------------------------
    // State
    // --------------------------------------------------------

    var newTask by remember {
        mutableStateOf("")
    }

    var tasks by remember {
        mutableStateOf(
            listOf(
                Task(1, "Learn Kotlin"),
                Task(2, "Study Android"),
                Task(3, "Do hamework")
            )
        )
    }


    // --------------------------------------------------------
    // UI
    // --------------------------------------------------------

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "My Tasks",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )


        // ----------------------------------------------------
        // Text field + Add button
        // ----------------------------------------------------

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            OutlinedTextField(
                value = newTask,

                onValueChange = {
                    newTask = it
                },

                modifier = Modifier.weight(1f),

                label = {
                    Text("New task")
                }
            )

            Button(
                onClick = {

                    if (newTask.isNotBlank()) {

                        val task = Task(
                            id = tasks.size + 1,
                            title = newTask
                        )

                        tasks = tasks + task

                        newTask = ""
                    }
                }
            ) {
                Text("+")
            }
        }


        Spacer(
            modifier = Modifier.height(16.dp)
        )


        // ----------------------------------------------------
        // Task list
        // ----------------------------------------------------

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            items(tasks) { task ->

                TaskItem(
                    task = task,

                    onCheckedChange = { checked ->

                        tasks = tasks.map {

                            if (it.id == task.id) {

                                it.copy(
                                    completed = checked
                                )

                            } else {
                                it
                            }
                        }
                    }
                )
            }
        }


        // ----------------------------------------------------
        // Remaining tasks
        // ----------------------------------------------------

        val remaining = tasks.count {
            !it.completed
        }

        Text(
            text = "$remaining tasks remaining"
        )
    }
}


// ============================================================
// TASK ITEM
// ============================================================

@Composable
fun TaskItem(
    task: Task,
    onCheckedChange: (Boolean) -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),

        horizontalArrangement = Arrangement.Start
    ) {

        Checkbox(
            checked = task.completed,

            onCheckedChange = onCheckedChange
        )

        Text(
            text = task.displayText(),

            modifier = Modifier.padding(16.dp)
        )
    }
}


// ============================================================
// EXTENSION FUNCTION
// ============================================================

fun Task.displayText(): String {

    return if (completed) {
        "✓ $title"
    } else {
        "○ $title"
    }
}


// ============================================================
// EXAMPLE OF `when`
// ============================================================

fun priorityText(priority: Priority): String {

    return when (priority) {

        Priority.LOW ->
            "Low priority"

        Priority.MEDIUM ->
            "Medium priority"

        Priority.HIGH ->
            "High priority"
    }
}