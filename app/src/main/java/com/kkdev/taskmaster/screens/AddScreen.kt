package com.kkdev.taskmaster.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kkdev.taskmaster.R
import com.kkdev.taskmaster.composable.BorderlessTextField
import com.kkdev.taskmaster.composables.ToggleButton
import com.kkdev.taskmaster.composables.ToggleButtonList
import com.kkdev.taskmaster.data.models.Task
import com.kkdev.taskmaster.ui.theme.AppTheme
import com.kkdev.taskmaster.ui.theme.poppinsFontFamily
import com.kkdev.taskmaster.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTask() {
    val focusRequester = remember { FocusRequester() }
    var taskTitle by remember { mutableStateOf("") }
    var taskDescription by remember { mutableStateOf("") }
    var isPinned: Boolean by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = AppTheme.colorScheme.onPrimary,
        // TODO: Implement Add Reminder feature
//        floatingActionButton = {
//            FloatingActionButton(onClick = {
//                // TODO: Implement Add Task functionality
//            },
//                containerColor = AppTheme.colorScheme.surface,
//                contentColor = AppTheme.colorScheme.onSurface,
//                shape = CircleShape
//            ) {
//                Icon(imageVector = Icons.Filled.Done, contentDescription = null )
//            }
//        },


        topBar = {

            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = AppTheme.colorScheme.onPrimary,
                    titleContentColor = AppTheme.colorScheme.onBackground,
                    actionIconContentColor = AppTheme.colorScheme.onBackground,
                    scrolledContainerColor = AppTheme.colorScheme.onBackground,
                    navigationIconContentColor = AppTheme.colorScheme.onBackground
                ),
                title = {null},
//                    Text(
//                        text = "Add Task",
//                        fontFamily = poppinsFontFamily,
//                        style = MaterialTheme.typography.titleMedium,
//                        fontWeight = FontWeight.SemiBold
//                    )},
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_left),
                            contentDescription = "navigate back to home",
                        )
                    }
                },
                actions = {
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(painter = painterResource(id = R.drawable.calendar),
//                            contentDescription = "set the reminder for this task")
//                    }
                    Button(onClick = { isPinned = !isPinned },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = AppTheme.colorScheme.onBackground,
                            containerColor = AppTheme.colorScheme.background
//                            contentColor = if (isPinned) AppTheme.colorScheme.onBackground else AppTheme.colorScheme.background,
//                            containerColor = if (isPinned) AppTheme.colorScheme.background else AppTheme.colorScheme.onBackground,
//                            disabledContainerColor = if (isPinned) AppTheme.colorScheme.onBackground else AppTheme.colorScheme.background,
//                            disabledContentColor = if (isPinned) AppTheme.colorScheme.background else AppTheme.colorScheme.onBackground,
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.pin),
                            contentDescription = "Pin this task" )
                        if (isPinned){
                            Text(
                                text = "Pinned",
                                fontFamily = poppinsFontFamily,
                                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar (
                actions = {
                    ToggleButtonGroup()
                },
                containerColor = AppTheme.colorScheme.onPrimary,
            )
        }
    ) { it ->


        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .padding(it)
        ) {
            BorderlessTextField(
                value = taskTitle,
                txtStyle = TextStyle(
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Medium,
                    color = AppTheme.colorScheme.onBackground,
                    fontFamily = poppinsFontFamily
                ),
                onValueChange = {
                    taskTitle = it
                },
                placeholder =  "Title"
            )
            BasicTextField(
                value = taskDescription,
                onValueChange = { taskDescription = it },
                textStyle = TextStyle(
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    fontFamily = poppinsFontFamily,
                    color = AppTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Medium
                ),
                singleLine = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .heightIn(min = 56.dp)
                    .focusRequester(focusRequester)
                    .verticalScroll(rememberScrollState())

            )
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun F1k(){
    AppTheme{
        AddTask()
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ToggleButtonGroup() {
    var selectedButton by remember { mutableIntStateOf(0) }

    val categories = listOf(
        ToggleButtonList("Personal", Icons.Filled.Person),
        ToggleButtonList("Work", Icons.Filled.Email),
        ToggleButtonList("Finance", Icons.Filled.ShoppingCart),
        ToggleButtonList("Others", Icons.Filled.MoreVert)
    )
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.SpaceEvenly
    ) {
        categories.forEachIndexed { index, category ->
            ToggleButton(
                text = category.btnText,
                btnImg = category.btnIcon,
                isSelected = selectedButton == index,
                onClick = { selectedButton = index },
                modifier = Modifier.padding(4.dp)
            )
        }

    }
}

