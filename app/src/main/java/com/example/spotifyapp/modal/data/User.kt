package com.example.spotifyapp.modal.data

import kotlin.uuid.Uuid

data class User(
    val name: String?,
    val email: String?,
    val uuid: String,
    val emailVerify: Boolean
)

