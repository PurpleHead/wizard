package at.meandthebois.wizard.web

import at.meandthebois.wizard.domain.player.inbound.SearchPlayersUseCase
import at.meandthebois.wizard.web.model.PlayerDto
import at.meandthebois.wizard.web.model.PlayerSearchResponseDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/players")
class PlayerController(val searchPlayersUseCase: SearchPlayersUseCase) {

    @GetMapping("/search/{searchTerm}")
    fun searchPlayers(
        @PathVariable("searchTerm") searchTerm: String
    ): PlayerSearchResponseDto {
        val foundPlayers = searchPlayersUseCase.searchPlayers(searchTerm)
        return PlayerSearchResponseDto(
            foundPlayers.map { PlayerDto(it.id, it.name) }
        )
    }

}