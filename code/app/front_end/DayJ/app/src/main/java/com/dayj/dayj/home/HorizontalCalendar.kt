package com.dayj.dayj.home


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dayj.dayj.ui.theme.Background
import com.dayj.dayj.ui.theme.Black2A
import com.dayj.dayj.ui.theme.Gray6F
import com.dayj.dayj.ui.theme.Green12
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalCalendar(
    modifier: Modifier = Modifier,
    currentDate: LocalDate = LocalDate.now(),
    config: HorizontalCalendarConfig = HorizontalCalendarConfig(),
    onSelectedDate: (LocalDate) -> Unit
) {
    val initialPage = (currentDate.year - config.yearRange.first) * 12 + currentDate.monthValue - 1
    var currentSelectedDate by remember { mutableStateOf(currentDate) }
    var currentMonth by remember { mutableStateOf(YearMonth.now()) }
    var currentPage by remember { mutableStateOf(initialPage) }
    val pagerState = rememberPagerState(initialPage = initialPage)

    LaunchedEffect(pagerState.currentPage) {
        val addMonth = (pagerState.currentPage - currentPage).toLong()
        currentMonth = currentMonth.plusMonths(addMonth)
        currentPage = pagerState.currentPage
    }

    LaunchedEffect(currentSelectedDate) {
        onSelectedDate(currentSelectedDate)
    }

    Column(modifier = modifier) {
        val headerText = currentMonth.dateFormat("yyyy년 M월")
        val pageCount = (config.yearRange.last - config.yearRange.first) * 12
        CalendarHeader(
            modifier = Modifier.padding(20.dp),
            text = headerText
        )
        HorizontalPager(
            pageCount = pageCount,
            state = pagerState
        ) { page ->
            val date = LocalDate.of(
                config.yearRange.first + page / 12,
                page % 12 + 1,
                1
            )
            if (page in pagerState.currentPage - 1..pagerState.currentPage + 1) { // 페이징 성능 개선을 위한 조건문
                CalendarMonthItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    currentDate = date,
                    selectedDate = currentSelectedDate,
                    onSelectedDate = { date ->
                        currentSelectedDate = date
                    }
                )
            }
        }
    }
}

@Composable
fun CalendarHeader(
    modifier: Modifier = Modifier,
    text: String,
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, top = 77.dp, end = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            modifier = Modifier
                .size(width = 200.dp, height = 40.dp),
            style = androidx.compose.ui.text.TextStyle(
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
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarMonthItem(
    modifier: Modifier = Modifier,
    currentDate: LocalDate,
    selectedDate: LocalDate,
    onSelectedDate: (LocalDate) -> Unit
) {
    val lastDay by remember { mutableStateOf(currentDate.lengthOfMonth()) }
    val firstDayOfWeek by remember { mutableStateOf(currentDate.dayOfWeek.value) }
    val days by remember { mutableStateOf(IntRange(1, lastDay).toList()) }

    Column(modifier = modifier) {
        DayOfWeek()
        LazyVerticalGrid(
            modifier = Modifier.height(260.dp),
            columns = GridCells.Fixed(7)
        ) {
            for (i in 1 until firstDayOfWeek) { // 처음 날짜가 시작하는 요일 전까지 빈 박스 생성
                item {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .padding(top = 10.dp)
                    )
                }
            }
            items(days) { day ->
                val date = currentDate.withDayOfMonth(day)
                val isSelected = remember(selectedDate) {
                    selectedDate.compareTo(date) == 0
                }
                CalendarDay(
                    modifier = Modifier.padding(top = 10.dp),
                    date = date,
                    isToday = date == LocalDate.now(),
                    isSelected = isSelected,
                    onSelectedDate = onSelectedDate
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarDay(
    modifier: Modifier = Modifier,
    date: LocalDate,
    isToday: Boolean,
    isSelected: Boolean,
    onSelectedDate: (LocalDate) -> Unit
) {
    val hasEvent = false //Todo
    Column(
        modifier = modifier
            .wrapContentSize()
            .size(30.dp)
            .clip(shape = CircleShape)
            .conditional(isToday) {
                background(Gray6F)
            }
            .conditional(isSelected) {
                background(Green12)
            }
            .conditional(!isToday && !isSelected) {
                background(Background)
            }
            .noRippleClickable { onSelectedDate(date) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        val textColor = if (isSelected) Color.White else Black2A
        Text(
            modifier = Modifier,
            text = date.dayOfMonth.toString(),
            style = androidx.compose.ui.text.TextStyle(
                color = textColor,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )
        if (hasEvent) {
            Box(
                modifier = Modifier
                    .size(4.dp)
                    .clip(shape = RoundedCornerShape(4.dp))
                    .conditional(isSelected) {
                        background(gray09)
                    }
                    .conditional(!isSelected) {
                        background(gray0)
                    }
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DayOfWeek(
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        DayOfWeek.values().forEach { dayOfWeek ->
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                text = dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.KOREAN),
                style = androidx.compose.ui.text.TextStyle(
                    color = Black2A,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

