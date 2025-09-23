package at.meandthebois.wizard.domain.player.outbound

import at.meandthebois.wizard.domain.player.model.PlayerModel

interface FindPlayersPort {

    fun findPlayers(searchTerm: String): List<PlayerModel>

}