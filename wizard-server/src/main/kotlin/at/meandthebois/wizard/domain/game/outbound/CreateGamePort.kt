package at.meandthebois.wizard.domain.game.outbound

import at.meandthebois.wizard.domain.game.model.CreateGameModel

interface CreateGamePort {

    /**
     * Creates a game with the given players and date in the DB
     * and returns the primary key
     * */
    fun createGame(createGameModel: CreateGameModel): Long

}