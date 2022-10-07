package uptop.me.mycomposetest

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.chatGraph(navController: NavHostController) {
    navigation(
        route = Directions.chatRoute.destination,
        startDestination = Directions.chat.destination
    ) {
        composable(Directions.chat.destination) {
            ChatScreen(navController)
        }
        composable(Directions.chatDetail.destination) {
            ChatDetailScreen(navController)
        }
    }
}

@Composable
fun ChatScreen(navController: NavHostController) {
    val list = listOf(
        "A", "B", "C", "D"
    ) + ((0..100).map { it.toString() })
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(list.size) { index ->
            ClickableText(
                text = AnnotatedString("Hello ${list[index]}!"),
                onClick = { navController.navigate(Directions.chatDetail.destination) }
            )
        }
    }
}

@Composable
fun ChatDetailScreen(navController: NavHostController) {
    Row {
        ClickableText(
            text = AnnotatedString("Hello!"),
            onClick = { navController.popBackStack(route = Directions.chat.destination, inclusive = true) }
        )
    }
}