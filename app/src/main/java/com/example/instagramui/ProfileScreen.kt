package com.example.instagramui

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize(),
        ){
        TopBar()
        Spacer(modifier = Modifier.height(16.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(16.dp))
        DescriptionSection()
    }
}

@Composable
fun TopBar(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround) {
        
        Icon(painter = painterResource(id = R.drawable.ic_action_back),
            contentDescription = "Back button" )

        Text(text = stringResource(id = R.string.username ),
            fontWeight = FontWeight.Bold
        )

        Icon(painter = painterResource(id = R.drawable.ic_action_notification),
            contentDescription = "Notification",)

        Icon(painter = painterResource(id = R.drawable.ic_action_more),
            contentDescription = "Menu")
    }
}

@Composable
fun ProfileSection(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.
        padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        RoundImage(
            image = painterResource(id = R.drawable.passportsize_photo),
            modifier = Modifier
                .size(100.dp)
                .weight(3f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
            ,modifier = Modifier.weight(7f)) {
            StateSection(number = "100", info = "Posts")
            StateSection(number = "100k", info = "Followers")
            StateSection(number = "72", info = "Following")
        }
    }
}

@Composable
fun DescriptionSection(){
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = stringResource(id = R.string.channel_name),
            fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Column {
            Text(text = stringResource(id = R.string.description),
                fontSize = 15.sp)
        }
        LinkSection()
        FollowingSection()
    }
}

@Composable
fun LinkSection() {
    val uri = "https://www.youtube.com/channel/UCqF0PCpBMC3-kcnaQvG1hqg"
    val hyperlinkText = uri

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline, color = Color.Blue)) {
            append(hyperlinkText)
            addStringAnnotation(
                tag = "URL",
                annotation = uri,
                start = length - hyperlinkText.length,
                end = length
            )
        }
    }
    val uriHandler = LocalUriHandler.current
    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(tag = "URL", start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    uriHandler.openUri(annotation.item)
                }
        }
    )
}

@Composable
fun FollowingSection(){
    val annotatedString = buildAnnotatedString {

        append("Followed by ")
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
            append("huned, fakhruddin")
        }
        append(" and")
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
            append(" 26 others")
        }
    }

    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
        ,modifier = Modifier.weight(7f)) {
        Text(text = annotatedString, modifier = Modifier)
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
){
    Image(painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = CircleShape
            )
            .clip(CircleShape)
    )
}

@Composable
fun StateSection(number: String,
                 info: String,
                 modifier: Modifier = Modifier){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 4.dp)
        ) {
        Text(text = number,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = info)
    }
}


@Preview
@Composable
fun ProfileScreenPreview1(){
    ProfileScreen()
}
