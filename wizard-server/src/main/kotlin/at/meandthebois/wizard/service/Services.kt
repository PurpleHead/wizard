package at.meandthebois.wizard.service

import at.meandthebois.wizard.model.GameDTORequest
import at.meandthebois.wizard.model.GameDTOResponse
import at.meandthebois.wizard.persistence.model.Game
import at.meandthebois.wizard.persistence.GameRepository
import org.springframework.stereotype.Service

@Service
class GameService(var repository: GameRepository) {
    fun createGame(game: GameDTORequest): GameDTOResponse {
        val save = repository.save(Game(date = game.date, turns = HashSet()))
        return GameDTOResponse(id = save.id!!, date = save.date)
    }

    fun getGames(): Iterable<GameDTOResponse> {
        return repository.findAll().map { GameDTOResponse(it.id!!, it.date) }
    }
}
