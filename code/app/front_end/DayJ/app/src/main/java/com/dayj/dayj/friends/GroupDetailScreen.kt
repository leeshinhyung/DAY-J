package eu.tutorials.practiceapp.friends

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.tutorials.practiceapp.R
import eu.tutorials.practiceapp.component.FriendListItem
import eu.tutorials.practiceapp.ui.theme.Background
import eu.tutorials.practiceapp.ui.theme.Black3A
import eu.tutorials.practiceapp.ui.theme.GrayAFAF
import eu.tutorials.practiceapp.ui.theme.GrayDDD
import eu.tutorials.practiceapp.ui.theme.TextBlack
import eu.tutorials.practiceapp.ui.theme.TextGray
import kotlin.random.Random

val dummyFriends = listOf(
    UserEntity(userName = "오소영", userId = 123),
    UserEntity(userName = "문지영", userId = 3),
    UserEntity(userName = "김채형", userId = 43),
    UserEntity(userName = "이신형", userId = 2),
    UserEntity(userName = "변성훈", userId = 11223),
    UserEntity(userName = "신재호", userId = 134),
    UserEntity(userName = "박지훈", userId = 1654),
    UserEntity(userName = "최성원", userId = 57)
)

val dummyAchievements = dummyFriends.map {
    AchievementEntity(
        it,
        Random.nextDouble(0.0, 100.0)
    )
}.sortedByDescending {
        achievementEntity -> achievementEntity.achievementRate
}



@Composable
fun GroupDetailScreen() {
    val dummyGoals = remember {
        mutableStateOf(
            dummyFriends.map { friend ->
                (0..Random.nextInt(2, 5)).map {
                    GoalByFriendEntity(
                        userId = friend.userId,
                        goalTitle = LoremIpsum(Random.nextInt(2, 8)).values.joinToString(" "),
                        achieved = Random.nextBoolean()
                    )
                }
            }
        )
    }
    val selectedFriendIdx = remember { mutableStateOf(0) }


    Column(
       modifier = Modifier
           .fillMaxSize()
           .background(color = Background)
    ) {
        GroupToolbar()

        LazyColumn(
            modifier = Modifier,
            contentPadding = PaddingValues(top = 28.dp)
        ) {
            item {
                GroupJointGoalView()
                Spacer(modifier = Modifier.padding(top = 28.dp))
                AchievementListView(achievements = dummyAchievements)
                HorizontalDivider(height = 8, verticalPadding = 20)
                FriendListView(
                    selectedFriendIdx = selectedFriendIdx.value,
                    friends = dummyFriends,
                    onClickFriend = { idx ->
                        selectedFriendIdx.value = idx
                    }
                )
                HorizontalDivider(height = 1, verticalPadding = 20)
            }

            items(
                items = dummyGoals.value.find {
                    it.first().userId == dummyFriends.get(selectedFriendIdx.value).userId
                } ?: emptyList(),
                itemContent = {
                    GoalByFriendItem(it)
                }
            )
        }
    }
}

@Composable
fun ColumnScope.HorizontalDivider(height: Int, verticalPadding: Int = 0) {
    Spacer(modifier = Modifier.padding(top = verticalPadding.dp))
    Box(
        modifier = Modifier
            .height(height.dp)
            .fillMaxWidth()
            .background(color = GrayDDD)
    )
    Spacer(modifier = Modifier.padding(top = verticalPadding.dp))
}

@Composable
fun GroupToolbar() {
    Row(
        modifier = Modifier.padding(start = 16.dp, top = 24.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.left_arrow_black),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.padding(end = 2.dp))
        Text(
            text = "그룹명1",
            style = TextStyle(
                color = Black3A,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.ic_more),
            contentDescription = ""
        )
    }

}

@Composable
fun GroupJointGoalView() {
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .background(
                color = GrayDDD,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 9.dp, horizontal = 9.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "공동 목표",
                style = TextStyle(
                    color = Black3A,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
            )

            Spacer(modifier = Modifier.padding(end = 8.dp))

            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(14.dp)
                    .background(color = Black3A)
            )

            Spacer(modifier = Modifier.padding(end = 8.dp))

            Text(
                text = "하루에 물 8잔 이상 마시기",
                style = TextStyle(
                    color = Black3A,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Image(
                modifier = Modifier.clickable {  },
                painter = painterResource(id = R.drawable.bounding_box),
                contentDescription = ""
            )
        }
    }
}

@Composable
fun AchievementListView(achievements: List<AchievementEntity>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp),
    ) {
        Text(
            text = "달성률",
            style = TextStyle(
                color = TextGray,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
        )

        Spacer(modifier = Modifier.padding(top = 15.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(
                items = achievements,
                itemContent = {
                    AchievementByMember(achievements.indexOf(it) + 1, it)
                }
            )
        }
    }
}

@Composable
fun AchievementByMember(rank: Int, achievement: AchievementEntity) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.account_circle),
                contentDescription = ""
            )
            Box(
                modifier = Modifier
                    .width(18.dp)
                    .height(18.dp)
                    .align(Alignment.BottomEnd)
                    .background(
                        color = if (rank <= 3) Black3A else TextGray,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = rank.toString(),
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp
                    )
                )
            }
        }

        Spacer(modifier = Modifier.padding(top = 6.dp))

        Text(
            text = achievement.user.userName,
            style = TextStyle(
                color = TextBlack,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
        )

        Spacer(modifier = Modifier.padding(top = 3.dp))

        Text(
            text = "${achievement.achievementRate.toInt()}%",
            style = TextStyle(
                color = TextBlack,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        )
    }
}

@Composable
fun FriendListView(
    selectedFriendIdx:Int,
    friends: List<UserEntity>,
    onClickFriend: ((Int) -> Unit)
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "친구 목록",
                style = TextStyle(
                    color = TextGray,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Image(
                modifier = Modifier.clickable {  },
                painter = painterResource(id = R.drawable.bounding_box),
                contentDescription = ""
            )
        }

        Spacer(modifier = Modifier.padding(top = 15.dp))

        LazyRow(
            modifier = Modifier.padding(start = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(
                items = friends,
                itemContent = {
                    FriendListItem(
                        selected = selectedFriendIdx == friends.indexOf(it),
                        user = it,
                        onClick = {
                            onClickFriend(friends.indexOf(it))
                        }
                    )
                }
            )
        }
    }
}

@Composable
fun GoalByFriendItem(goalEntity: GoalByFriendEntity) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 12.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Column(
            modifier = Modifier.padding(
                vertical = 19.dp,
                horizontal = 16.dp
            )
        ) {
            Text(
                text = goalEntity.goalTitle,
                style = TextStyle(
                    color = Black3A,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
            )

            Spacer(
                modifier = Modifier
                    .padding(top = if(goalEntity.achieved) 4.dp else 8.dp)
            )

            Row {
                if(goalEntity.achieved) {
                    Image(
                        modifier = Modifier.padding(end = 8.dp),
                        painter = painterResource(id = R.drawable.ic_achieved_badge),
                        contentDescription = ""
                    )
                }

                Text(
                    text = if (goalEntity.achieved) "달성" else "미달성",
                    style = TextStyle(
                        color = GrayAFAF,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp
                    )
                )
            }
        }
    }
}