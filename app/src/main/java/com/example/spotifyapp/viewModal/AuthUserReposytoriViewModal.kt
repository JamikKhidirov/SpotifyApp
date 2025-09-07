package com.example.spotifyapp.viewModal

import androidx.lifecycle.ViewModel
import com.example.spotifyapp.modal.data.User
import com.example.spotifyapp.modal.repository.AuthUserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


@HiltViewModel
class AuthUserViewModel @Inject constructor(
    private val repository: AuthUserRepositoryImpl
) : ViewModel() {

    // === Состояние пользователя ===
    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()

    // === Загрузка ===
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    // === Ошибки / Успехи ===
    private val _authError = MutableStateFlow<String?>(null)
    val authError: StateFlow<String?> = _authError.asStateFlow()

    private val _authSuccess = MutableStateFlow<Boolean?>(null)
    val authSuccess: StateFlow<Boolean?> = _authSuccess.asStateFlow()

    init {
        getCurrentUser()
    }

    fun getCurrentUser() {
        _currentUser.value = repository.getCurrentUser()
    }

    fun register(email: String, password: String) {
        _isLoading.value = true
        repository.registerUser(
            email = email,
            password = password,
            onSuccess = {
                _isLoading.value = false
                _authSuccess.value = true
                getCurrentUser()
            },
            onFailure = { error ->
                _isLoading.value = false
                _authError.value = error
                _authSuccess.value = false
            }
        )
    }

    fun login(email: String, password: String) {
        _isLoading.value = true
        repository.signInUser(
            email = email,
            password = password,
            onSuccess = {
                _isLoading.value = false
                _authSuccess.value = true
                getCurrentUser()
            },
            onFailure = { error ->
                _isLoading.value = false
                _authError.value = error
                _authSuccess.value = false
            }
        )
    }

    fun updateProfile(newName: String, newEmail: String, newPassword: String) {
        _isLoading.value = true
        repository.updateProfile(
            newName = newName,
            newEmail = newEmail,
            password = newPassword
        ) { success, error ->
            _isLoading.value = false
            if (success) {
                _authSuccess.value = true
                getCurrentUser()
            } else {
                _authSuccess.value = false
                _authError.value = error
            }
        }
    }

    fun clearMessages() {
        _authError.value = null
        _authSuccess.value = null
    }
}

