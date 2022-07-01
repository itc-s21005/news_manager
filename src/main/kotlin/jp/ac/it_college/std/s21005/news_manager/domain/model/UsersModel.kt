package jp.ac.it_college.std.s21005.news_manager.domain.model

import jp.ac.it_college.std.s21005.news_manager.domain.enum.RoleType

data class UsersModel (
    val id: Long,
    val username: String,
    val password: String,
    val viewName: String,
    val roleType: RoleType
    )