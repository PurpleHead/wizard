package at.meandthebois.wizard.infrastructure.shared.persistence

import at.meandthebois.wizard.infrastructure.shared.persistence.model.GameEntity
import at.meandthebois.wizard.infrastructure.shared.persistence.model.PlayerEntity
import org.springframework.data.repository.CrudRepository

interface PlayerRepository : CrudRepository<PlayerEntity, Long> {
    fun findByNameContainingIgnoreCase(name: String): List<PlayerEntity>
}

interface GameRepository : CrudRepository<GameEntity, Long>
