package at.meandthebois.wizard.domain.player.inbound

import at.meandthebois.wizard.domain.player.model.PlayerModel
import at.meandthebois.wizard.domain.player.outbound.FindPlayersPort
import at.meandthebois.wizard.domain.shared.UseCase

/**
 * As a game-master I want to search for existing players in the database
 * */
@UseCase
class SearchPlayersUseCase(val findPlayersPort: FindPlayersPort) {

    fun searchPlayers(searchTerm: String): List<PlayerModel> {
        return findPlayersPort.findPlayers(searchTerm)
    }

}