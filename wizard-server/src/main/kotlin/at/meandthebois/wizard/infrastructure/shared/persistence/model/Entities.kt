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

    @OneToMany(mappedBy = "id.gameId")
    @OrderColumn(name = "turn_no")
    var turns: List<Turn>? = mutableListOf(),

    @ManyToMany
    @JoinTable(
        name = "game_player",
        joinColumns = [JoinColumn(name = "game_id")],
        inverseJoinColumns = [ JoinColumn(name = "player_id") ]
    )
    @OrderColumn(name = "seat_index")
    var players: List<PlayerEntity>
)

@Entity(name = "turn")
class Turn(
    @EmbeddedId var id: TurnId,
    var guess: Int,
    @Column(name = "score_diff") var scoreDiff: Int
)

@Embeddable
class TurnId (
    @Column(name = "game_id") var gameId: Long,
    @Column(name = "turn_no") var turnNo: Int,
    @ManyToOne var player: PlayerEntity,
)
