package com.dscoding.memecreator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform