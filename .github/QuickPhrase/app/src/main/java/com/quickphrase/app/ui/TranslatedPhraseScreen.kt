package com.quickphrase.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quickphrase.app.model.PhrasePack

@Composable
fun TranslatedPhraseScreen(pack: PhrasePack) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text(
            text = pack.category,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(pack.phrases) { phrase ->
                Text("English: ${phrase.original}", style = MaterialTheme.typography.bodyLarge)
                Text("Spanish: ${phrase.spanish}")
                Text("French: ${phrase.french}")
                Text("German: ${phrase.german}")
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
