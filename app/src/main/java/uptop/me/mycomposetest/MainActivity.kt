package uptop.me.mycomposetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uptop.me.mycomposetest.ui.theme.MyComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavGraph(navController)
                }
            }
        }
    }
}

@Composable
fun MainScreen(name: String, navController: NavHostController) {
    val openDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ClickableText(
            text = AnnotatedString("Hello $name!"),
            onClick = { openDialog.value = true }
        )

        if (openDialog.value) ChoiceDialog(openDialog, navController)
    }
}

@Composable
private fun ChoiceDialog(openDialog: MutableState<Boolean>, navController: NavHostController) {
    AlertDialog(
        onDismissRequest = { openDialog.value = false },
        title = { Text(text = "Куда хотите перейти?") },
        confirmButton = {
            Button(
                onClick = {
                    openDialog.value = false
                    navController.navigate(Directions.chat.destination)
                }) {
                Text("Перейти в чат")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    openDialog.value = false
                    navController.navigate(Directions.contacts.destination)
                }) {
                Text("Перейти в контакты")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MyComposeTestTheme {
        val navController = rememberNavController()
        MainScreen("Android", navController)
    }
}