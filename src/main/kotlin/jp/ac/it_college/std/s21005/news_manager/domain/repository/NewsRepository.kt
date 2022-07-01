package jp.ac.it_college.std.s21005.news_manager.domain.repository

import jp.ac.it_college.std.s21005.news_manager.domain.model.NewsWithCategoryModel
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.record.News as NewsRecord

interface NewsRepository {
    fun fundAllWithCategory(): List<NewsWithCategoryModel>

    fun findWithCategory(id: Long): NewsWithCategoryModel?

    fun register(news: NewsRecord)
}