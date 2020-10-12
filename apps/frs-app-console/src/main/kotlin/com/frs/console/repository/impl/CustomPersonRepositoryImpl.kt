package com.frs.console.repository.impl

import com.frs.console.domain.person.Person
import com.frs.console.repository.CustomPersonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.core.asType
import org.springframework.stereotype.Repository

@Repository
class CustomPersonRepositoryImpl(
        private val databaseClient: DatabaseClient,
) : CustomPersonRepository {
    override fun findByRoleKey(key: String): Flow<Person> {
        val sql = "select p.id, p.name, p.email " +
                "from person_role pr " +
                "inner join person p " +
                "on pr.person_id = p.id " +
                "where role_id = (" +
                "    select id " +
                "    from role r " +
                "    where r.key = '$key')"
        return databaseClient
                .execute(sql)
                .asType<Person>()
                .fetch()
                .all()
                .asFlow()
    }
}