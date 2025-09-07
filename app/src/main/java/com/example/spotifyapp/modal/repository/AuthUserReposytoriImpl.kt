package com.example.spotifyapp.modal.repository

import android.content.Context
import android.widget.Toast
import com.example.spotifyapp.modal.data.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.actionCodeSettings
import com.google.firebase.auth.userProfileChangeRequest
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AuthUserRepositoryImpl @Inject constructor(
    @ApplicationContext val context: Context
) {
    private val auth = FirebaseAuth.getInstance()

    fun getCurrentUser(): User? {
        val user = auth.currentUser
        return user?.let {
            User(
                name = it.displayName,
                email = it.email,
                uuid = it.uid,
                emailVerify = it.isEmailVerified
            )
        }
    }

    fun registerUser(
        email: String,
        password: String,
        onSuccess: (FirebaseUser?) -> Unit,
        onFailure: (String) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onSuccess(auth.currentUser)
                } else {
                    onFailure(task.exception?.message ?: "Ошибка регистрации")
                }
            }
    }

    fun signInUser(
        email: String,
        password: String,
        onSuccess: (FirebaseUser?) -> Unit,
        onFailure: (String) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onSuccess(auth.currentUser)
                } else {
                    onFailure(task.exception?.message ?: "Ошибка входа")
                }
            }
    }

    fun updateProfile(
        newName: String,
        newEmail: String,
        password: String,
        onResult: (Boolean, String?) -> Unit
    ) {
        val user = auth.currentUser
        if (user == null) {
            onResult(false, "Пользователь не авторизован")
            return
        }

        val profileUpdates = userProfileChangeRequest {
            displayName = newName
        }

        var successCount = 0
        val totalTasks = 3
        var errorMessage: String? = null

        fun checkCompletion() {
            if (successCount == totalTasks) {
                onResult(true, null)
            } else if (errorMessage != null) {
                onResult(false, errorMessage)
            }
        }

        user.updateProfile(profileUpdates).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                successCount++
                checkCompletion()
            } else {
                errorMessage = "Не удалось обновить имя"
                checkCompletion()
            }
        }

        user.updateEmail(newEmail).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                successCount++
                checkCompletion()
            } else {
                errorMessage = "Не удалось обновить Email"
                checkCompletion()
            }
        }

        user.updatePassword(password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                successCount++
                checkCompletion()
            } else {
                errorMessage = "Не удалось обновить пароль"
                checkCompletion()
            }
        }
    }
}



