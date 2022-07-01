package jp.ac.it_college.std.s21005.news_manager.domain.repository

import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.record.Users as UsersRecord

interface UserRepository {
    fun find(email: String): UsersRecord?
}