package com.example.domain.repository

import com.example.domain.model.AttendanceHistoryModel
import com.example.domain.model.AttendanceTotalModel
import com.example.domain.model.LectureDateModel
import com.example.domain.model.UserBriefModel
import com.example.domain.model.dto.IdAttendanceStateDto
import com.example.domain.model.dto.LectureInfoDto
import com.example.domain.model.dto.StudentSubjectDto
import com.example.domain.model.dto.UserSubjectDto
import kotlinx.coroutines.flow.Flow

interface AttendanceRepository {
    suspend fun showAttendanceTimeList(dto:UserSubjectDto):ArrayList<LectureDateModel>
    suspend fun showLiveAttendanceTotalInfo(dto:LectureInfoDto): Flow<AttendanceTotalModel>
    suspend fun showAttendanceTotalInfo(dto:LectureInfoDto): AttendanceTotalModel
    suspend fun showAttendanceHistory(dto:StudentSubjectDto):ArrayList<AttendanceHistoryModel>
    suspend fun showLiveAttendanceHistory(dto:StudentSubjectDto):Flow<ArrayList<AttendanceHistoryModel>>
    suspend fun showHoldAttendance(dto:LectureInfoDto):ArrayList<UserBriefModel>
    suspend fun updateAttendance(dto:IdAttendanceStateDto):AttendanceHistoryModel
}