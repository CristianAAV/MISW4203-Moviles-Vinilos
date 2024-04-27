package com.example.mis4203movilvinilosjpc.ActivityPrincipal.Albums.UI.View.AlbumsContent

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mis4203movilvinilosjpc.ActivityPrincipal.Albums.Data.Modelo.DataItemAlbums

//card para cada album
@Composable
fun AlbumCard(
    album: DataItemAlbums,
    onDetailsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    //creamos el elemento card
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Row( //creamos el contenido de la card en forma horizontal
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically //alineamos el contenido verticalmente
        ) {
            //contenido de la card
            AlbumInformation(
                album = album,
                onDetailsClick = onDetailsClick,
                modifier = Modifier.weight(1f)
            )
            //
            AlbumCover(
                coverUrl = album.cover,
                modifier = Modifier
                    .weight(0.5f)
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.Blue, CircleShape)
                    .padding(end = 4.dp)
            )
        }
    }
    Spacer(modifier = Modifier.padding(2.dp))
}
//informacion del album
@Composable
fun AlbumInformation(
    album: DataItemAlbums,
    onDetailsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    //organiza verticalmente
    Column(
        modifier = modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Nombre del album
        Text(
            text = album.name,
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        //Nombre del artista o banda
        album.performers.forEach { performer ->
            Text(
                text = performer.name,
                textAlign = TextAlign.Center,
                fontSize = 15.sp
            )
        }
        //Boton para ver el detalle
        Button(onClick = onDetailsClick) {
            Text(text = "Detalles")
        }
    }
}

//imagen del album
@Composable
fun AlbumCover(
    coverUrl: String,
    modifier: Modifier = Modifier
) {
    //imagen con Coil
    AsyncImage(
        model = coverUrl,
        contentDescription = "Portada del álbum",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .border(1.dp, Color.Blue, CircleShape)
            .padding(end = 4.dp)
    )
}