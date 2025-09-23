package at.meandthebois.wizard.domain.game.inbound

import at.meandthebois.wizard.domain.game.exception.GameCreateException
import at.meandthebois.wizard.domain.game.model.CreateGameModel
import at.meandthebois.wizard.domain.game.outbound.CreateGamePort
import at.meandthebois.wizard.domain.game.outbound.PlayersExistPort
import at.meandthebois.wizard.domain.shared.model.UseCase
import java.time.LocalDate

/**
 * As a player I want to start a new game of wizard
 * */
@UseCase
class CreateGameUseCase(
    val createGamePort: CreateGamePort,
    val playersExistPort: PlayersExistPort
) {

    fun createGame(playerIds: List<Long>): Long {
        val gameDate = LocalDate.now()
        if (!playersExistPort.checkIfPlayersExist(playerIds)) {
            throw GameCreateException(message = "Failed to create game. One or more of the provided playerIds do not exist.")
        }
        if (playerIds.size < 3) {
            throw GameCreateException(message = "Failed to create game. At least three players are required.")
        }
        return createGamePort.createGame(CreateGameModel( playerIds, gameDate ))
    }

}