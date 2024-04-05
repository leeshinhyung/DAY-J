package eu.tutorials.practiceapp.friends

data class AchievementEntity(
    val user: UserEntity,
    val achievementRate: Double = 0.0
)