package uptop.me.mycomposetest

import androidx.navigation.NamedNavArgument

object Directions {

    val main = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "root"
    }

    val chatRoute = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "chatRoute"
    }

    val chat = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "chat"
    }

    val chatDetail = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "chatDetail"
    }

    val contactsRoute = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "contactsRoute"
    }

    val contacts = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "contacts"
    }
}