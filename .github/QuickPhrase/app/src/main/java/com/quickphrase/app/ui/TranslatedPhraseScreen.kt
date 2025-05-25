package com.quickphrase.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quickphrase.app.model.PhrasePack

enum class Language(val displayName: String) {
    All("All"),
    English("English"),
    Spanish("Spanish"),
    French("French"),
    German("German")
}

@Composable
fun TranslatedPhraseScreen(pack: PhrasePack) {
    var selectedLanguage by remember { mutableStateOf(Language.All) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text(
            text = pack.category,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Language picker dropdown
        LanguageDropdown(selectedLanguage) { selectedLanguage = it }

        Spacer(Modifier.height(16.dp))

        LazyColumn {
            items(pack.phrases) { phrase ->
                when (selectedLanguage) {
                    Language.All -> {
                        Text("English: ${phrase.original}", style = MaterialTheme.typography.bodyLarge)
                        Text("Spanish: ${phrase.spanish}")
                        Text("French: ${phrase.french}")
                        Text("German: ${phrase.german}")
                    }
                    Language.English -> Text("English: ${phrase.original}")
                    Language.Spanish -> Text("Spanish: ${phrase.spanish}")
                    Language.French -> Text("French: ${phrase.french}")
                    Language.German -> Text("German: ${phrase.german}")
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun LanguageDropdown(selected: Language, onSelected: (Language) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Button(onClick = { expanded = true }) {
            Text(selected.displayName)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            Language.values().forEach { lang ->
                DropdownMenuItem(
                    text = { Text(lang.displayName) },
                    onClick = {
                        onSelected(lang)
                        expanded = false
                    }
                )
            }
        }
    }
}
