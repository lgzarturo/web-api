package com.alg.boot.webapi.apps.content.v1

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["http://localhost:3000"])
@RequestMapping("/api/v1/comments")
class CommentController {
}