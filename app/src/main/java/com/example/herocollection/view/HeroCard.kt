package com.example.herocollection.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.herocollection.R
import com.example.herocollection.model.HeroData
import com.example.herocollection.viewmodel.Logos


@Composable
fun HeroCard(item : HeroData, onClick: () -> Unit) {



    Box(modifier = Modifier.fillMaxSize()
        .clip(RoundedCornerShape(8.dp))
        .clickable { onClick() }

    ) {

    Row(modifier = Modifier.padding(top = 10.dp).padding(horizontal = 20.dp).clip(RoundedCornerShape(10.dp)).fillMaxWidth().background(
        colorResource(R.color.cardColor))) {
        AsyncImage(
            modifier = Modifier.clip(shape = CircleShape).size(128.dp).padding(vertical = 5.dp),
            model = item.photo,
            contentDescription = "image",
        )

        Column {
            Text(
                modifier = Modifier.padding(top = 40.dp).wrapContentWidth(),
                text = "${item.heroName}" ,
                textAlign = TextAlign.Start,
                style = TextStyle(fontStyle = FontStyle.Italic,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,)
            )
            Text(
                modifier = Modifier.wrapContentWidth(),
                text = "${item.realName}",
                textAlign = TextAlign.Start,
                style = TextStyle(fontStyle = FontStyle.Italic,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,)
            )

        }

    }
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                modifier = Modifier
                    .size(70.dp)
                    .align(Alignment.CenterEnd)
                    .padding(end = 20.dp)
                    .padding(top = 45.dp),
                model = item.studioLogo,
                contentDescription = ""
            )
        }
}

}