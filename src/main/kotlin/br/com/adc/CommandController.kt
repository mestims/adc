package br.com.adc

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CommandController {

    @PostMapping(path = ["/command/sound"])
    fun sound(@RequestBody requestBody: SoundRequestBody): ResponseEntity<String> {
        val rt = Runtime.getRuntime()
        val pr = rt.exec("pactl -- set-sink-volume 2 ${requestBody.volume}%")
        return ResponseEntity.ok(requestBody.volume.toString())
    }
}

class SoundRequestBody(@JsonProperty("volume") var volume: Int)