package com.frs.console.controller.v1

import com.frs.console.domain.menu.*
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("frs/console/v1/menus")
class MenuController {
    @GetMapping("/{id}")
    suspend fun getMenu(@PathVariable id: String): Menu {
        return Menu(UUID.randomUUID(), "test", "test")
    }

    @GetMapping
    suspend fun getMenus(@ModelAttribute getMenusRequest: GetMenusRequest): GetMenusResponse {
        TODO()
    }

    @PostMapping
    suspend fun createMenus(@ModelAttribute createMenusRequest: CreateMenusRequest): CreateMenusResponse {
        TODO()
    }

    @PutMapping("/{menuId}")
    suspend fun updateMenu(@PathVariable menuId: String, @ModelAttribute updateMenuRequest: UpdateMenuRequest): UpdateMenuResponse {
        TODO()
    }

    @DeleteMapping("/{menuId}")
    suspend fun deleteMenu(@PathVariable menuId: String, @ModelAttribute deleteMenuRequest: DeleteMenuRequest): DeleteMenuResponse {
        TODO()
    }

    @DeleteMapping
    suspend fun deleteMenus(@ModelAttribute deleteMenusRequest: DeleteMenusRequest): DeleteMenusResponse {
        TODO()
    }

    @PostMapping("/action")
    suspend fun actionMenu(@ModelAttribute actionMenuRequest: ActionMenuRequest): ActionMenuResponse {
        TODO()
    }
}