package jp.ac.it_college.std.s21005.news_manager.infrastructure.database.repository

import jp.ac.it_college.std.s21005.news_manager.domain.repository.UserRepository
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.mapper.UsersDynamicSqlSupport
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.mapper.UsersMapper
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.mapper.selectOne
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.record.Users as UsersRecord
import org.springframework.stereotype.Repository


@Repository
class UserRepositoryImpl(
    private val mapper: UsersMapper
) : UserRepository {

    override fun find(email: String): UsersRecord? {
        val record = mapper.selectOne {
            where {
                UsersDynamicSqlSupport.users.username isEqualTo email
            }
        }
        return record?.let { toModel(it) }
    }


    private fun toModel(recode: UsersRecord): UsersRecord{
        return UsersRecord(
            recode.id!!,
            recode.username!!,
            recode.password!!,
            recode.viewName!!,
            recode.roleType!!
        )
    }

}