package jp.ac.it_college.std.s21005.news_manager.application.service

import jp.ac.it_college.std.s21005.news_manager.domain.model.NewsModel
import jp.ac.it_college.std.s21005.news_manager.domain.repository.NewsRepository
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.record.News as NewsRecord
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminNewsService (
    private val newsRepository: NewsRepository
    ){
    @Transactional
    open fun register(news: NewsRecord){
        newsRepository.findWithCategory(news.id!!)?.let { throw IllegalArgumentException("既に存在するニュースID: ${news.id}")}
        newsRepository.register(news)
    }
}