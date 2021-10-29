package com.example.onestiapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onestiapp.Screens
import com.example.onestiapp.data.*

class MainViewModel : ViewModel() {
    private val termList = listOf(
        "2021-2022 First Term",
        "2020-2021 Second Term",
        "2020-2021 First Term",
        "2019-2020 Second Term",
        "2019-2020 First Term",
    )
    // Class Schedule Text Button initialize to Current Day
    private val _classScheduleTextButton = MutableLiveData("Today | ${getDay()}")
    val classScheduleTextButton: LiveData<String> = _classScheduleTextButton

    // initialize to Latest Term
    private val _gradesTextButton = MutableLiveData(termList.first())
    val gradesTextButton: LiveData<String> = _gradesTextButton

    // Class Schedule initialize to Current Day Schedule
    private val _classScheduleItems = MutableLiveData(getCurrentClassSchedule())
    val classScheduleItems: LiveData<List<ClassSchedule>> = _classScheduleItems

    // initialize to Latest Term
    private val _studentBalanceTextButton = MutableLiveData(termList.first())
    val studentBalanceTextButton: LiveData<String> = _studentBalanceTextButton

    // Student Balance set to Latest (3Y1T)
    private val _studentBalance = MutableLiveData(StudentBalance.ThirdYearFirstTerm)
    val studentBalance: LiveData<StudentBalance> = _studentBalance

    // Student Balance set to Latest (3Y1T)
    private val _gradesPerTerm = MutableLiveData(GradesPerTerm.ThirdYearFirstTerm)
    val gradesPerTerm: LiveData<GradesPerTerm> = _gradesPerTerm

    // Used to track the Current Screen displayed
    // and initialize to Screens.Home
    private val _currentScreen = MutableLiveData<Screens>(Screens.DrawerScreens.Home)
    val currentScreen: LiveData<Screens> = _currentScreen

    // Used to track the Current Screen displayed for
    // the Information Tabs (Grades, Class Schedule, etc.)
    private val _currentTabSelectedIndex = MutableLiveData(0)
    val currentTabSelectedIndex: LiveData<Int> = _currentTabSelectedIndex
    private val _navDrawerSelectedIndex = MutableLiveData(0)
    val navDrawerSelectedIndex: LiveData<Int> = _navDrawerSelectedIndex

    /**
     * Tracks the current screen displayed
     * This is invoke at the start in every Screens
     */
    fun setCurrentScreen(screen: Screens) {
        _currentScreen.value = screen
        _currentTabSelectedIndex.value = when (screen) {
            Screens.Grades -> 0
            Screens.ClassSchedule -> 1
            Screens.ProgramCurriculum -> 2
            Screens.StudentBalance -> 3
            else -> 0
        }
    }

    /**
     * Changes the Student Balance Data selected on
     * [StudentBalance] per term.
     */
    fun onStudentBalanceTermSelected(selected: String) {
        _studentBalanceTextButton.value = selected
        _studentBalance.value = when (selected) {
            termList[0] -> StudentBalance.ThirdYearFirstTerm
            termList[1] -> StudentBalance.SecondYearSecondTerm
            termList[2] -> StudentBalance.SecondYearFirstTerm
            termList[3] -> StudentBalance.FirstYearSecondTerm
            termList[4] -> StudentBalance.FirstYearFirstTerm
            else -> StudentBalance.ThirdYearFirstTerm
        }
    }

    /**
     * Changes the Grades Data selected on [GradesPerTerm].
     */
    fun onGradesTermSelected(selected: String) {
        _gradesTextButton.value = selected
        _gradesPerTerm.value = when (selected) {
            termList[0] -> GradesPerTerm.ThirdYearFirstTerm
            termList[1] -> GradesPerTerm.SecondYearSecondTerm
            termList[2] -> GradesPerTerm.SecondYearFirstTerm
            termList[3] -> GradesPerTerm.FirstYearSecondTerm
            termList[4] -> GradesPerTerm.FirstYearFirstTerm
            else -> GradesPerTerm.ThirdYearFirstTerm
        }
    }

    /**
     * Changes the Class Schedule Data selected on [ClassSchedule].
     */
    fun onClassScheduleSelected(selected: String) {
        _classScheduleTextButton.value = if (getDay() == selected) "Today | ${getDay()}" else selected
        _classScheduleItems.value = when (selected) {
            "Monday" -> mondayScheduleList
            "Tuesday" -> tuesdayScheduleList
            "Wednesday" -> wednesdayScheduleList
            "Thursday" -> thursdayScheduleList
            "Friday" -> fridayScheduleList
            "Saturday" -> saturdayScheduleList
            "Sunday" -> emptyList()
            "Entire Week" -> entireWeekScheduleList
            else -> getCurrentClassSchedule()
        }
    }
}