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
        @Id @GeneratedValue var id: Long? = null,
        var name: String,
        @OneToMany var turns: Set<Turn>
)

@Entity
class Game(
        @Id @GeneratedValue var id: Long? = null,
        var date: LocalDate,
        @OneToMany var turns: Set<Turn>
)

@Embeddable
class TurnKey(
        @Column(name = "game_id") var gameId: Long? = null,
        @Column(name = "player_id") var playerId: Long? = null,
        var turnNo: Long? = null
)

@Entity
class Turn(
    @EmbeddedId var id: TurnKey,
    @ManyToOne @MapsId("gameId") @JoinColumn(name = "game_id") var game: Game,
    @ManyToOne @MapsId("playerId") @JoinColumn(name = "player_id") var player: Player,
    var guess: UInt,
    var scoreDiff: Int
)
