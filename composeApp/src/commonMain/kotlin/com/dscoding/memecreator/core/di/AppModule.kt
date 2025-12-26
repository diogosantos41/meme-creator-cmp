package com.dscoding.memecreator.core.di

import com.dscoding.memecreator.meme_editor.presentation.MemeEditorViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

expect val platformAppModule: Module

val appModule = module {
    viewModelOf(::MemeEditorViewModel)
    includes(platformAppModule)
}