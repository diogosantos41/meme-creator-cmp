package com.dscoding.memecreator
import androidx.compose.runtime.*
import com.dscoding.memecreator.core.presentation.navigation.NavigationRoot
import com.dscoding.memecreator.core.theme.MemeCreatorTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MemeCreatorTheme {
        NavigationRoot()
    }
}