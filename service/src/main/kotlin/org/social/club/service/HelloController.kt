package org.social.club.service

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/hellos")
class HelloController {

  @GetMapping
  fun get() = "hello :)"
}
