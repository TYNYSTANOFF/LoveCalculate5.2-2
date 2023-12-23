package com.example.lovecalculate52_2.di

import android.content.Context
import androidx.room.Room
import com.example.lovecalculate52_2.Prefs
import com.example.lovecalculate52_2.model.LoveApi
import com.example.lovecalculate52_2.model.room.AppDatabase
import com.example.lovecalculate52_2.model.room.LoveDao
import com.example.lovecalculate52_2.presenter.ParameterPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun provideParameterPresenter(loveApi: LoveApi, loveDao: LoveDao): ParameterPresenter {
        return ParameterPresenter(loveApi, loveDao)
    }

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "love_file")
            .allowMainThreadQueries().build()
    }

    @Provides
    fun provideDao(appDatabase: AppDatabase): LoveDao {
        return appDatabase.getLoveDao()
    }

    @Provides
    fun providePrefs(@ApplicationContext context: Context): Prefs {
        return Prefs(context)
    }
}