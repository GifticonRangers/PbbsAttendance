package com.example.data.repository

import com.example.data.datasources.UserRemoteDataSource
import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserRemoteDataSource
):UserRepository {
    override suspend fun login(): User {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(): User {
        TODO("Not yet implemented")
    }
}