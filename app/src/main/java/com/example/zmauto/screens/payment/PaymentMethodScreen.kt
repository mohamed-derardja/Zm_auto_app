package com.example.zmauto.screens.payment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zmauto.R

private const val CASH = "Cash"
private const val CARD = "Card"

data class PaymentMethodOption(
    val title: String,
    val subtitle: String,
    val key: String,
    val iconRes: Int? = null
)

@Composable
fun PaymentMethodScreen(
    onBackClick: () -> Unit,
    onContinueClick: () -> Unit
) {
    var selectedOption by remember { mutableStateOf(CASH) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F5FA))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                PaymentHeader(onBackClick = onBackClick)
                PaymentOptions(selectedOption) { selectedOption = it }
            }
            ContinueButton(onClick = onContinueClick)
        }
    }
}

@Composable
private fun PaymentHeader(onBackClick: () -> Unit) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val topPadding = with(LocalDensity.current) {
        WindowInsets.statusBars.getTop(this).toDp()
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = topPadding + 2.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.White)
                .border(1.dp, Color.Black, CircleShape)
                .clickable(onClick = onBackClick),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.fleche_icon_lonly),
                contentDescription = "Back",
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = "Payment method",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            modifier = Modifier.padding(start = 8.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.sparcles),
            contentDescription = "Sparkle",
            modifier = Modifier
                .size((screenWidth * 0.2f).coerceAtMost(72.dp))
                .offset(x = 11.dp)
        )
    }
}

@Composable
private fun PaymentOptions(
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    val options = listOf(
        PaymentMethodOption(
            title = "Cash",
            subtitle = "DA cash",
            key = CASH
        ),
        PaymentMethodOption(
            title = "Card Edahabia",
            subtitle = "Add Card",
            key = CARD,
            iconRes = R.drawable.credit_card_icon
        )
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        options.forEachIndexed { index, option ->
            PaymentOption(
                title = option.title,
                subtitle = option.subtitle,
                isSelected = selectedOption == option.key,
                onSelect = { onOptionSelected(option.key) },
                iconRes = option.iconRes
            )
            if (index < options.lastIndex) {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun PaymentOption(
    title: String,
    subtitle: String,
    isSelected: Boolean,
    onSelect: () -> Unit,
    iconRes: Int?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Medium,
                color = Color.Black
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = if (isSelected) 1.5.dp else 1.dp,
                    color = if (isSelected) Color(0xFF149459) else Color.Black,
                    shape = RoundedCornerShape(12.dp)
                )
                .background(Color.White, RoundedCornerShape(12.dp))
                .clickable(onClick = onSelect)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                PaymentLabelRow(icon = iconRes, label = subtitle)

                RadioButton(
                    selected = isSelected,
                    onClick = null,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color(0xFF149459),
                        unselectedColor = Color.Black
                    )
                )
            }
        }
    }
}

@Composable
private fun PaymentLabelRow(icon: Int?, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        if (icon != null) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Black
                )
            )
        } else {
            Text(
                text = "DA",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Black
                )
            )
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(16.dp)
                    .background(Color.Black)
            )
            Text(
                text = "cash",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Black
                )
            )
        }
    }
}

@Composable
private fun ContinueButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 18.dp),
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF149459),
            contentColor = Color.White
        )
    ) {
        Text(
            text = "Continue",
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = Color.White
            )
        )
    }
}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
fun PreviewPaymentMethod() {
    MaterialTheme {
        PaymentMethodScreen(
            onBackClick = {},
            onContinueClick = {}
        )
    }
} 