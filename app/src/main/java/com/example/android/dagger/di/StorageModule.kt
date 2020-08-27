package com.example.android.dagger.di

import com.example.android.dagger.storage.SharedPreferencesStorage
import com.example.android.dagger.storage.Storage
import dagger.Binds
import dagger.Module
import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class RegistrationStorage

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class LoginStorage

// Tells Dagger this is a Dagger module
// Because of @Binds, StorageModule needs to be an abstract class
@Module
abstract class StorageModule {
    //     Makes Dagger provide SharedPreferencesStorage when a Storage type is requested
//     When using @Binds, the class must be abstract
//     @Binds and @Provides can not be in the same class
    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage

//    @RegistrationStorage
//    @Provides
//    fun provideRegistrationStorage(context: Context): Storage {
//        return SharedPreferencesStorage("registration", context)
//    }
//
//    @LoginStorage
//    @Provides
//    fun provideLoginStorage(context: Context): Storage {
//        return SharedPreferencesStorage("login", context)
//    }
}