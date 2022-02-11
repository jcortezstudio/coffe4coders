package com.jcortezstudio.coffe4coders.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.toSize
import com.jcortezstudio.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun DropdownTexField(
    suggestions: List<String>,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val icon = Icons.Filled.ArrowDropDown

    Column {
        CustomTextField(value = value,
            placeholder = placeholder,
            onValueChanged = onValueChange,
            enabled = false,
            trailingIcon = {
                Icon(imageVector = icon, contentDescription = null, modifier = Modifier.clickable {
                    isExpanded = !isExpanded
                })
            },
            onGloballyPositioned = { coordinates ->
                textFieldSize = coordinates.size.toSize()
            })
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
            modifier = Modifier.width(
                with(LocalDensity.current) {
                    textFieldSize.width.toDp()
                })
        ) {
            suggestions.forEach{ label ->
                DropdownMenuItem(onClick = {
                    onValueChange(label)
                }) {
                    Text(text = label, style = MaterialTheme.typography.body2)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DropdownTexFieldPreview() {
    val cities = listOf(
        "Ciudad de México, México",
        "La Habana, Cuba",
        "Cancún, México",
        "Medellín, Colombia",
        "Buenos Aires, Argentina",
        "Sao Paulo, Brasil",
        "Lima, Perú",
        "Montevideo, Uruguay",
        "Ciudad de Panamá, Panamá"
    )
    Coffe4CodersTheme {
        DropdownTexField(cities, "", "Ciudades"){}
    }
}