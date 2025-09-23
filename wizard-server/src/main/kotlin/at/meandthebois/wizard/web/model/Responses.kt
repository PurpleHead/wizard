package at.meandthebois.wizard.web.model

data class GameResponseDto(
    val id: Long
)

data class PlayerSearchResponseDto(
    val foundPlayers: List<PlayerDto>
)

data class PlayerDto(
    val id: Long,
    val name: String
)