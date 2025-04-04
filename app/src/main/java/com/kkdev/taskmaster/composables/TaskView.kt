package com.kkdev.taskmaster.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kkdev.taskmaster.data.models.Task
import com.kkdev.taskmaster.ui.theme.AppTheme
import com.kkdev.taskmaster.ui.theme.poppinsFontFamily
import com.kkdev.taskmaster.ui.theme.tGreen
import com.kkdev.taskmaster.ui.theme.tOrange
import com.kkdev.taskmaster.ui.theme.tPurple
import com.kkdev.taskmaster.ui.theme.tYellow

@Composable
fun TaskView(
    task: Task, // Receive the Task object
    onCompleteClick: (Task) -> Unit, // Callback for complete
    onDeleteClick: (Task) -> Unit  // Callback for delete
) {
    val cColor: Color = when (task.tCategory) {
        "Work" -> tOrange
        "Personal" -> tGreen
        "Finance" -> tPurple
        else -> tYellow
    }

    OutlinedCard(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            contentColor = AppTheme.colorScheme.onBackground,
            containerColor = cColor
        ),
        border = BorderStroke(1.dp, AppTheme.colorScheme.onBackground)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                onClick = { onCompleteClick(task) } // Call the complete callback
            ) {
                if (task.isCompleted) {
                    Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = "Completed")
                } else {


                    Icon(
                        imageVector = Icons.Outlined.CheckCircle,
                        contentDescription = "Set the task as completed"
                    )

                }
            }

            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = task.tTitle,
                    maxLines = 1,
                    modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, end = 10.dp),
                    fontFamily = poppinsFontFamily,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )
                if (task.tDesc.isNotEmpty()){
                    Text(
                        text = task.tDesc,
                        maxLines = 2,
                        modifier = Modifier.padding(end = 10.dp, bottom = 5.dp),
                        fontFamily = poppinsFontFamily,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        fontWeight = FontWeight.Normal
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier.padding(end = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = task.tCategory,
                        fontSize = MaterialTheme.typography.labelSmall.fontSize,
                        fontWeight = FontWeight.Medium,
                        fontFamily = poppinsFontFamily,
                        color = AppTheme.colorScheme.background,
                        modifier = Modifier
                            .background(
                                color = AppTheme.colorScheme.onBackground,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(8.dp)
                    )
                    task.tTime?.let {
                        Text(
                            text = it,
                            fontSize = MaterialTheme.typography.labelSmall.fontSize,
                            fontWeight = FontWeight.Medium,
                            fontFamily = poppinsFontFamily
                        )
                    }
                }
            }
            Spacer(Modifier.weight(1f))
            IconButton(
                onClick = { onDeleteClick(task) } // Call the delete callback
            ) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete the task")
            }

        }
    }
}
// Remove or comment out the preview, as it now requires callbacks and a Task object
// @Preview(showBackground = true)
// @Composable
// fun tsv() {
//     AppTheme {
//         Column(
//             modifier = Modifier
//                 .fillMaxSize()
//                 .padding(16.dp)
//         ) {
//             TaskView(tTitle = "Task note done yet", tCategory = "Personal", tTime = "15-04-2024")
//             Spacer(modifier = Modifier.height(15.dp))
//             TaskView(tTitle = "To do list", tDescription = "No description", tCategory = "Other", tTime = "15-04-2024")
//         }
//     }
// }