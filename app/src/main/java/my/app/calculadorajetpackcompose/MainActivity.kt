package my.app.calculadorajetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import my.app.calculadorajetpackcompose.ui.theme.CalculadoraJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraJetPackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun LabelTextField(text: String, modifier: Modifier = Modifier) {
    Text(text = "$text",modifier = modifier)

}

@Composable
fun TextFieldNumber(value: String, onValueChange: (String) -> Unit, label: String? = null) {
    TextField(value, onValueChange,label = {label?.let{  Text(it) }})
}

@Preview(showBackground = true)
@Composable
fun CalculadoraPreview() {
    CalculadoraJetPackComposeTheme {
        var textValue by remember { mutableStateOf("") }

        Column (modifier = Modifier

        ) {
            Row (modifier = Modifier
            ) {
                LabelTextField("Número 1:", modifier = Modifier.align(Alignment.CenterVertically))
                TextFieldNumber(textValue, {textValue = it}, "Número 1:")
            }

            Row (modifier = Modifier
            ) {
                LabelTextField("Número 1:", modifier = Modifier.align(Alignment.CenterVertically))
                TextFieldNumber(textValue, {textValue = it}, "Número 1:")
            }

        }
    }
}