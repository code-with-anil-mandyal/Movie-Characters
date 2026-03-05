package com.moviecharacters.di

import com.moviecharacters.core.utils.ApiRoutes.BASE_URL
import com.moviecharacters.data.api.CharactersApi
import com.moviecharacters.data.repository.CharactersRepositoryImpl
import com.moviecharacters.domain.repository.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance() : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideCharactersApi(retrofit: Retrofit) : CharactersApi = retrofit.create(CharactersApi::class.java)

    @Provides
    @Singleton
    fun provideCharactersRepository(charactersApi: CharactersApi) : CharactersRepository {
        return CharactersRepositoryImpl(charactersApi)
    }

}