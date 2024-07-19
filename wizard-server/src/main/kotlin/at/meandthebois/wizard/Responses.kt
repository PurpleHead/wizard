package at.meandthebois.wizard

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

data class GameDTOResponse(
        @JsonProperty("id") var id: Long,
        @JsonProperty("date") var date: LocalDate,
)
