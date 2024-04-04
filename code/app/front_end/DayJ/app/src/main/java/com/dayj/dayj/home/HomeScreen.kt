package com.dayj.dayj.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dayj.dayj.ui.theme.Background
import com.dayj.dayj.ui.theme.Black2A
import java.time.format.DateTimeFormatter

@Composable
fun HomeScreen(){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            modifier = Modifier.padding(20.dp),
            text = "DayJ",
            style = TextStyle(
                color = Black2A,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        )
        }
        //캘린더 및 일정
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            item(){
                var selectDate by remember { mutableStateOf("") } //test용
                HorizontalCalendar<Any>(
                    onSelectedDate = { date ->
                        selectDate = date.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"))
                    }
                )
            }
            val todoList = listOf<Int>(1, 2, 3, 4, 5) // TODO 테스트 용
            if (todoList.isNotEmpty()) {
                itemsIndexed(items = todoList) { index, data ->
                    HomeTodoListItem(modifier = Modifier.fillMaxWidth())
                }
                item {
                    HomeTodoListAddView(modifier = Modifier.padding(top = 20.dp))
                    Spacer(modifier = Modifier.height(75.dp))
                }
            } else {
                item {
                    HomeTodoListEmptyView(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 100.dp)
                    )
                }
        }
    }
}

@Composable
fun MonthCalendar(){
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, top = 77.dp, end = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            "2024년 8월",
            modifier = Modifier
                .size(width = 200.dp, height = 40.dp),
            style = TextStyle(
                color = Black2A,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
        Row() {
            Button(modifier = Modifier.size(width = 24.dp, height = 34.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Background,
                    contentColor = Black2A,
                    disabledContainerColor = Color.White,
                    disabledContentColor = Color.White
                ),
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    tint = Black2A,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(0.dp)
                        .fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Button(modifier = Modifier.size(width = 24.dp, height = 34.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Background,
                    contentColor = Black2A,
                    disabledContainerColor = Color.White,
                    disabledContentColor = Color.White
                ),
                onClick = { /* 수정 */ }
            ) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    tint = Black2A,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(0.dp)
                        .fillMaxSize()
                )
            }
        }
    
}