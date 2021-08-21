package com.javalon.clubhouseclone.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.javalon.clubhouseclone.R
import com.javalon.clubhouseclone.model.Attendee
import com.javalon.clubhouseclone.ui.theme.ClubHouseCloneTheme

@ExperimentalFoundationApi
@Composable
fun Room() {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxSize()
    ) {
        TitleBar()
        GridAttendees(getAttendees())
        BottomSection()
    }
}

@Composable
fun TitleBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.expand_arrow),
            contentDescription = null,
            tint = colorResource(id = R.color.darker_gray),
            modifier = Modifier.scale(0.75f)
        )

        Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.fire_emoji),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .scale(1.2f)
            )

            Text(
                text = "DATING GAME...",
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun GridAttendees(attendees: List<Attendee>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 8.dp)
            .wrapContentHeight()
    ) {
        items(attendees.size) {
            AttendeeView(attendee = attendees[it])
        }
    }
}

@Composable
fun AttendeeView(attendee: Attendee) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 7.5.dp, end = 7.5.dp, bottom = 7.5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            Box {
                BoxWithConstraints(
                    contentAlignment = Alignment.Center, modifier = Modifier
                        .size(90.dp, 96.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(125f))
                        .background(colorResource(id = attendee.attendeeBg))

                ) {
                    Image(
                        painter = painterResource(id = attendee.attendeeImage),
                        contentDescription = "user",
                        contentScale = ContentScale.Inside,
                        modifier = Modifier
                            .scale(0.7f)
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.party_popper),
                    contentDescription = null,
                    modifier = Modifier
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(72f)
                        )
                        .size(28.dp)
                        .scale(0.75f)
                        .align(Alignment.BottomStart)
                )

                Image(
                    painter = painterResource(id = R.drawable.unmute_mic),
                    contentDescription = null,
                    modifier = Modifier
                        .background(
                            color = colorResource(id = R.color.dark_gray),
                            shape = RoundedCornerShape(72f)
                        )
                        .size(28.dp)
                        .scale(0.75f)
                        .align(Alignment.BottomEnd)
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 6.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.asterisk),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .background(
                        color = colorResource(id = R.color.blue),
                        shape = RoundedCornerShape(72f)
                    )
                    .size(18.dp)
                    .scale(0.8f)
            )

            Text(
                text = "${attendee.attendeeName}", color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}

@Composable
fun BottomSection() {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(color = colorResource(id = R.color.dark_blue))
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 1.dp, bottom = 8.dp)
        ) {
            TextField(
                value = "",
                onValueChange = {},
                label = {
                    Text(
                        text = "Type a thought here...",
                        color = colorResource(R.color.white_transparent),
                        style = MaterialTheme.typography.subtitle2,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = colorResource(id = R.color.white_transparent),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(28.dp),
                modifier = Modifier
                    .padding(end = 48.dp, top = 8.dp, bottom = 8.dp)
                    .weight(1f)
            )

            Icon(
                painter = painterResource(id = R.drawable.paper_plane),
                contentDescription = null,
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(360f)
                    )
                    .size(50.dp)
                    .scale(0.55f)
                    .weight(0.20f),
                tint = colorResource(id = R.color.dark_blue)
            )

        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(color = Color.White)
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .padding(vertical = 8.dp)
        ) {

            Row {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .padding(start = 12.dp, end = 12.dp, top = 24.dp, bottom = 24.dp)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(32.dp)),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.light_gray)),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.victory_hand),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Leave quietly",
                        style = MaterialTheme.typography.subtitle2.copy(colorResource(id = R.color.dark_blue)),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }

            Row {
                Box(
                    contentAlignment = Alignment.Center, modifier = Modifier
                        .size(50.dp, 50.dp)
                        .clip(RoundedCornerShape(125f))
                        .background(color = colorResource(id = R.color.light_gray))

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.hand),
                        contentDescription = null,
                        contentScale = ContentScale.Inside,
                        modifier = Modifier
                            .scale(1.5f)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Box(
                    contentAlignment = Alignment.Center, modifier = Modifier
                        .size(50.dp, 50.dp)
                        .clip(RoundedCornerShape(125f))
                        .background(color = colorResource(id = R.color.user_bg))

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.user8),
                        contentDescription = null,
                        contentScale = ContentScale.Inside,
                        modifier = Modifier
                            .scale(0.7f)
                    )
                }
            }
        }
    }
}

fun getAttendees() = listOf(
    Attendee(R.drawable.user4, R.color.sarah1_bg, "Sarah"),
    Attendee(R.drawable.user, R.color.daniel_bg, "Daniel"),
    Attendee(R.drawable.user1, R.color.sam_bg, "Samantha"),
    Attendee(R.drawable.user5, R.color.aishat_bg, "Aishat"),
    Attendee(R.drawable.user6, R.color.ruth_bg, "Ruth"),
    Attendee(R.drawable.user7, R.color.rachael_bg, "Rachael"),
    Attendee(R.drawable.user10, R.color.sarah2_bg, "Sarah"),
    Attendee(R.drawable.user11, R.color.mercy_bg, "Mercy"),
    Attendee(R.drawable.user12, R.color.sarah3_bg, "Sarah"),
    Attendee(R.drawable.user2, R.color.adeleke_bg, "Adeleke"),
    Attendee(R.drawable.user8, R.color.anna_bg, "Anna"),
    Attendee(R.drawable.user9, R.color.lauret_bg, "Lauret")
)

@ExperimentalFoundationApi
@Preview(showBackground = true, name = "Light Preview")
@Composable
fun RoomPreview() {
    ClubHouseCloneTheme {
        Room()
    }
}
