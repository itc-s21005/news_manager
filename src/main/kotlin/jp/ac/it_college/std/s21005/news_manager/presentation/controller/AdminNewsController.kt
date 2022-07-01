package jp.ac.it_college.std.s21005.news_manager.presentation.controller

import jp.ac.it_college.std.s21005.news_manager.application.service.AdminNewsService
import jp.ac.it_college.std.s21005.news_manager.infrastructure.database.record.News as NewsRecord
import jp.ac.it_college.std.s21005.news_manager.presentation.form.RegisterNewsRequest
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("admin/news")
@CrossOrigin
class AdminNewsController (
    private val adminNewsService: AdminNewsService
) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterNewsRequest) {
        adminNewsService.register(
            NewsRecord(
                0,
                request.title,
                request.categoryId,
                request.publishAt,
                LocalDateTime.now(),
                1,
                request.body
            )
        )
    }
}