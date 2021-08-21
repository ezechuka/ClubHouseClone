package com.javalon.clubhouseclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.javalon.clubhouseclone.R
import com.javalon.clubhouseclone.model.ChipModel

@Composable
fun ChipSection() {
    Row(
        Modifier
            .horizontalScroll(state = rememberScrollState())
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        getChipList().forEach {
            Chip(chipModel = it)
        }
    }
}

@Composable
fun Chip(chipModel: ChipModel) {
    Button(
        onClick = { /* TO-DO */ },
        modifier = Modifier
            .padding(start = 0.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
            .clip(RoundedCornerShape(22.dp)),
        colors = if (chipModel.isSelected) ButtonDefaults.buttonColors(colorResource(id = R.color.medium_blue))
        else ButtonDefaults.buttonColors(MaterialTheme.colors.onSurface),
    ) {
        Image(
            painter = painterResource(id = chipModel.icon),
            contentDescription = chipModel.title,
            modifier = Modifier.align(Alignment.CenterVertically)
        )

        Text(
            text = chipModel.title, color = Color.Black,
            style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.W500),
            modifier = Modifier.padding(start = 8.dp).align(Alignment.CenterVertically)
        )
    }
}

fun getChipList(): List<ChipModel> {
    return listOf(
        ChipModel("Design", R.drawable.palette, true),
        ChipModel("Gaming", R.drawable.joystick, false),
        ChipModel("Sports", R.drawable.sports, false),
        ChipModel("Cinema", R.drawable.cinema, false),
        ChipModel("Education", R.drawable.education, false)
    )
}