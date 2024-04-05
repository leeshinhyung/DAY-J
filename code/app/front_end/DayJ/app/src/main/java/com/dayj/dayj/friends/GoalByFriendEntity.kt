package eu.tutorials.practiceapp.friends

data class GoalByFriendEntity(
    val userId: Int,
    val goalTitle: String,
    val achieved: Boolean
)