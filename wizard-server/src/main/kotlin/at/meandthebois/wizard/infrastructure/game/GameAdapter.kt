package at.meandthebois.wizard.infrastructure.game

import at.meandthebois.wizard.domain.game.model.CreateGameModel
import at.meandthebois.wizard.domain.game.model.GameModel
import at.meandthebois.wizard.domain.game.outbound.CreateGamePort
import at.meandthebois.wizard.domain.game.outbound.GetGamePort
import at.meandthebois.wizard.infrastructure.shared.Adapter
import at.meandthebois.wizard.infrastructure.shared.persistence.GameRepository
import at.meandthebois.wizard.infrastructure.shared.persistence.PlayerRepository
import at.meandthebois.wizard.infrastructure.shared.persistence.model.GameEntity

@Adapter
class GameAdapter(
    val gameRepository: GameRepository,
    val playerRepository: PlayerRepository,
    val gameEntityMapper: GameEntityMapper
) : CreateGamePort, GetGamePort {

    override fun createGame(createGameModel: CreateGameModel): Long {
        val playersById = playerRepository.findAllById(createGameModel.playerIds)
            .associateBy { it.id }
        val gameEntity = GameEntity(
            date = createGameModel.date,
            players = createGameModel.playerIds.mapNotNull { playersById[it] }
        )
        return gameRepository.save(gameEntity).id!!
    }

    override fun getGame(gameId: Int): GameModel? {
        return gameRepository.findById(gameId.toLong())
            .map { gameEntityMapper.mapToModel(it) }
            .orElse(null)
    }

}