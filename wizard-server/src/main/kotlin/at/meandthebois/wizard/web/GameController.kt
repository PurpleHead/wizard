package at.meandthebois.wizard.web

import at.meandthebois.wizard.domain.game.inbound.CreateGameUseCase
import at.meandthebois.wizard.web.model.CreateGameDto
import at.meandthebois.wizard.web.model.GameResponseDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/games")
class GameController(val createGameUseCase: CreateGameUseCase) {

    @PostMapping("/create")
    fun createGame(@RequestBody game: CreateGameDto): GameResponseDto {
        var createdGame = createGameUseCase.createGame(game.playerIds)
        return GameResponseDto(createdGame)
    }

}