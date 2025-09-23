package at.meandthebois.wizard.domain.game.outbound

interface PlayersExistPort {

    fun checkIfPlayersExist(playerIds: List<Long>): Boolean

}