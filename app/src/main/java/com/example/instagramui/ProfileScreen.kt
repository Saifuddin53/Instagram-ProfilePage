package com.example.instagramui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize(),
        ){
        TopBar()
        Spacer(modifier = Modifier.height(16.dp))
        ProfileSection()
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
            contentDescription = "Notification")

        Icon(painter = painterResource(id = R.drawable.ic_action_more),
            contentDescription = "Menu")
    }
}

@Composable
fun ProfileSection(){
    
}


@Preview
@Composable
fun ProfileScreenPreview1(){
    ProfileScreen()
}
