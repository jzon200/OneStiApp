package com.example.onestiapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onestiapp.data.*

class OneStiViewModel : ViewModel() {
    private val _classScheduleText = MutableLiveData("Today | ${getDay()}")
    val classScheduleText: LiveData<String> = _classScheduleText
    private val _classScheduleItems = MutableLiveData(getCurrentClassSchedule())
    val classScheduleItems: LiveData<List<ClassSchedule>> = _classScheduleItems

    private val _studentBalance = MutableLiveData(StudentBalance.ThirdYearFirstTerm)
    val studentBalance: LiveData<StudentBalance> = _studentBalance

    private val _yearText = MutableLiveData("2021-2022 First Term")
    val yearText: LiveData<String> = _yearText

    fun onYearTextChanged(newText: String) {
        _yearText.value = newText
    }

    fun onStudentBalanceChanged(newBalance: StudentBalance) {
        _studentBalance.value = newBalance
    }

    fun onTextChanged2(newText: String) {
        _classScheduleText.value = if (getDay() == newText) "Today | ${getDay()}" else newText
    }
    fun getClassSchedule(selected: String) {
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