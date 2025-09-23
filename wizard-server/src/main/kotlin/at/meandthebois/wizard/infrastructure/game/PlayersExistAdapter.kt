package at.meandthebois.wizard.infrastructure.game

import at.meandthebois.wizard.domain.game.outbound.PlayersExistPort
import at.meandthebois.wizard.infrastructure.shared.Adapter
import at.meandthebois.wizard.infrastructure.shared.persistence.PlayerRepository

@Adapter
class PlayersExistAdapter(val playerRepository: PlayerRepository) : PlayersExistPort {

    override fun checkIfPlayersExist(playerIds: List<Long>): Boolean {
        return playerRepository.findAllById(playerIds).size == playerIds.size
    }

}