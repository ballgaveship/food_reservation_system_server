package com.frs.console.service.impl

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor

@ActiveProfiles("local")
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest(classes = [MenuServiceImpl::class])
class MenuServiceImplTest(private val menuServiceImpl: MenuServiceImpl) {

    @Test
    fun `get menu by menuId`() {
        val menuId = "testMenu"
        val menu = menuServiceImpl.findMenu(menuId)

        assertEquals(menuId, menu.id)
    }

}