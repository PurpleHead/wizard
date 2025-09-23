package at.meandthebois.wizard.domain.game.model

import java.time.LocalDate

data class CreateGameModel(
    val playerIds: List<Long>,
    val date: LocalDate
)
