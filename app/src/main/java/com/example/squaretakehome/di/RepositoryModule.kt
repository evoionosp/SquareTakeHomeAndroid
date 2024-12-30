package com.example.squaretakehome.di

import com.example.squaretakehome.data.EmployeeRepositoryImpl
import com.example.squaretakehome.domain.EmployeeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindEmployeeRepository(impl: EmployeeRepositoryImpl): EmployeeRepository

}