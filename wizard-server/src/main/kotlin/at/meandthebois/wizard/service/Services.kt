package at.meandthebois.wizard.service

import at.meandthebois.wizard.model.*
import at.meandthebois.wizard.persistence.model.Game
import at.meandthebois.wizard.persistence.*
import org.springframework.stereotype.Service

@Service
class GameService(var repository: GameRepository) {
    fun createGame(game: GameDTORequest): GameDTOResponse {
        val save = repository.save(Game(date = game.date))
        return GameDTOResponse(id = save.id!!, date = save.date)
    }

    fun getGames(): Iterable<GameDTOResponse> {
        return repository.findAll().map { GameDTOResponse(it.id!!, it.date) }
    }
}

@Service
class PlayerService(var repository: PlayerRepository) {
    fun getPlayers(): Iterable<PlayerDTOResponse> {
        return repository.findAll().map { PlayerDTOResponse(it.id!!, it.name) }
    }
}
