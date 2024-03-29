package com.example.pbbsattendance.compose

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.domain.model.AttendanceHistoryModel
import com.example.domain.model.dto.StudentSubjectDto
import com.example.domain.model.type.AttendanceState
import com.example.pbbsattendance.compose.component.LectureTitle
import com.example.pbbsattendance.model.LectureTimeItemModel
import com.example.pbbsattendance.ui.theme.*
import com.example.pbbsattendance.util.colorMapper
import com.example.pbbsattendance.util.isEmptyLectureTimeItem
import com.example.pbbsattendance.util.mapAttendanceBinaryStateText
import com.example.pbbsattendance.viewmodel.AttendanceStatusViewModel
import com.example.pbbsattendance.viewmodel.MainViewModel
import com.islandparadise14.mintable.ScheduleEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun AttendanceStatusScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
    attendanceStatusViewModel: AttendanceStatusViewModel = hiltViewModel()
) {
    val scheduleSubject = mainViewModel.getScheduleSubject()
    val lectureTime = mainViewModel.getLectureTimeItem()
    val user = mainViewModel.getUser()
    val lifecycleOwner = LocalLifecycleOwner.current

    val flowLifecycleAware = remember(attendanceStatusViewModel.attendanceStatus, lifecycleOwner){
        attendanceStatusViewModel.attendanceStatus.flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
    }
    val statusList by flowLifecycleAware.collectAsState(initial = AttendanceHistoryModel("","","",AttendanceState.NULL,0,0,0))

    val flowLifecycleAware2 = remember(mainViewModel.selectedLectureTime, lifecycleOwner) {
        mainViewModel.selectedLectureTime.flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
    }
    val selectedLectureTime by flowLifecycleAware2.collectAsState(initial = LectureTimeItemModel("","",""))

    LaunchedEffect(selectedLectureTime){
        if (!isEmptyLectureTimeItem(selectedLectureTime)){
            mainViewModel.getLectureTimeItemFlow()
            attendanceStatusViewModel.collectAttendanceStatus(StudentSubjectDto(user.id, scheduleSubject.originId), selectedLectureTime)
        }
    }

    LaunchedEffect(Unit){
        mainViewModel.getLectureTimeItemFlow()
    }

    ScreensOption(scheduleSubject = scheduleSubject, attendanceStatus = statusList, lectureTime = lectureTime)
}
@Composable
fun ScreensOption(scheduleSubject: ScheduleEntity, attendanceStatus:AttendanceHistoryModel, lectureTime:LectureTimeItemModel){
    if(lectureTime == LectureTimeItemModel("","","")){
        EmptyStatusScreen(scheduleSubject = scheduleSubject)
    }
    else{
        AttendanceStatusScreen(scheduleSubject, attendanceStatus)
    }
}
@Composable
fun EmptyStatusScreen(scheduleSubject: ScheduleEntity){
    Column(
        Modifier
            .background(color = Color.White)
            .fillMaxWidth()
    ) {
        LectureTitle(title = scheduleSubject.scheduleName)
        Text(text = "진행중인 출석이 없습니다")
    }
}
@Composable
fun AttendanceStatusScreen(scheduleSubject: ScheduleEntity, attendanceStatus:AttendanceHistoryModel){
    Column(
        Modifier
            .background(color = Color.White)
            .fillMaxWidth()
    ) {
        LectureTitle(title = scheduleSubject.scheduleName)
        StatusCard(attendanceStatus)
    }
}

@Composable
fun StatusCard(data: AttendanceHistoryModel){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row (
            Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = data.week+"주차", style = TextStyle(fontFamily = suit_regular, fontWeight = FontWeight.W500, fontSize = 14.sp), color = Black1)
                Text(text = data.time+"차시", style = TextStyle(fontFamily = suit_regular, fontWeight = FontWeight.W500, fontSize = 14.sp), color = Black1)
            }
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(text = mapAttendanceBinaryStateText(data.stateAttendance.state), style = TextStyle(fontFamily = suit_regular, fontWeight = FontWeight.W500, fontSize = 14.sp), color = Blue2)
                Canvas(modifier = Modifier
                    .size(26.dp)
                    .padding(horizontal = 8.dp), onDraw = { drawCircle(color = colorMapper(data.stateAttendance.state))})
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .drawBehind {
                    drawLine(
                        color = Grey3,
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = 1f
                    )
                }
        ){}
    }
}


@Preview
@Composable
private fun AttendanceStatusPreview(){
    AttendanceStatusScreen(
        scheduleSubject = ScheduleEntity(originId = 0, scheduleDay = 30, scheduleName = "캡스톤디자인(2)", roomInfo = "505호", startTime = "10:00", endTime = "11:50"),
        attendanceStatus =AttendanceHistoryModel("23/03/08", "1","1", AttendanceState.ATTENDANCE,5,1,855)
    )
}