package com.example.medicalapp.di

import android.util.Log
import com.example.medicalapp.remote.RemoteDatasourceImp
import com.example.medicalapp.ui.screen.loginScreen.ILogin
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

/*    @Singleton
    @Provides
    fun provideFoodService(): FoodService {
        return retrofit.create(FoodService::class.java)
    }
    class RemoteDatasourceImp() : ILogin {
        override suspend fun signIn(email: String?, password: String?): Boolean {
            val auth = Firebase.auth
            var type = false
            auth.signInWithEmailAndPassword(email ?: "", password ?: "").addOnCompleteListener {
                if (it.isSuccessful) {
                    type = true
                    Log.i("jalalcheff", FirebaseAuth.getInstance().currentUser?.email.toString())
                } else
                    Log.i("jalalcheff", it.exception?.message.toString())
            }
            return type
        }

    }

    @Singleton
    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(authInterceptor: AuthorizationInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(authInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideGsonFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }*/
@Singleton
@Provides
fun provideRemoteDatasourceImp(): RemoteDatasourceImp {
    return RemoteDatasourceImp()
}

}