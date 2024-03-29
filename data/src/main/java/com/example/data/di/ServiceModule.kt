package com.example.data.di

import com.example.data.api.*
import com.example.data.repository.datasource.TokenLocalDataSourceImpl
import com.google.gson.GsonBuilder
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideUserService(retrofit: Retrofit):UserService{
        return retrofit.create(UserService::class.java)
    }

    @Singleton
    @Provides
    fun provideLoginService(retrofit: Retrofit):LoginService{
        return retrofit.create(LoginService::class.java)
    }

    @Singleton
    @Provides
    fun provideTokenService(retrofit: Retrofit):TokenService{
        return retrofit.create(TokenService::class.java)
    }

    @Singleton
    @Provides
    fun provideSubjectService(retrofit: Retrofit): SubjectService {
        return retrofit.create(SubjectService::class.java)
    }

    @Singleton
    @Provides
    fun provideAttendanceService(retrofit: Retrofit): AttendanceService {
        return retrofit.create(AttendanceService::class.java)
    }

    @Singleton
    @Provides
    fun provideNfcService(retrofit: Retrofit): NfcService {
        return retrofit.create(NfcService::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://13.125.175.196:8080")
            .client(okHttpClient)
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(headerInterceptor: Interceptor):OkHttpClient {
        val okHttpClientBuilder = OkHttpClient().newBuilder()
        okHttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
        okHttpClientBuilder.addInterceptor(headerInterceptor)
        return okHttpClientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideHeaderInterceptor(tokenLocalDataSource: TokenLocalDataSourceImpl): Interceptor {
        return Interceptor{ chain ->
            with(chain) {
                val newRequest = request().newBuilder()
                    .addHeader("Authorization","Bearer "+tokenLocalDataSource.getAccessToken())
                    .build()
                proceed(newRequest)
            }
        }
    }
}
