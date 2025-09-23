package at.meandthebois.wizard.infrastructure.game

import at.meandthebois.wizard.domain.game.model.CreateGameModel
import at.meandthebois.wizard.domain.game.outbound.CreateGamePort
import at.meandthebois.wizard.infrastructure.shared.Adapter
import at.meandthebois.wizard.infrastructure.shared.persistence.GameRepository
import at.meandthebois.wizard.infrastructure.shared.persistence.PlayerRepository
import at.meandthebois.wizard.infrastructure.shared.persistence.model.GameEntity

@Adapter
class CreateGameAdapter(
    val gameRepository: GameRepository,
    val playerRepository: PlayerRepository
) : CreateGamePort {

    override fun createGame(createGameModel: CreateGameModel): Long {
        val players = playerRepository.findAllById(createGameModel.playerIds)
        val gameEntity = GameEntity(
            date = createGameModel.date,
            players = players.toList()
        )
        return gameRepository.save(gameEntity).id!!
    }

}