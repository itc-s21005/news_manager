package jp.ac.it_college.std.s21005.news_manager.domain.model

import java.sql.Timestamp
import java.time.LocalDateTime

data class NewsModel(
    val id: Long,
    val title: String,
    val categoryId: Long,
    val publishAt: LocalDateTime,
    val createAt: LocalDateTime,
    val userId: Long,
    val body: String
    )