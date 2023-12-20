package org.example.focusflow.friend.repository

import org.example.focusflow.friend.entity.Friend
import org.example.focusflow.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface FriendRepository : JpaRepository<Friend, Long> {
    fun findByUserID1AndUserID2(userID1: Int, userID2: Int): Friend?
    fun findAllByUserID1OrUserID2(userID1: Int, userID2: Int): List<Friend>
    fun existsByUser1AndUser2(user1: User, user2: User): Boolean
}