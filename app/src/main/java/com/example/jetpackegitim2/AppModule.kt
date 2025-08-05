package com.example.jetpackegitim2

import android.content.Context
import androidx.room.Room
import com.example.jetpackegitim2.ui.notes.NotesDao
import com.example.jetpackegitim2.ui.notes.NotesDatabase
import com.example.jetpackegitim2.ui.notes.NotesScreen
import com.example.jetpackegitim2.ui.users.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesNotesDatabase(@ApplicationContext context: Context):NotesDatabase{
        return Room.databaseBuilder(
                context,
                NotesDatabase::class.java,
                "notes_database"
            ).fallbackToDestructiveMigration(false).build()
    }

    @Provides
    @Singleton
    fun providesNotesDao(database: NotesDatabase):NotesDao{
        return database.notesDao()
    }



    @Provides
    fun provideUserRepository(): UserRepository{
        return UserRepository()
    }

}