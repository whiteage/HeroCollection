package com.example.herocollection.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavController
import com.example.herocollection.model.HeroData
import com.example.herocollection.viewmodel.MainVM
import com.example.herocollection.R

@Composable

fun MailScreen(viewModel: MainVM = viewModel(), navController: NavController) {

    val heroes by viewModel.superheroes.observeAsState(emptyList())

    val expanded = remember { mutableStateOf(false) }
    val chosenVar = remember { mutableStateOf("All")}

    LaunchedEffect(Unit) {
        viewModel.loadHeroes()
    }


    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxHeight()) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .padding(top = 30.dp)
                .padding(start = 5.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .size(64.dp)
                            .clip(shape = CircleShape),
                        contentScale = ContentScale.Crop,
                    )
                    Text(modifier = Modifier.padding(horizontal = 40.dp), text = "Палагутин Андрей Дмитриевич")
                IconButton(
                        onClick = {},
                        modifier = Modifier,
                    ) {
                    Icon(Icons.Default.MoreVert, contentDescription = "кнопка заглушка")
                    }

            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                IconButton(
                    onClick = { expanded.value = true },
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(120.dp, 40.dp)
                        .background(colorResource(R.color.cardColor))
                        .clip(CircleShape)
                ) {
                    Text(text = "${chosenVar.value}")
                }
                DropdownMenu(
                    expanded = expanded.value,
                    onDismissRequest = { expanded.value = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("All") },

                        onClick = {
                            chosenVar.value  = "All"
                            expanded.value = false
                            viewModel.loadHeroes()

                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Marvel") },

                        onClick = {
                            chosenVar.value  = "Marvel Comics"
                            expanded.value = false

                            viewModel.chosenStudio(chosenVar.value)
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("DC") },
                        onClick = {
                            chosenVar.value  = "DC Comics"
                            expanded.value = false
                            viewModel.chosenStudio(chosenVar.value)
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Others") },
                        onClick = {
                            chosenVar.value  = "Others"
                            expanded.value = false
                            viewModel.chosenOthersStudios()
                        }
                    )

                }
            }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
            ) {
                if(heroes.size > 1){
                    val listOfCards = heroes.map {
                        HeroData(
                            it.imageUrl ?: "Unknown",
                            it.nickname ?: "Unknown",
                            it.realName ?: "Unknown",
                            it.studio ?: "Unknown",
                            it.id ?: "Unknown",
                            it.isFavorite ?: false,
                            it.studioLogo ?: "Unknown"
                        )
                    }

                    LazyColumn(modifier = Modifier.background(Color.White)) {
                        itemsIndexed(listOfCards) { _, item ->
                            HeroCard(item = item, onClick = { navController.navigate("hero_details/${item.id}")  })
                        }
                    }

                }
                else {
                    Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        Text(
                            text = ("Loading.....")
                        )
                    }

                }



            }
        }

    }



}