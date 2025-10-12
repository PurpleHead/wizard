package at.meandthebois.wizard.web.mapper

import at.meandthebois.wizard.domain.game.model.GameModel
import at.meandthebois.wizard.web.model.ActiveGameDto
import org.mapstruct.Mapper

@Mapper
interface ResponseDtoMapper {

    fun mapToActiveGameDto(activeGameModel: GameModel): ActiveGameDto

}