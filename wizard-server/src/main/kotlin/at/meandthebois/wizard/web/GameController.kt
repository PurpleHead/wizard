package at.meandthebois.wizard.web

import at.meandthebois.wizard.domain.game.inbound.CreateGameUseCase
import at.meandthebois.wizard.domain.game.inbound.GetActiveGameUseCase
import at.meandthebois.wizard.web.mapper.ResponseDtoMapper
import at.meandthebois.wizard.web.model.ActiveGameDto
import at.meandthebois.wizard.web.model.CreateGameDto
import at.meandthebois.wizard.web.model.CreatedGameResponseDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/games")
class GameController(
    val createGameUseCase: CreateGameUseCase,
    val getActiveGameUseCase: GetActiveGameUseCase,
    val responseDtoMapper: ResponseDtoMapper
) {

    @GetMapping("/{id}")
    fun getActiveGame(
        @PathVariable("id") gameId: Int
    ): ActiveGameDto {
        val activeGame = getActiveGameUseCase.getActiveGame(gameId)
        return responseDtoMapper.mapToActiveGameDto(activeGame)
    }

    @PostMapping("/create")
    fun createGame(@RequestBody game: CreateGameDto): CreatedGameResponseDto {
        val createdGame = createGameUseCase.createGame(game.playerIds)
        return CreatedGameResponseDto(createdGame)
    }

}