package org.example.focusflow.friend.entity

import org.example.focusflow.user.entity.User
import javax.persistence.*

@Entity
data class Friend(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val friendshipID: Long = 0,

    @ManyToOne
    val user1: User,

    @ManyToOne
    val user2: User,

    @Column(name = "UserID1")
    val userID1: Int = user1.id.toInt(),

    @Column(name = "UserID2")
    val userID2: Int = user2.id.toInt()
)