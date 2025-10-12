package at.meandthebois.wizard.domain.game.outbound

import at.meandthebois.wizard.domain.game.model.GameModel

interface GetGamePort {

    /**
     * Returns an active game by id or null if the game does not exist
     * */
    fun getGame(gameId: Int): GameModel?

}