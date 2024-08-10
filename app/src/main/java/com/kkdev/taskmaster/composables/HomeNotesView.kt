package com.kkdev.taskmaster.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kkdev.taskmaster.R
import com.kkdev.taskmaster.screens.TaskItem
import com.kkdev.taskmaster.ui.theme.poppinsFontFamily
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeNotesView(
    allTasks: List<TaskItem>,
    pinnedTasks: List<TaskItem>,
    pagerState: PagerState
) {
    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> {
                if (allTasks.isEmpty()) {
                    EmptyStateView(
                        imageResId = R.drawable.todo,
                        message = "Create your first to-do list"
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .padding(horizontal = 15.dp)
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        items(allTasks) { task ->
                            TaskView(
                                tTitle = task.tTitle,
                                tCategory = task.tCat,
                                tTime = task.time,
                                tDescription = task.tdes
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                        }
                    }
                }
            }
            1 -> {
                if (pinnedTasks.isEmpty()) {
                    EmptyStateView(
                        imageResId = R.drawable.no_pinned,
                        message = "Oops! No pinned list yet..."
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .padding(horizontal = 15.dp)
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        items(pinnedTasks) { task ->
                            TaskView(
                                tTitle = task.tTitle,
                                tCategory = task.tCat,
                                tTime = task.time,
                                tDescription = task.tdes
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EmptyStateView(imageResId: Int, message: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = message,
            fontFamily = poppinsFontFamily,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = FontWeight.SemiBold
        )
    }
}

