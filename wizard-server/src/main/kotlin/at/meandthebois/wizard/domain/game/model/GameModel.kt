package at.meandthebois.wizard.domain.game.model

import at.meandthebois.wizard.domain.shared.model.PlayerModel
import java.time.LocalDate

data class GameModel(
    val date: LocalDate,
    val turns: List<TurnModel>,
    val players: List<PlayerModel>
)

data class TurnModel(
    val turnNumber: Int,
    val player: PlayerModel,
    val scoreDiff: Int
)
