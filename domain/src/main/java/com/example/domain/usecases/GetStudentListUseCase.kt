package com.example.domain.usecases

import com.example.domain.model.Student
import com.example.domain.model.StudentList
import com.example.domain.repository.StudentListRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetStudentListUseCase @Inject constructor(private val repository: StudentListRepository){
    suspend fun invoke():StudentList{
        val dummyData = StudentList(content =
        arrayOf(
            Student(name = "이영지", studentId = "202011111", attendanceState = "출석"),
            Student(name = "스누피", studentId = "201822222", attendanceState = "출석"),
            Student(name = "류승룡", studentId = "201133333", attendanceState = "미출석")
            )
        )

        //return repository.getStudentList()
        return dummyData
    }
}