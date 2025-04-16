package com.example.herocollection.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.herocollection.viewmodel.MainVM
import com.example.herocollection.R


@Composable
fun HeroDetail(heroId: String, viewModel: MainVM, navController: NavController) {

    LaunchedEffect(Unit) {
        viewModel.getHeroByID(heroId)
    }

    val hero by viewModel.superhero.observeAsState()
    val appearanceDto by viewModel.superheroAppearanceDto.observeAsState()
    val likebuttonState by viewModel.likeB.observeAsState()
    hero?.let {


    Column(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(R.color.backColor))) {
        Box(){

        AsyncImage(
            modifier = Modifier
                .padding(top = 5.dp)
                .padding(20.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(15.dp))
            ,
            model = it.imageUrl,
            contentDescription = "image",

        )
            IconButton(
                onClick = {
                    navController.navigate("allHero")
                },
                modifier = Modifier.padding(top = 35.dp).padding(start = 20.dp)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "backB")
            }
            IconButton(
                onClick = {
                    viewModel.changeFavorite(it)

                },
                modifier = Modifier.align(Alignment.BottomEnd).padding(bottom = 20.dp).padding(end = 20.dp)
            ) {
                Icon(
                    imageVector = if (likebuttonState == true) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "кнопка вайк",
                    tint = if (likebuttonState== true) Color.Red else Color.Gray
                )
            }

        }
        Box(modifier = Modifier.padding(20.dp).fillMaxSize().clip(shape = RoundedCornerShape(15.dp)).background(colorResource(
            R.color.cardColor
        ))){
            Column(modifier = Modifier) {
                Row(modifier = Modifier.padding(top = 10.dp).padding(start = 15.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,)
                {
                    Text(
                        text = "${it.nickname}" ,
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontStyle = FontStyle.Italic,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,)
                    )

                }
                LazyColumn(
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    item {
                        Text(
                            text = "${if (it.realName.isNullOrEmpty()) it.nickname else it.realName}",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontStyle = FontStyle.Italic,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }

                    item {
                        Text(
                            text = "Race: ${if (appearanceDto?.race == "null" || appearanceDto?.race == "-") "[ДАННЫЕ УДАЛЕНЫ]" else appearanceDto?.race}",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontStyle = FontStyle.Italic,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }

                    item {
                        Text(
                            text = "Gender: ${if (appearanceDto?.gender == "null" || appearanceDto?.gender == "-") "[ДАННЫЕ УДАЛЕНЫ]" else appearanceDto?.gender}",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontStyle = FontStyle.Italic,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }

                    item {
                        Text(
                            text = "Eye color: ${if (appearanceDto?.eyeColor == "null" || appearanceDto?.eyeColor == "-") "[ДАННЫЕ УДАЛЕНЫ]" else appearanceDto?.eyeColor}",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontStyle = FontStyle.Italic,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }

                    item {
                        Text(
                            text = "Hair color: ${if (appearanceDto?.hairColor == "null" || appearanceDto?.hairColor == "-") "[ДАННЫЕ УДАЛЕНЫ]" else appearanceDto?.hairColor}",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontStyle = FontStyle.Italic,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }

                    item {
                        Text(
                            text = "Height: ${if (appearanceDto?.height?.get(1) == "0 cm") "[ДАННЫЕ УДАЛЕНЫ]" else appearanceDto?.height?.get(1)}",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontStyle = FontStyle.Italic,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }

                    item {
                        Text(
                            text = "Weight: ${if (appearanceDto?.weight?.get(1) == "0 kg") "[ДАННЫЕ УДАЛЕНЫ]" else appearanceDto?.weight?.get(1)}",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontStyle = FontStyle.Italic,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }


            }
        }



    }
    }
}