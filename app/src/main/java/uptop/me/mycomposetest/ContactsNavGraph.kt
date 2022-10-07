package uptop.me.mycomposetest

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.jayasuryat.dowel.annotation.Dowel
import com.jayasuryat.dowel.annotation.DowelList

fun NavGraphBuilder.contactsNavGraph(navController: NavHostController) {
    navigation(
        route = Directions.contactsRoute.destination,
        startDestination = Directions.contacts.destination
    ) {
        composable(Directions.contacts.destination) {
            val list = ((0..25).map {
                User(
                    name = "User $it",
                    surname = "Surname $it"
                )
            })
            ContactsScreen(navController, list)
        }
    }
}

@Composable
fun ContactsScreen(
    navController: NavHostController,
    userList: List<User>
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(userList.size) { index ->
            ClickableText(
                text = AnnotatedString("Hello ${userList[index].name}!"),
                onClick = { /*navController.navigate(Directions.chatDetail.destination)*/ }
            )
        }
    }
}

@Preview
@Composable
fun ContactsScreenPreview(
    @PreviewParameter(UserListPreviewParamProvider::class) values: List<User>
) {
    val navController = rememberNavController()
    ContactsScreen(navController, values)
}

@DowelList(count = 1)
@Dowel(count = 10)
data class User(
    val name: String,
    val surname: String
)