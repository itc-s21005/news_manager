package jp.ac.it_college.std.s21005.news_manager.infrastructure.database.mapper

import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.mapper.CategoryDynamicSqlSupport.category
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.mapper.CategoryDynamicSqlSupport.name
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.body
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.categoryId
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.createAt
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.id
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.news
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.publishAt
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.title
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.userId
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.record.NewsWithCategoryRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.select

@Mapper
interface NewsWithCategoryMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @ResultMap("NewsWithCategoryRecordResult")
    fun selectOne(selectStatement: SelectStatementProvider): NewsWithCategoryRecord?

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "NewsWithCategoryRecordResult", value = [
            Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            Result(column = "category_id", property = "categoryId", jdbcType = JdbcType.BIGINT),
            Result(column = "publish_at", property = "publishAt", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "create_at", property = "createAt", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            Result(column = "body", property = "body", jdbcType = JdbcType.LONGVARCHAR),
            Result(column = "name", property = "name", jdbcType = JdbcType.LONGVARCHAR),
        ]
    )
    fun selectMany(selectStatement: SelectStatementProvider): List<NewsWithCategoryRecord>
}
    private val columnList = listOf(id, title, categoryId, publishAt, createAt, userId, body, name)

    fun NewsWithCategoryMapper.select(completer: SelectCompleter): List<NewsWithCategoryRecord> =
        select(columnList) {
            from(news, "n")
            leftJoin(category){
                on(news.id) equalTo category.id
            }
            completer()
        }.run(this::selectMany)

fun NewsWithCategoryMapper.selectByPrimaryKey(id_: Long, completer: SelectCompleter): NewsWithCategoryRecord? =
    select(columnList){
        from(news, "n")
        leftJoin(category, "c"){
            on(news.id) equalTo category.id
        }
        where {
            id isEqualTo id_
        }
        completer()
    }.run (this::selectOne)
