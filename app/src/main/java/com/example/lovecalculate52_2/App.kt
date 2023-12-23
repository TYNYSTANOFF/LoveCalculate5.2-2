package com.example.lovecalculate52_2

import android.app.Application
import androidx.room.Room
import com.example.lovecalculate52_2.model.room.AppDatabase
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application()