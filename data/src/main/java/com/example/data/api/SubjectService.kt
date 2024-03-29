package com.example.data.api

import com.example.data.dto.ScheduleSubjectResponseDto
import com.example.domain.model.dto.IdDto
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface SubjectService {
    @POST("/api/subject/showScheduleSubjectByUserId")
    suspend fun showScheduleSubjects(@Body dto: IdDto):ApiResponse<Array<ScheduleSubjectResponseDto>>
}