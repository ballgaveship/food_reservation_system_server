package com.frs.console.service

import com.frs.console.domain.menu.Menu
import java.util.*

interface MenuService {
    fun findMenu(menuId: UUID): Menu
}