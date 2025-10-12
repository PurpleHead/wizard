package at.meandthebois.wizard.infrastructure.game

import at.meandthebois.wizard.domain.game.model.GameModel
import at.meandthebois.wizard.domain.game.model.TurnModel
import at.meandthebois.wizard.infrastructure.shared.persistence.model.GameEntity
import at.meandthebois.wizard.infrastructure.shared.persistence.model.TurnEntity
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface GameEntityMapper {

    fun mapToModel(gameEntity: GameEntity): GameModel

    @Mapping(target = "turnNumber", source = "id.turnNo")
    @Mapping(target = "player", source = "id.player")
    fun mapTurn(turnEntity: TurnEntity): TurnModel

}