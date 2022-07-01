package jp.ac.it_college.std.s21005.news_manager.presentation.controller

import jp.ac.it_college.std.s21005.news_manager.application.service.NewsService
import jp.ac.it_college.std.s21005.news_manager.presentation.form.GetNewsDetailResponse
import jp.ac.it_college.std.s21005.news_manager.presentation.form.GetNewsListResponse
import jp.ac.it_college.std.s21005.news_manager.presentation.form.NewsInfo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("news")
class NewsController (
    private val newsService: NewsService
) {
    @GetMapping("/list")
    fun getList(): GetNewsListResponse{
        val newsList = newsService.getList().map {
            NewsInfo(it)
        }
        return GetNewsListResponse(newsList)
    }
    @GetMapping("/detal/{news_id}")
    fun getDetail(@PathVariable("book_id") newsId: Long): GetNewsDetailResponse{
        val news = newsService.getDetail(newsId)
        return GetNewsDetailResponse(news)
    }
}