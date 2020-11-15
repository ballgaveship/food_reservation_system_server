package com.frs.console.service.impl

import com.frs.console.domain.menu.Menu
import com.frs.console.service.MenuService
import org.springframework.stereotype.Service
import java.util.*

@Service
class MenuServiceImpl : MenuService {
    override fun findMenu(menuId: UUID): Menu {
        return Menu(menuId, "test", "test")
    }
}