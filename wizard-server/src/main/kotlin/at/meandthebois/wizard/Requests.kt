package at.meandthebois.wizard

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

class GameDTORequest(@JsonProperty var date: LocalDate)
