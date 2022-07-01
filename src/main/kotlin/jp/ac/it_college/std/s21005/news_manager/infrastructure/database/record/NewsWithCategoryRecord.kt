package jp.ac.it_college.std.s21005.news_manager.infrastructure.database.record

import java.sql.Timestamp
import java.time.LocalDateTime

data class NewsWithCategoryRecord(
    val id: Long? = null,
    val title: String? = null,
    val categoryId: Long? = null,
    val publishAt: LocalDateTime? = null,
    val createAt: LocalDateTime? = null,
    val userId: Long? = null,
    val body: String? = null,
    val name: String? = null
)
