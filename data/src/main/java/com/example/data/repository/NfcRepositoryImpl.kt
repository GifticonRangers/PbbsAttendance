package com.example.data.repository

import com.example.data.api.NfcService
import com.example.domain.model.dto.LectureInfoDto
import com.example.domain.repository.NfcRepository
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import javax.inject.Inject

class NfcRepositoryImpl @Inject constructor( private val api:NfcService ):NfcRepository{

    override suspend fun startNfcTag(dto: LectureInfoDto): String {
        var result = ""
        api.startNfcTag(dto).suspendOnSuccess {
            result = "200"
        }
        return result
    }
    override suspend fun endNfcTag(dto: LectureInfoDto): String {
        var result = ""
        api.endNfcTag(dto).suspendOnSuccess {
            result = "200"
        }
        return result
    }
}