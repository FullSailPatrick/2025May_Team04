package com.quickphrase.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.quickphrase.app.model.MultilingualPhrase
import com.quickphrase.app.model.PhrasePack
import com.quickphrase.app.ui.TranslatedPhraseScreen
import com.quickphrase.app.ui.theme.QuickPhraseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            QuickPhraseTheme {
                val emergencyPack = PhrasePack(
                    category = "Emergencies",
                    phrases = listOf(
                        MultilingualPhrase(
                            "Call the police",
                            "Llame a la policía",
                            "Appelez la police",
                            "Rufen Sie die Polizei"
                        ),
                        MultilingualPhrase(
                            "Where is the hospital?",
                            "¿Dónde está el hospital?",
                            "Où est l'hôpital?",
                            "Wo ist das Krankenhaus?"
                        ),
                        MultilingualPhrase(
                            "I'm lost",
                            "Estoy perdido",
                            "Je suis perdu",
                            "Ich habe mich verlaufen"
                        ),
                        MultilingualPhrase(
                            "I need help",
                            "Necesito ayuda",
                            "J'ai besoin d'aide",
                            "Ich brauche Hilfe"
                        )
                    )
                )

                Surface(color = MaterialTheme.colorScheme.background) {
                    TranslatedPhraseScreen(pack = emergencyPack)
                }
            }
        }
    }
}
