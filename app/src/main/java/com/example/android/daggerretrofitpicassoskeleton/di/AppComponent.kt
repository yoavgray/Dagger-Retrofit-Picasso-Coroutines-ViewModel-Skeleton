package com.example.android.daggerretrofitpicassoskeleton.di

import android.app.Application
import com.example.android.daggerretrofitpicassoskeleton.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance
        fun application(app: Application): Builder
    }
}
