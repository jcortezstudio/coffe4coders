package com.jcortezstudio.coffe4coders.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.jcortezstudio.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun BodyText(body: String) {
    Text(text = body,
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Justify)
}

@Preview(showBackground = true)
@Composable
fun BodyTextPreview() {
    Coffe4CodersTheme {
        BodyText("Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
    }
}