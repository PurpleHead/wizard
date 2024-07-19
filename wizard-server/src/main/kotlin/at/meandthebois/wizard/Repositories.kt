package at.meandthebois.wizard

import org.springframework.data.repository.CrudRepository

interface PlayerRepository : CrudRepository<Player, Long> {
    fun findByName(name: String): Player?
}

interface GameRepository : CrudRepository<Game, Long>
