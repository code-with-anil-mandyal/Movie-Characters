package com.moviecharacters.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.moviecharacters.domain.model.Characters

@Composable
fun CharacterDetailsScreen(
    onBackClick: () -> Unit,
    characters: Characters
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
            Header(characters = characters, onBackClick = {
                onBackClick()
            })
        CharacterDetails(character = characters)
    }
}

@Composable
fun CharacterDetails(
    modifier: Modifier = Modifier,
    character: Characters
){

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = character.image,
                    contentDescription = "",
                    modifier = modifier.padding(16.dp)
                        .fillMaxWidth()
                        .height(400.dp)
                        .clip(RectangleShape),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = character.actor?:"",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
                Spacer(modifier = modifier.padding(5.dp))
                Text(
                    text = "(${character.name?:""})"
                )
                Spacer(modifier = modifier.padding(5.dp))
                Text(
                    text = character.dateOfBirth?:"",
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
                Spacer(modifier = modifier.padding(5.dp))
            }
        }

    }


}

@Composable
fun Header(
    modifier: Modifier = Modifier,
    characters : Characters,
    onBackClick: () -> Unit
    ) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        IconButton(onClick = {
            onBackClick()
        }, modifier = Modifier.align(Alignment.CenterStart)) {
            Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack,
                contentDescription = "back")
        }

        Text(
            text = characters.name?:"",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.W700,
                color = Color.Black
            ),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}