package at.meandthebois.wizard.web

import at.meandthebois.wizard.model.GameDTORequest
import at.meandthebois.wizard.model.GameDTOResponse
import at.meandthebois.wizard.service.GameService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/games")
class GameController(var gameService: GameService) {
    @PostMapping("/create")
    fun createGame(@RequestBody game: GameDTORequest): GameDTOResponse {
        return gameService.createGame(game)
    }

    @GetMapping("/")
    fun getGames(): Iterable<GameDTOResponse> {
        return gameService.getGames()
    }
}
