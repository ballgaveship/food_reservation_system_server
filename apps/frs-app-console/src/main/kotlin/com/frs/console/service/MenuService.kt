package com.frs.console.service

import com.frs.console.domain.menu.Menu

interface MenuService {
    fun findMenu(menuId: String): Menu
}