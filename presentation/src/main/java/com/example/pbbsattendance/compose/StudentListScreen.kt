package com.example.pbbsattendance.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Student
import com.example.pbbsattendance.compose.component.LectureTitle
import com.example.pbbsattendance.compose.component.LiveStatusView
import com.example.pbbsattendance.compose.component.StudentCard
import com.example.pbbsattendance.ui.theme.Blue3
import com.example.pbbsattendance.ui.theme.Grey
import com.example.pbbsattendance.ui.theme.Grey4
import com.example.pbbsattendance.ui.theme.suit_regular

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun StudentListScreen(){
    Column(
        Modifier
            .background(color = Color.White)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LectureTitle(title = "물류의 이해", id = "XAA8057001")
        Row(
            Modifier
                .fillMaxWidth()
                .drawBehind {
                    drawLine(
                        color = Grey4,
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = 10f
                    )
                }
        ){}
        LazyColumn {
//                studentListStateContent?.let {
//                    itemsIndexed(
//                        it.content
//                    ) { index, item ->
//                        StudentCard(data = item)
//                    }
//                }
            itemsIndexed(
                arrayOf(
                    Student(name = "이영지", studentId = "202011111", attendanceState = "출석"),
                    Student(name = "스누피", studentId = "201822222", attendanceState = "출석"),
                    Student(name = "류승룡", studentId = "201133333", attendanceState = "미출석")
                )
            ) { index, item ->
                StudentCard(data = item)
            }
        }
    }
}

@Preview
@Composable
fun StudentListScreenPreview(){
    StudentListScreen()
}