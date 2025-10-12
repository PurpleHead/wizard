package at.meandthebois.wizard.web.model

import java.time.LocalDate

data class CreatedGameResponseDto(
    val id: Long
)

data class PlayerSearchResponseDto(
    val foundPlayers: List<PlayerDto>
)

data class PlayerDto(
    val id: Long,
    val name: String
)

data class ActiveGameDto(
    val date: LocalDate,
    val turns: List<TurnDto>,
    val players: List<PlayerDto>
)

data class TurnDto(
    val turnNumber: Int,
    val player: PlayerDto,
    val scoreDiff: Int
)