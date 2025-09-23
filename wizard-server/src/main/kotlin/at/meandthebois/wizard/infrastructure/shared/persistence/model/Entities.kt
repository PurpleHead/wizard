package at.meandthebois.wizard.infrastructure.shared.persistence.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity(name = "player")
class PlayerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var name: String
)

@Entity(name = "game")
class GameEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var date: LocalDate,

    @OneToMany(mappedBy = "game_id")
    @OrderColumn("id.turn_no")
    var turns: List<Turn>? = mutableListOf(),

    @ManyToMany
    @JoinTable(
        name = "game_player",
        joinColumns = [ JoinColumn("game_id") ],
        inverseJoinColumns = [ JoinColumn("player_id") ]
    )
    @OrderColumn("seat_index")
    var players: List<PlayerEntity>
)

@Entity(name = "turn")
class Turn(
    @EmbeddedId var id: TurnId,
    var guess: Int,
    var scoreDiff: Int
)

@Embeddable
class TurnId (
    var gameId: Long,
    @ManyToOne var player: PlayerEntity,
    var turnNo: Int,
)
