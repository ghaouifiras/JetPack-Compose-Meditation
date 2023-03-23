package com.firas.firstjetpackcomposeproject.ui

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firas.firstjetpackcomposeproject.R
import com.firas.firstjetpackcomposeproject.model.BottomMenuItem
import com.firas.firstjetpackcomposeproject.model.Featured
import com.firas.firstjetpackcomposeproject.ui.theme.*

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DeepBlue)
    ) {
        Column {
            GreetingSection("Ghaoui")
            SecondSection(list = listOf("item 1", "item 2", "item 3", "item 4"))
            DailyThoughSection()
            FeaturesSection(
                list = listOf(
                    Featured(
                        title = "Sleep meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Featured(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Featured(
                        title = "Night island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Featured(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    )

                )
            )

        }
        MyBottomMenu(
            items = listOf(
                BottomMenuItem("Home", R.drawable.ic_home),
                BottomMenuItem("Mediate", R.drawable.ic_bubble),
                BottomMenuItem("Sleep", R.drawable.ic_moon),
                BottomMenuItem("Music", R.drawable.ic_music),
                BottomMenuItem("Profile", R.drawable.ic_profile),

                ),
            modifier = Modifier.align(alignment = Alignment.BottomCenter)
        )
    }
}

@Composable
fun GreetingSection(name: String = "") {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Good Moring, $name",
                style = MaterialTheme.typography.h1
            )

            Text(
                text = "we wish you have a good day !",
                style = MaterialTheme.typography.body1
            )
        }
        Icon(
            painter = painterResource(id = com.firas.firstjetpackcomposeproject.R.drawable.ic_search),
            contentDescription = "search",
            tint = TextWhite,
            modifier = Modifier.size(24.dp)

        )
    }

}

@Composable
fun SecondSection(
    list: List<String>
) {
    var selectedItemIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(list.size) {
            Box(

                modifier = Modifier
                    .padding(top = 15.dp, bottom = 15.dp)
                    .padding(15.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .clickable {
                        selectedItemIndex = it
                    }
                    .background(
                        if (selectedItemIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .size(120.dp, 30.dp),
                contentAlignment = Alignment.Center
            )
            {
                Text(text = list[it], color = Color.White)
            }

        }
    }


}

@Composable
fun DailyThoughSection() {
    Row(
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(LightRed)
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 20.dp),

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Daily Thoughts",
                style = MaterialTheme.typography.h1
            )
            Text(
                text = "Mediation * 3.10 min",
                style = MaterialTheme.typography.h2
            )

        }

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(ButtonBlue)
                .size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play), contentDescription = "play",
                modifier = Modifier.size(16.dp),
                tint = Color.White
            )
        }


    }

}

@Composable
fun FeaturesSection(list: List<Featured>) {
    Column {
        Text(
            text = "Featured",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(start = 15.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxHeight()

        ) {
            items(list.size) {
                Column(
                    modifier = Modifier
                        .padding(15.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(list[it].darkColor)
                        .padding(15.dp)
                        .size(120.dp)

                ) {
                    Text(
                        text = list[it].title,
                        style = MaterialTheme.typography.h1,
                    )

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Icon(
                            painter = painterResource(id = list[it].iconId),
                            contentDescription = "icon",
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)

                        )

                        Text(text = "Start",
                            color = TextWhite,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .clickable {

                                }
                                .background(ButtonBlue)
                                .padding(6.dp)

                        )

                    }


                }

            }

        }

    }

}

@Composable
fun BottomMenuItemCompose(
    botttomMenuItem: BottomMenuItem,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit

) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable { onItemClick ()}
            .background(
                if (isSelected)
                    activeHighlightColor
                else
                    Color.Transparent
            )
            .padding(8.dp)
           ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            painter = painterResource(id = botttomMenuItem.iconId),
            contentDescription = "itemMenu",
            tint = Color.White,
            modifier = Modifier
                .size(22.dp)
        )
        Text(
            text = botttomMenuItem.title,
            fontSize = (12.sp),
            color = if (isSelected) activeTextColor
            else
                inactiveTextColor


        )


    }

}

@Composable
fun MyBottomMenu(
    items: List<BottomMenuItem>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }

    Row(
        modifier = modifier
            .padding(15.dp)
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically


    ) {

        items.forEachIndexed { index, item ->
            Log.d("testIndex0 " , index.toString())
            Log.d("testIndex1 " , selectedItemIndex.toString())

            BottomMenuItemCompose(
                botttomMenuItem = item,
                isSelected =  index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
            ) {
                selectedItemIndex = index
            }

        }
    }


}




