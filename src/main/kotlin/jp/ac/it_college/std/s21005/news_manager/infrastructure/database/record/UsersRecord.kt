/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.ac.it_college.std.s21005.news_manager.infrastructure.database.record

import jp.ac.it_college.std.s21005.news_manager.domain.enum.RoleType


data class UsersRecord(
    var id: Long? = null,
    var username: String? = null,
    var password: String? = null,
    var viewName: String? = null,
    var roleType: RoleType? = null
)