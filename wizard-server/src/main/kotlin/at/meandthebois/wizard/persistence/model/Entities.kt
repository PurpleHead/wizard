package at.meandthebois.wizard.persistence.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.OneToMany
import java.time.LocalDate

@Entity
class Player(
        @Id var id: Long? = null,
        var name: String,
)

@Entity
class Game(
        @Id var id: Long? = null,
        var date: LocalDate,
)

@Embeddable
class TurnKey(
        @Column(name = "game_id") var gameId: Long? = null,
        @Column(name = "player_id") var playerId: Long? = null,
        @Column(name = "turn_no") var turnNo: Long? = null
)

@Entity
class Turn(
    @EmbeddedId var id: TurnKey,
    var guess: UInt,
    @Column(name = "score_diff") var scoreDiff: Int
)
