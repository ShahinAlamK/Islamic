package com.example.islamic.data.di

import com.example.islamic.data.repository.IslamicRepo
import com.example.islamic.data.services.IslamicService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class IslamicRepoModule {

    @Binds
    abstract fun providesRepo(islamic: IslamicRepo):IslamicService
}