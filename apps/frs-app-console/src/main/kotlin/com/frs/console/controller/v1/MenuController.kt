package com.frs.console.controller.v1

import com.frs.console.domain.menu.Menu
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("frs/v1/menus")
class MenuController {
    @GetMapping("/{menuId}")
    suspend fun getMenu(@PathVariable menuId: String): ResponseEntity<Menu> {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Menu(menuId))
    }
}