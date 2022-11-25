package com.example.lazylistviewexample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazylistviewexample.models.User
import com.example.lazylistviewexample.ui.theme.LazyListViewExampleTheme
import com.example.lazylistviewexample.utils.DataProvider

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyListViewExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LazyColumn{
                        items(DataProvider.userList){ user ->
                            ListItem(user = user,
                            onItemClick = { userName ->
                                Toast.makeText(this@MainActivity,
                                "You have clicked on $userName",
                                Toast.LENGTH_SHORT).show()
                            })
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ListItem(user: User,
             onItemClick: (userName: String) -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 10.dp, vertical = 5.dp)
    ){
        Column(modifier = Modifier.fillMaxSize()
            .background(color = Color.LightGray)
            .padding( all = 10.dp)
            .clickable {
                onItemClick(user.name)
            }
        ){
            Text(fontSize = 14.sp, text = "Name : ${user.name}")
            Spacer(modifier = Modifier.height(5.dp))
            Text(fontSize = 11.sp,text = "Age ${user.age}!")
        }
    }
}
