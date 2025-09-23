package at.meandthebois.wizard.infrastructure.player

import at.meandthebois.wizard.domain.player.model.PlayerModel
import at.meandthebois.wizard.domain.player.outbound.FindPlayersPort
import at.meandthebois.wizard.infrastructure.shared.Adapter
import at.meandthebois.wizard.infrastructure.shared.persistence.PlayerRepository

@Adapter
class FindPlayersAdapter(val playerRepository: PlayerRepository) : FindPlayersPort {

    override fun findPlayers(searchTerm: String): List<PlayerModel> {
        val foundPlayers = playerRepository.findByNameContainingIgnoreCase(searchTerm)
        return foundPlayers.map { PlayerModel(it.id!!, it.name) }
    }

}