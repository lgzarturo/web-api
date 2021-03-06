package com.alg.boot.webapi.apps.booking.v1

import com.alg.boot.webapi.apps.booking.restaurants.data.RestaurantDetailJson
import com.alg.boot.webapi.apps.booking.restaurants.data.RestaurantJson
import com.alg.boot.webapi.apps.booking.restaurants.services.RestaurantService
import com.alg.boot.webapi.handlers.responses.GeneralResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/restaurants")
class RestaurantController(
    private val restaurantService: RestaurantService
) {
    @GetMapping
    fun getRestaurants(): GeneralResponse<List<RestaurantJson>> =
        GeneralResponse("success", HttpStatus.OK.value(), "OK", restaurantService.getRestaurants())

    @GetMapping("/{restaurantId}")
    fun getRestaurant(@PathVariable restaurantId: Long): GeneralResponse<RestaurantDetailJson> =
        GeneralResponse("success", HttpStatus.OK.value(), "OK", restaurantService.getRestaurant(restaurantId))
}
