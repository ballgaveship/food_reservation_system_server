package com.frs.console.domain.menu

import java.time.Instant

data class GetMenusRequest(
        val nextToken: String?,
        val id: Int?,
        val name: String?,
        val status: String?,
        val fromDate: Instant?,
        val toDate: Instant?,
)