package com.example.onestiapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

val drawerScreens = listOf(
    Screens.DrawerScreens.Home,
    Screens.DrawerScreens.Information.Grades,
    Screens.DrawerScreens.Information.ClassSchedule,
    Screens.DrawerScreens.Information.ProgramCurriculum,
    Screens.DrawerScreens.Information.StudentBalance,
    Screens.DrawerScreens.Others.PaymentService,
    Screens.DrawerScreens.Others.HistoryMissionVision,
    Screens.DrawerScreens.Others.Feedback,
    Screens.DrawerScreens.Others.RateUs,
    Screens.DrawerScreens.Others.About,
    Screens.DrawerScreens.Others.Faqs,
    Screens.DrawerScreens.Others.Logout,
)

val informationScreens = listOf(
    Screens.DrawerScreens.Information.Grades,
    Screens.DrawerScreens.Information.ClassSchedule,
    Screens.DrawerScreens.Information.ProgramCurriculum,
    Screens.DrawerScreens.Information.StudentBalance
)

val otherScreens = listOf(
    Screens.DrawerScreens.Others.PaymentService,
    Screens.DrawerScreens.Others.HistoryMissionVision,
    Screens.DrawerScreens.Others.Feedback,
    Screens.DrawerScreens.Others.RateUs,
    Screens.DrawerScreens.Others.About,
    Screens.DrawerScreens.Others.Faqs,
    Screens.DrawerScreens.Others.Logout,
)

/**
 * This class is used for Navigation routes.
 * @param route - The route of the screen navigation.
 * @param title - The title of TopBar.
 */
sealed class Screens(val route: String, val title: String) {
    object Home : Screens("home", "Home")
    object Grades : Screens("grades", "My Grades")
    object ClassSchedule : Screens("classSchedule", "My Class Schedule")
    object ProgramCurriculum : Screens("programCurriculum", "Program Curriculum")
    object StudentBalance : Screens("studentBalance", "Student Balance")

    sealed class DrawerScreens(
        route: String,
        title: String,
        val icon: ImageVector
    ) : Screens(route, title) {
        object Home : DrawerScreens(
            route = "home",
            title = "Home",
            icon = Icons.Default.Home
        )

        sealed class Information(
            route: String,
            title: String,
            icon: ImageVector
        ) : DrawerScreens(route, title, icon) {
            object Grades :
                Information(
                    route = "grades",
                    title = "View Grades",
                    icon = Icons.Default.Grade
                )

            object ClassSchedule : Information(
                route = "classSchedule",
                title = "View Class Schedule",
                icon = Icons.Default.Schedule
            )

            object ProgramCurriculum : Information(
                route = "programCurriculum",
                title = "Program Curriculum",
                icon = Icons.Default.School
            )

            object StudentBalance : Information(
                route = "studentBalance",
                title = "Student Balance",
                icon = Icons.Default.AttachMoney
            )
        }

        sealed class Others(
            route: String,
            title: String,
            icon: ImageVector
        ) : DrawerScreens(route, title, icon) {
            object PaymentService :
                Others(
                    route = "paymentService",
                    title = "Alternative Payment Service",
                    icon = Icons.Default.Payment
                )

            object HistoryMissionVision : Others(
                route = "historyMissionVision",
                title = "History, Mission & Vision",
                icon = Icons.Default.HistoryEdu
            )

            object Feedback : Others(
                route = "feedback",
                title = "Feedback",
                icon = Icons.Default.Feedback
            )

            object RateUs : Others(
                route = "rateUs",
                title = "Rate Us!",
                icon = Icons.Default.Star
            )

            object About : Others(
                route = "about",
                title = "About",
                icon = Icons.Default.Info
            )

            object Faqs : Others(
                route = "faqs",
                title = "FAQs",
                icon = Icons.Default.QuestionAnswer
            )

            object Logout : Others(
                route = "logout",
                title = "Logout",
                icon = Icons.Default.ExitToApp
            )

        }

    }
}
