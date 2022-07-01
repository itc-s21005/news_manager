package jp.ac.it_college.std.s21005.news_manager.infrastructure.database.repository

import jp.ac.it_college.std.s21005.news_manager.domain.repository.NewsRepository
import jp.ac.it_college.std.s21005.news_manager.domain.model.CategoryModel
import jp.ac.it_college.std.s21005.news_manager.domain.model.NewsModel
import jp.ac.it_college.std.s21005.news_manager.domain.model.NewsWithCategoryModel
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.mapper.*
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.record.News as NewsRecord
import org.springframework.stereotype.Repository
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.record.NewsWithCategoryRecord


@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class NewsRepositoryImpl (
    private val newsWithCategoryMapper: NewsWithCategoryMapper,
    private val newsMapper: NewsMapper
) : NewsRepository {
    override fun fundAllWithCategory(): List<NewsWithCategoryModel> {
        return newsWithCategoryMapper.select {  }.map { toModel(it) }
    }

    override fun findWithCategory(id: Long): NewsWithCategoryModel? {
        return newsWithCategoryMapper.selectByPrimaryKey(id){
        }?.let { toModel(it) }
    }

    override fun register(news: NewsRecord) {
        newsMapper.insert(toRecord(news))
    }
    private fun toRecord(model: NewsRecord): NewsRecord{
        return NewsRecord(model.id, model.title,model.categoryId,model.publishAt,model.createAt,model.userId,model.body)
    }

    private fun toModel(record: NewsWithCategoryRecord): NewsWithCategoryModel {
        val news = NewsModel(
            record.id!!,
            record.title!!,
            record.categoryId!!,
            record.publishAt!!,
            record.createAt!!,
            record.userId!!,
            record.body!!,
        )
    val category = record.userId?.let {
        CategoryModel(
            record.id!!,
            record.name!!
        )
    }
        return NewsWithCategoryModel(news, category)
    }
}