package at.meandthebois.wizard.persistence

import at.meandthebois.wizard.persistence.model.Game
import at.meandthebois.wizard.persistence.model.Player
import org.springframework.data.repository.CrudRepository

interface PlayerRepository : CrudRepository<Player, Long> {
    fun findByName(name: String): Player?
}

interface GameRepository : CrudRepository<Game, Long>
