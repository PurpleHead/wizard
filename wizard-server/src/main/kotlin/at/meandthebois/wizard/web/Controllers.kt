package at.meandthebois.wizard.web

import at.meandthebois.wizard.model.*
import at.meandthebois.wizard.service.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/games")
class GameController(var gameService: GameService) {
    @PostMapping("/create")
    fun createGame(@RequestBody game: GameDTORequest): GameDTOResponse {
        return gameService.createGame(game)
    }

    @GetMapping("/list")
    fun getGames(): Iterable<GameDTOResponse> {
        return gameService.getGames()
    }
}

@RestController
@RequestMapping("/api/players")
class PlayerController(var playerService: PlayerService) {
    @GetMapping("/list")
    fun getPlayers(): Iterable<PlayerDTOResponse> {
        return playerService.getPlayers()
    }
}
