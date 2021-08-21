package com.javalon.clubhouseclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.javalon.clubhouseclone.R
import com.javalon.clubhouseclone.model.CurrentModel

@Composable
fun CurrentSection() {
    Column(
        modifier = Modifier.wrapContentHeight()
    ) {
        Text(
            text = "Happening now", color = Color.Black,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(top = 16.dp)
        )
        getCurrentEvents().forEach {
            CurrentEvent(currentModel = it)
        }
    }
}

@Composable
fun CurrentEvent(currentModel: CurrentModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
            .height(150.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(color = MaterialTheme.colors.surface),
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 15.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = currentModel.title, color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h3.copy(fontSize = 20.sp),
            )
            Text(
                text = currentModel.desc, color = colorResource(id = R.color.darker_gray),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.subtitle2
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
            ) {
                Row {
                    currentModel.invitees.forEach {
                        ImageRow(image = it)
                    }
                }

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .background(color = colorResource(id = R.color.dark_gray)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.padding(start = 12.dp).scale(0.75f)
                    )

                    Text(
                        text = "${currentModel.attendees}", color = Color.Black,
                        style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Medium),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(start = 6.dp, top = 8.dp, bottom = 8.dp)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.mic), contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.padding(start = 8.dp).scale(0.75f)
                    )

                    Text(
                        text = "${currentModel.speakers}", color = Color.Black,
                        style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Medium),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(start = 4.dp, end = 12.dp)
                    )
                }
            }

        }
    }
}

@Composable
fun ImageRow(image: Int) {
    Image(
        painter = painterResource(id = image), contentDescription = null,
        modifier = Modifier
            .padding(end = 8.dp)
            .size(32.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}

fun getCurrentEvents(): List<CurrentModel> {
    val desc = "Pitch your start up idea to VCs & top Entrepreneurs"
    return listOf(
        CurrentModel(
            "STARTUP CLUB", desc, 354, 7,
            listOf(R.drawable.user11, R.drawable.user7, R.drawable.user2)
        ),
        CurrentModel(
            "DATING GAME + SHOOT SHOT", desc, 754, 9,
            listOf(R.drawable.user9, R.drawable.user8, R.drawable.user5)
        )
    )
}