package com.example.newsapplication.data.source.local

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.LocalDate

class Converters {
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun fromString(value: String?): LocalDate? {
        return value?.let { LocalDate.parse(value) }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun dateToTimestamp(date: LocalDate?): String? {
        return date?.toString()
    }
}
