package com.alg.boot.webapi.apps.security.controllers

import com.alg.boot.webapi.apps.security.users.dto.UserLoginRequest
import com.alg.boot.webapi.apps.security.users.service.UserService
import com.alg.boot.webapi.handlers.responses.GeneralResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/auth")
class AuthController(private val userService: UserService) {
    @PostMapping("/login")
    fun login(@Valid @RequestBody login: UserLoginRequest): GeneralResponse<String> =
        GeneralResponse(HttpStatus.OK.value(), userService.authenticate(login))

}