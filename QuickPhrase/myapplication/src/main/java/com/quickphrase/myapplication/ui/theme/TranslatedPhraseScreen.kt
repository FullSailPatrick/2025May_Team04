package com.quickphrase.myapplication.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.quickphrase.myapplication.MultilingualPhrase

enum class Language(val displayName: String, val color: Color) {
    English("English", Color(0xFF1976D2)),
    Spanish("Español", Color(0xFFD32F2F)),
    French("Français", Color(0xFF388E3C)),
    German("Deutsch", Color(0xFFFBC02D)),
    Mandarin("中文", Color(0xFF8E24AA)),
    Russian("Русский", Color(0xFF3949AB)),
    Hindi("हिन्दी", Color(0xFF0097A7)),
    Arabic("العربية", Color(0xFF6D4C41)),
    Bengali("বাংলা", Color(0xFF00897B)),
    Portuguese("Português", Color(0xFF5D4037))
}

@Composable
fun TranslatedPhraseScreen(
    pack: PhrasePack
) {
    var selectedLanguage by remember { mutableStateOf(Language.English) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LanguageDropdown(selectedLanguage, onLanguageSelected = { selectedLanguage = it })

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(pack.phrases) { phrase: MultilingualPhrase ->
                val translation = when (selectedLanguage) {
                    Language.English -> phrase.english
                    Language.Spanish -> phrase.spanish
                    Language.French -> phrase.french
                    Language.German -> phrase.german
                    Language.Mandarin -> phrase.mandarin
                    Language.Russian -> phrase.russian
                    Language.Hindi -> phrase.hindi
                    Language.Arabic -> phrase.arabic
                    Language.Bengali -> phrase.bengali
                    Language.Portuguese -> phrase.portuguese
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .background(selectedLanguage.color),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Text(
                        text = translation,
                        modifier = Modifier.padding(2.dp),
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Composable
fun LanguageDropdown(
    selectedLanguage: Language,
    onLanguageSelected: (Language) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Box {
        Button(onClick = { expanded = true }) {
            Text(selectedLanguage.displayName)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            Language.values().forEach { language ->
                DropdownMenuItem(
                    text = { Text(language.displayName) },
                    onClick = {
                        onLanguageSelected(language)
                        expanded = false
                    }
                )
            }
        }
    }
}
