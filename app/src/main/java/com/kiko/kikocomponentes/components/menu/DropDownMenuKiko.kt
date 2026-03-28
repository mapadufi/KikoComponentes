package com.kiko.kikocomponentes.components.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import com.kiko.kikocomponentes.ui.theme.KikoComponentesTheme


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun DropDownMenuKiko() {
    val groupInteractionSource = remember { MutableInteractionSource() }
    var expanded by remember { mutableStateOf(false) }
    val groupLabels = listOf("Modification", "Navigation")
    val groupItemLabels = listOf(listOf("Edit", "Settings"), listOf("Home", "More Options"))
    val groupItemLeadingIcons =
        listOf(
            listOf(Icons.Outlined.Edit, Icons.Outlined.Settings),
            listOf(null, Icons.Outlined.Info),
        )
    val groupItemCheckedLeadingIcons =
        listOf(
            listOf(Icons.Filled.Edit, Icons.Filled.Settings),
            listOf(Icons.Filled.Check, Icons.Filled.Info),
        )
    val groupItemTrailingIcons: List<List<ImageVector?>> =
        listOf(listOf(null, null), listOf(Icons.Outlined.Home, Icons.Outlined.MoreVert))
    val groupItemCheckedTrailingIcons: List<List<ImageVector?>> =
        listOf(listOf(null, null), listOf(Icons.Filled.Home, Icons.Filled.MoreVert))
    val groupItemSupportingText: List<List<String?>> =
        listOf(listOf("Edit mode", null), listOf(null, "Opens menu"))
    val checked = remember {
        listOf(mutableStateListOf(false, false), mutableStateListOf(false, false))
    }

    Box(modifier = Modifier.wrapContentSize(Alignment.TopStart)) {
        TooltipBox(
            positionProvider =
            TooltipDefaults.rememberTooltipPositionProvider(TooltipAnchorPosition.Above),
            tooltip = { PlainTooltip { Text("Localized description") } },
            state = rememberTooltipState(),
        ) {
            IconButton(onClick = { expanded = true }) {
                Icon(
                    Icons.Default.MoreVert,
                    contentDescription = "Localized description",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        }
        DropdownMenuPopup(expanded = expanded, onDismissRequest = { expanded = false }) {
            val groupCount = groupLabels.size
            groupLabels.fastForEachIndexed { groupIndex, label ->
                DropdownMenuGroup(
                    shapes = MenuDefaults.groupShape(groupIndex, groupCount),
                    interactionSource = groupInteractionSource,
                ) {
                    MenuDefaults.Label {
                        Text(
                            text = label,
                            color = MaterialTheme.colorScheme.tertiary
                        )
                    }
                    HorizontalDivider(
                        modifier = Modifier.padding(MenuDefaults.HorizontalDividerPadding),
                        color = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.2f)
                    )
                    val groupItemCount = groupItemLabels[groupIndex].size
                    groupItemLabels[groupIndex].fastForEachIndexed { itemIndex, itemLabel ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    itemLabel,
                                    color = MaterialTheme.colorScheme.tertiary
                                )
                            },
                            supportingText =
                            groupItemSupportingText[groupIndex][itemIndex]?.let { supportingText
                                ->
                                {
                                    Text(
                                        supportingText,
                                        color = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.7f)
                                    )
                                }
                            },
                            shapes = MenuDefaults.itemShape(itemIndex, groupItemCount),
                            leadingIcon =
                            groupItemLeadingIcons[groupIndex][itemIndex]?.let { iconData ->
                                {
                                    Icon(
                                        iconData,
                                        modifier = Modifier.size(MenuDefaults.LeadingIconSize),
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.tertiary
                                    )
                                }
                            },
                            checkedLeadingIcon = {
                                Icon(
                                    groupItemCheckedLeadingIcons[groupIndex][itemIndex],
                                    modifier = Modifier.size(MenuDefaults.LeadingIconSize),
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.tertiary
                                )
                            },
                            trailingIcon =
                            if (checked[groupIndex][itemIndex]) {
                                groupItemCheckedTrailingIcons[groupIndex][itemIndex]?.let {
                                        iconData ->
                                    {
                                        Icon(
                                            iconData,
                                            modifier =
                                            Modifier.size(MenuDefaults.TrailingIconSize),
                                            contentDescription = null,
                                            tint = MaterialTheme.colorScheme.tertiary
                                        )
                                    }
                                }
                            } else {
                                groupItemTrailingIcons[groupIndex][itemIndex]?.let { iconData ->
                                    {
                                        Icon(
                                            iconData,
                                            modifier =
                                            Modifier.size(MenuDefaults.TrailingIconSize),
                                            contentDescription = null,
                                            tint = MaterialTheme.colorScheme.tertiary
                                        )
                                    }
                                }
                            },
                            checked = checked[groupIndex][itemIndex],
                            onCheckedChange = { checked[groupIndex][itemIndex] = it },
                        )
                    }
                }

                if (groupIndex != groupCount - 1) {
                    Spacer(Modifier.height(MenuDefaults.GroupSpacing))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropDownMenuKiko() {
    val options = listOf("Item 1", "Item 2", "Item 3")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[1]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
    ) {
        OutlinedTextField(
            modifier = Modifier.menuAnchor(MenuAnchorType.PrimaryNotEditable),
            value = selectedOptionText,
            onValueChange = {},
            readOnly = true,
            label = { Text("Label") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.tertiary,
                unfocusedBorderColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.5f),
                focusedTextColor = MaterialTheme.colorScheme.tertiary,
                unfocusedTextColor = MaterialTheme.colorScheme.tertiary,
                focusedLabelColor = MaterialTheme.colorScheme.tertiary,
                unfocusedLabelColor = MaterialTheme.colorScheme.tertiary
            ),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption, color = MaterialTheme.colorScheme.tertiary) },
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    modifier = if (selectionOption == selectedOptionText) {
                        Modifier.background(MaterialTheme.colorScheme.tertiary.copy(alpha = 0.1f))
                    } else {
                        Modifier
                    }
                )
            }
        }
    }
}

@Composable
fun DropDownMenuScreenKiko() {
    Column(
        modifier = Modifier.fillMaxSize().padding(top = 64.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Text("Standard DropDown Menu", color = MaterialTheme.colorScheme.tertiary)
        DropDownMenuKiko()
        
        Text("Exposed DropDown Menu (Select)", color = MaterialTheme.colorScheme.tertiary)
        ExposedDropDownMenuKiko()
    }
}

// ==============================
// Previews Light
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "DropDownMenu Light")
@Composable
fun DropDownMenuKikoPreviewLight() {
    KikoComponentesTheme(darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            DropDownMenuScreenKiko()
        }
    }
}

// ==============================
// Previews Dark
// ==============================
@Preview(showBackground = true, showSystemUi = true, name = "DropDownMenu Dark")
@Composable
fun DropDownMenuKikoPreviewDark() {
    KikoComponentesTheme(darkTheme = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            DropDownMenuScreenKiko()
        }
    }
}
