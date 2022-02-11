package com.jcortezstudio.coffe4coders.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.jcortezstudio.coffe4coders.ui.theme.Coffe4CodersTheme

typealias NavigationAction = () -> Unit

@Composable
fun AppBar(
    title: String? = null,
    navigationIcon: ImageVector? = null,
    navigationAction: NavigationAction? = null
) {
    val titleText = title ?: "Coffe4Coders"
    if (navigationIcon != null && navigationAction != null) {
        TopAppBar(
            title = { Text(text = titleText) },
            navigationIcon = {
                IconButton(onClick = { navigationAction() }) {
                    Icon(imageVector = navigationIcon, contentDescription = null)
                }
            },
            backgroundColor = MaterialTheme.colors.primary
        )
    } else {
        TopAppBar(
            title = { Text(text = titleText) },
            backgroundColor = MaterialTheme.colors.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppBarPreview() {
    Coffe4CodersTheme {
        AppBar("Coffe4Coders")
    }
}
