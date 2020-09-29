package com.frs.console.service.impl

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestPropertySource

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@TestPropertySource(properties = [
    "application.version=0.0.1-SNAPSHOT",
    "spring.profiles.active=local"
])
@SpringBootTest(classes = [MenuServiceImpl::class])
class MenuServiceImplTest(private val menuServiceImpl: MenuServiceImpl) {

    @Test
    fun `get menu by menuId`() {
        val menuId = "testMenu"
        val menu = menuServiceImpl.findMenu(menuId)

        assertEquals(menuId, menu.id);
    }

}