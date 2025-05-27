package com.quickphrase.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.quickphrase.myapplication.ui.theme.TranslatedPhraseScreen
import com.quickphrase.myapplication.ui.theme.PhrasePack

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val emergencyPack = PhrasePack(
                    category = "Emergencies",
                    phrases = listOf(
                        MultilingualPhrase(
                            english = "Call the police",
                            spanish = "Llama a la policía",
                            french = "Appelez la police",
                            german = "Rufen Sie die Polizei",
                            mandarin = "报警",
                            russian = "Вызовите полицию",
                            hindi = "पुलिस को बुलाओ",
                            arabic = "اتصل بالشرطة",
                            bengali = "পুলিশ ডাকুন",
                            portuguese = "Chame a polícia"
                        ),
                        MultilingualPhrase(
                            english = "Where is the hospital?",
                            spanish = "¿Dónde está el hospital?",
                            french = "Où est l'hôpital?",
                            german = "Wo ist das Krankenhaus?",
                            mandarin = "医院在哪里？",
                            russian = "Где больница?",
                            hindi = "अस्पताल कहाँ है?",
                            arabic = "أين المستشفى؟",
                            bengali = "হাসপাতাল কোথায়?",
                            portuguese = "Onde fica o hospital?"
                        ),
                        MultilingualPhrase(
                            english = "I'm lost",
                            spanish = "Estoy perdido",
                            french = "Je suis perdu",
                            german = "Ich habe mich verlaufen",
                            mandarin = "我迷路了",
                            russian = "Я потерялся",
                            hindi = "मैं खो गया हूँ",
                            arabic = "أنا ضائع",
                            bengali = "আমি হারিয়ে গেছি",
                            portuguese = "Estou perdido"
                        ),
                        MultilingualPhrase(
                            english = "I need help",
                            spanish = "Necesito ayuda",
                            french = "J'ai besoin d'aide",
                            german = "Ich brauche Hilfe",
                            mandarin = "我需要帮助",
                            russian = "Мне нужна помощь",
                            hindi = "मुझे मदद चाहिए",
                            arabic = "أحتاج إلى مساعدة",
                            bengali = "আমার সাহায্য দরকার",
                            portuguese = "Preciso de ajuda"
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
