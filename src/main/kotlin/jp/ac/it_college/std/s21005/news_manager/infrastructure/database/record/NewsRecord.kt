/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.ac.it_college.std.s21005.news_manager.infrastructure.database.record

import java.time.LocalDateTime

data class NewsRecord(
    var id: Long? = null,
    var title: String? = null,
    var categoryId: Long? = null,
    var publishAt: LocalDateTime? = null,
    var createAt: LocalDateTime? = null,
    var userId: Long? = null,
    var body: String? = null
)