package at.meandthebois.wizard.domain.game.inbound

import at.meandthebois.wizard.domain.game.exception.GameCreateException
import at.meandthebois.wizard.domain.game.model.GameModel
import at.meandthebois.wizard.domain.game.outbound.GetGamePort
import at.meandthebois.wizard.domain.shared.UseCase

/**
 * As a game-master I want to fetch an active game
 * */
@UseCase
class GetActiveGameUseCase(
    val getGamePort: GetGamePort
) {

    fun getActiveGame(gameId: Int): GameModel {
        val optionalGame = getGamePort.getGame(gameId)
        if (optionalGame === null) {
            throw GameCreateException("Game with id $gameId does not exist.")
        }
        return optionalGame
    }

}