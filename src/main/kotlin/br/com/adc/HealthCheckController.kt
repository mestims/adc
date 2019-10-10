package br.com.adc

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {

    @RequestMapping(method = [GET], path = ["/check"])
    fun healthCheck(): ResponseEntity<String> {
        return ResponseEntity.ok("Alive!")
    }
}