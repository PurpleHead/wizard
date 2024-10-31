package at.meandthebois.wizard.persistence.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Player(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var name: String
)

@Entity
class Game(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var date: LocalDate,
    @OneToMany(mappedBy = "game_id")
    var turns: List<Turn>? = mutableListOf()
)

@Entity
class Turn(
    @Id
    var game_id: Long,
    @Id
    @ManyToOne
    var player: Player,
    @Id
    var turnNo: Int,
    var guess: Int,
    var scoreDiff: Int
)
