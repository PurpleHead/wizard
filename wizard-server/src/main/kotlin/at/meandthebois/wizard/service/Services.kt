package at.meandthebois.wizard.service

import at.meandthebois.wizard.infrastructure.shared.persistence.GameRepository
import at.meandthebois.wizard.infrastructure.shared.persistence.model.GameEntity
import at.meandthebois.wizard.web.model.CreateGameDto
import at.meandthebois.wizard.web.model.GameResponseDto
import org.springframework.stereotype.Service

@Service
class GameService(var repository: GameRepository) {
    fun createGame(game: CreateGameDto): GameResponseDto {
        val save = repository.save(GameEntity(date = game.date))
        return GameResponseDto(id = save.id!!, date = save.date)
    }

    fun getGames(): Iterable<GameResponseDto> {
        return repository.findAll().map { GameResponseDto(it.id!!, it.date) }
    }
}
