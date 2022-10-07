package uptop.me.mycomposetest

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Directions.main.destination
    ) {
        composable(Directions.main.destination) {
            MainScreen("fuck", navController)
        }
        chatGraph(navController)
        contactsNavGraph(navController)
    }

}