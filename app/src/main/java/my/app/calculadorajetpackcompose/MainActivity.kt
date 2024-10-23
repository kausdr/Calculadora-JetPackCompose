package my.app.calculadorajetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import my.app.calculadorajetpackcompose.ui.theme.CalculadoraJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraJetPackComposeTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
                CalculadoraUI()
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
fun TextComposable(text: String, modifier: Modifier = Modifier) {
    Text(text = "$text",modifier = modifier)

}

@Composable
fun TextResult(text: String, modifier: Modifier = Modifier, style: androidx.compose.ui.text.TextStyle) {
    Text(text = "$text",modifier = modifier, style = style)

}

@Composable
fun TextFieldNumber(value: String, onValueChange: (String) -> Unit, label: String? = null) {
    TextField(value, onValueChange,label = {label?.let{  Text(it) }})
}

@Composable
fun ButtonPlus(number1: String, number2: String, onResultChange: (String) -> Unit) {
    val num1 = number1.toIntOrNull() ?: 0
    val num2 = number2.toIntOrNull() ?: 0

   Button(
    modifier = Modifier
        .height(50.dp),
       onClick = {
           onResultChange((num1+num2).toString())
       }
   ) {
        TextComposable(text = "+")
   }
}

@Composable
fun ButtonMinus(number1: String, number2: String, onResultChange: (String) -> Unit) {
    val num1 = number1.toIntOrNull() ?: 0
    val num2 = number2.toIntOrNull() ?: 0

    Button(
        modifier = Modifier
            .height(50.dp),
        onClick = {
            onResultChange((num1-num2).toString())
        }
    ) {
        TextComposable(text = "-")
    }
}

@Composable
fun ButtonTimes(number1: String, number2: String, onResultChange: (String) -> Unit) {
    val num1 = number1.toIntOrNull() ?: 0
    val num2 = number2.toIntOrNull() ?: 0

    Button(
        modifier = Modifier
            .height(50.dp),
        onClick = {
            onResultChange((num1*num2).toString())
        }
    ) {
        TextComposable(text = "*")
    }
}

@Composable
fun ButtonDivide(number1: String, number2: String, onResultChange: (String) -> Unit) {
    val num1 = number1.toIntOrNull() ?: 0
    val num2 = number2.toIntOrNull() ?: 0

    Button(
        modifier = Modifier
            .height(50.dp),
        onClick = {
            onResultChange((num1/num2).toString())
        }
    ) {
        TextComposable(text = "/")
    }
}


@Composable
fun CalculadoraUI() {
    CalculadoraJetPackComposeTheme {
        var textNumber1 by remember { mutableStateOf("") }
        var textNumber2 by remember { mutableStateOf("") }
        var resultado by remember { mutableStateOf("") }

        Column (modifier = Modifier
                .fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Row (modifier = Modifier
            ) {
                TextComposable("Número 1:", modifier = Modifier.align(Alignment.CenterVertically))
                TextFieldNumber(textNumber1, {textNumber1 = it}, "Número 1:")
            }

            Row (modifier = Modifier
            ) {
                TextComposable("Número 2:", modifier = Modifier.align(Alignment.CenterVertically))
                TextFieldNumber(textNumber2, {textNumber2 = it}, "Número 2:")
            }

            Row(modifier = Modifier
            ) {
                ButtonPlus(textNumber1, textNumber2, onResultChange = { resultado = it })
                ButtonMinus(textNumber1, textNumber2, onResultChange = { resultado = it })
                ButtonTimes(textNumber1, textNumber2, onResultChange = { resultado = it })
                ButtonDivide(textNumber1, textNumber2, onResultChange = { resultado = it })
            }


            Column (
                modifier = Modifier
            ){
            TextResult(text = resultado,
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    background = Color.Green

                )

            )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculadoraPreview() {
    CalculadoraJetPackComposeTheme {
        CalculadoraUI()
    }
}