package com.example.zmauto.screens.payment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zmauto.R
import androidx.compose.ui.text.TextStyle

@Composable
fun ThankYouScreen(onExitClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(start = 16.dp, top = 20.dp, end = 16.dp, bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF149459))
                    .clickable { onExitClick() },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = "Close",
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "THANK YOU",
                style = TextStyle(
                    fontSize = 27.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF000000),
                    lineHeight = 219.sp / 21
                ),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(40.dp))
        }

        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Car Keys",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(340.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Thank you for choosing our car rental service! We’ve noted your preference for cash payment. Please ensure you bring along your valid driver’s license during pickup for verification purposes. If you have any questions feel free to contact us",
            style = TextStyle(
                fontSize = 23.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF000000),
                lineHeight = 250.sp / 8
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 35.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onExitClick,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF149459)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(54.dp)
        ) {
            Text(
                text = "Exit",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(35.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ThankYouScreenPreview() {
    ThankYouScreen(onExitClick = {})
}
