package com.javalon.clubhouseclone.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.javalon.clubhouseclone.R
import com.javalon.clubhouseclone.ui.theme.ClubHouseCloneTheme

@Composable
fun Home(navController: NavController) {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .padding(15.dp)
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HeaderSection()
        ChipSection()
        UpcomingSection()
        BottomSection(navController)
    }
}

@Composable
fun HeaderSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "Good Morning,\nBernice",
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Start,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Row {
            val searchPainter = painterResource(id = R.drawable.search)
            Icon(
                painter = searchPainter, contentDescription = "Search",
                modifier = Modifier
                    .size(22.dp)
                    .align(Alignment.CenterVertically)
            )

            Box(
                contentAlignment = Alignment.Center, modifier = Modifier
                    .padding(start = 22.dp)
                    .wrapContentWidth()
                    .size(48.dp, 48.dp)
                    .clip(RoundedCornerShape(72f))
                    .background(colorResource(id = R.color.dark_blue))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "user",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .scale(0.9f)
                )
            }
        }

    }

}

@Composable
fun UpcomingSection() {
    Column {
        Text(
            text = "Upcoming", color = Color.Black,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(top = 12.dp)
        )
        Spacer(modifier = Modifier.height(14.dp))
        UpcomingInfo()
        Spacer(modifier = Modifier.height(14.dp))
        CurrentSection()
    }
}

@Composable
fun UpcomingInfo() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(colorResource(id = R.color.dark_blue))
            .height(120.dp)
    ) {
        Row {
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 15.dp, vertical = 40.dp)
                    .width(2.dp)
                    .background(colorResource(id = R.color.divider_bg))
            )

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 34.dp)
            ) {
                Text(
                    text = "10:00 - 20:00",
                    color = Color.White,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "Design talks and Chill",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle1.copy(fontSize = 20.sp),
                    textAlign = TextAlign.Start
                )
            }
        }

        Row {
            Icon(
                painter = painterResource(id = R.drawable.expand_arrow),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .padding(end = 22.dp)
                    .scale(0.65f)
            )
        }
    }
}

@Composable
fun BottomSection(navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(15.dp))
            .height(90.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(color = MaterialTheme.colors.surface),
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                painter = painterResource(id = R.drawable.calendar),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .weight(1f)
                    .background(
                        color = colorResource(id = R.color.dark_gray),
                        shape = RoundedCornerShape(25f)
                    )
                    .size(40.dp)
                    .scale(0.7f)
            )

            Button(
                onClick = {
                    navController.navigate("room")
                },
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
                    .padding(horizontal = 7.dp, vertical = 12.dp)
                    .clip(RoundedCornerShape(15.dp)),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.dark_blue)),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_round_add_circle),
                    tint = Color.White,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Start room", color = Color.White,
                    style = MaterialTheme.typography.subtitle2,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .weight(1f)
                    .background(
                        color = colorResource(id = R.color.dark_gray),
                        shape = RoundedCornerShape(25f)
                    )
                    .size(40.dp)
                    .scale(0.7f)
            )
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, heightDp = 640, name = "Light Preview")
@Composable
fun HomePreview() {
    ClubHouseCloneTheme {
        Home(rememberAnimatedNavController())
    }
}