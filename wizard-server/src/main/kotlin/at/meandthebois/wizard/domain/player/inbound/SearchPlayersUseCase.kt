package at.meandthebois.wizard.domain.player.inbound

import at.meandthebois.wizard.domain.player.outbound.FindPlayersPort
import at.meandthebois.wizard.domain.shared.UseCase
import at.meandthebois.wizard.domain.shared.model.PlayerModel

/**
 * As a game-master I want to search for existing players in the database
 * */
@UseCase
class SearchPlayersUseCase(val findPlayersPort: FindPlayersPort) {

    fun searchPlayers(searchTerm: String): List<PlayerModel> {
        return findPlayersPort.findPlayers(searchTerm)
    }

}