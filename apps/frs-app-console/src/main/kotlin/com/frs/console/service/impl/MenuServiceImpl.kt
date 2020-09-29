package com.frs.console.service.impl

import com.frs.console.domain.menu.Menu
import com.frs.console.service.MenuService
import org.springframework.stereotype.Service

@Service
class MenuServiceImpl : MenuService {
    override fun findMenu(menuId: String): Menu {
        return Menu(menuId)
    }
}