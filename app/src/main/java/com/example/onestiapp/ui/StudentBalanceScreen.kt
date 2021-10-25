package com.example.onestiapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PushPin
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onestiapp.data.PaymentSchedule
import com.example.onestiapp.data.StudentBalance
import com.example.onestiapp.data.getTotalBalance
import com.example.onestiapp.ui.components.OneStiDivider
import com.example.onestiapp.ui.components.OneStiSelectionButton
import com.example.onestiapp.ui.theme.*

@Composable
fun StudentBalanceScreen(
    text: String,
    items: List<String>,
    studentBalance: StudentBalance,
    onItemClicked: (String) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val termsList = listOf(
            "2021-2022 First Term",
            "2020-2021 Second Term",
            "2020-2021 First Term",
            "2019-2020 Second Term",
            "2019-2020 First Term",
        )
        OneStiSelectionButton(
            text = text,
            alertDialogTitle = "School Year/Term",
            items = items
        ) {
            onItemClicked(it)
        }
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            AmountBalanceText(
                text = "Total Balance",
                style = MaterialTheme.typography.subtitle1,
                amountBalance = getTotalBalance(studentBalance = studentBalance),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Amber400)
                    .padding(vertical = 10.dp, horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            PaymentScheduleCard(studentBalance = studentBalance)
            Spacer(modifier = Modifier.height(16.dp))
            GrossAssessmentCard()
            Spacer(modifier = Modifier.height(8.dp))
            AmountBalanceText(
                text = "Total Payments and Adjustments",
                style = MaterialTheme.typography.subtitle2.copy(color = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = LightBlue900)
                    .padding(10.dp)
            )
            AmountBalanceText(
                text = "Assessment Balance",
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Amber400)
                    .padding(10.dp)
            )
        }
    }
}

@Composable
private fun AmountBalanceText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    amountBalance: Double = 0.00,
) {
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = style
        )
        Text(
            text = "PhP ${String.format("%,.2f", amountBalance)}",
            style = style
        )
    }
}

@Composable
private fun PaymentScheduleCard(studentBalance: StudentBalance) {
    Card(
        elevation = 2.dp
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Payment Schedule",
                style = MaterialTheme.typography.subtitle1
            )
            OneStiDivider(Modifier.padding(vertical = 6.dp))
            if (studentBalance.paymentScheduleList.isEmpty()) {
                Text(text = "No schedule available.", style = MaterialTheme.typography.body2)
            } else {
                studentBalance.paymentScheduleList.forEach {
                    Spacer(modifier = Modifier.height(4.dp))
                    PaymentScheduleItems(it)
                }
            }
        }
    }
}

@Composable
private fun PaymentScheduleItems(paymentSchedule: PaymentSchedule) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (paymentSchedule.amountBalance != null) {
            Text(text = paymentSchedule.scheduleDate, style = MaterialTheme.typography.body2)
            Text(
                text = "PhP ${String.format("%,.2f", paymentSchedule.amountBalance)}",
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Composable
private fun GrossAssessmentCard() {
    Card(
        elevation = 2.dp
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Gross Assessment",
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    text = "PhP 0.00",
                    style = MaterialTheme.typography.subtitle1
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            OneStiDivider(Modifier.padding(vertical = 6.dp))
            val items = listOf("Tuition Fee", "Other School Fees", "Miscellaneous Fees")
            items.forEach {
                AssessmentItems(text = it)
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Payments and Adjustment",
                style = MaterialTheme.typography.subtitle1
            )
            OneStiDivider(Modifier.padding(vertical = 6.dp))
            Text(text = "No data available.", style = MaterialTheme.typography.body2)
        }
    }
}

@Composable
private fun AssessmentItems(text: String) {
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .background(GrossAssessmentColor)
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            Icon(
                imageVector = Icons.Default.PushPin,
                contentDescription = Icons.Default.PushPin.name,
                modifier = Modifier
                    .size(16.dp)
                    .rotate(45f)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.subtitle2
            )
        }
        Text(
            text = "PhP 0.00",
            style = MaterialTheme.typography.subtitle2
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Preview(showBackground = true, backgroundColor = 0xFAFAFA)
@Composable
fun StudentBalanceScreenPreview() {
    OneStiAppTheme {
        StudentBalanceScreen(
            text = "2021-2022 First Term",
            items = listOf(
                "2021-2022 First Term",
                "2020-2021 Second Term",
                "2020-2021 First Term",
                "2019-2020 Second Term",
                "2019-2020 First Term",
            ),
            studentBalance = StudentBalance.ThirdYearFirstTerm
        ) {

        }
    }
}