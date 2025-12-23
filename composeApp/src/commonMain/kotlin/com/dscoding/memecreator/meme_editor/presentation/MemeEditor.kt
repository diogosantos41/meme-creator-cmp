package com.dscoding.memecreator.meme_editor.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dscoding.memecreator.core.presentation.MemeTemplate
import com.dscoding.memecreator.core.presentation.memeTemplates
import com.dscoding.memecreator.core.theme.MemeCreatorTheme
import com.dscoding.memecreator.meme_editor.presentation.components.MemeTextBox
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MemeEditorRoot(
    template: MemeTemplate,
    viewModel: MemeEditorViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    MemeEditorScreen(
        template = template,
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun MemeEditorScreen(
    template: MemeTemplate,
    state: MemeEditorState,
    onAction: (MemeEditorAction) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(template.drawable),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        state.memeTexts.forEach { memeText ->
            MemeTextBox(
                memeText = memeText,
                textBoxInteractionState = state.textBoxInteractionState,
                maxWidth = 500.dp,
                maxHeight = 500.dp,
                onClick = {
                    onAction(MemeEditorAction.OnSelectMemeText(memeText.id))
                },
                onDoubleClick = {
                    onAction(MemeEditorAction.OnEditMemeText(memeText.id))
                },
                onTextChange = {
                    onAction(MemeEditorAction.OnMemeTextChange(memeText.id, it))
                },
                onDeleteClick = {
                    onAction(MemeEditorAction.OnDeleteMemeText(memeText.id))
                }
            )
        }

    }
}

@Preview
@Composable
private fun Preview() {
    MemeCreatorTheme {
        MemeEditorScreen(
            template = memeTemplates[0],
            state = MemeEditorState(),
            onAction = {}
        )
    }
}