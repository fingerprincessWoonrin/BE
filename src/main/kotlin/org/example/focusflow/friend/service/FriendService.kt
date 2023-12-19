package org.example.focusflow.friend.service

import org.example.focusflow.friend.entity.Friend
import org.example.focusflow.friend.exception.FriendExceptionHandler
import org.example.focusflow.friend.repository.FriendRepository
import org.example.focusflow.user.entity.User
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class FriendService(
    private val friendRepository: FriendRepository
) {
    @Transactional
    fun addFriend(user1: User, user2: User) {
        // 중복 체크
        if (!friendRepository.existsByUser1AndUser2(user1, user2) && !friendRepository.existsByUser1AndUser2(user2, user1)) {
            // 중복이 없으면 친구 추가
            val friend = Friend(user1 = user1, user2 = user2)
            friendRepository.save(friend)
        } else {
            // 이미 친구 관계가 존재하면 예외 처리 또는 메시지 반환
            throw FriendExceptionHandler.FriendshipAlreadyExistsException("Friendship already exists.")
        }
    }

    fun removeFriend(user1: User, user2: User) {
        val existingFriendship = friendRepository.findByUserID1AndUserID2(user1.id.toInt(), user2.id.toInt())
        existingFriendship?.let { friendRepository.delete(it) }
    }

    fun getFriends(user: User): List<User> {
        val friends = friendRepository.findAllByUserID1OrUserID2(user.id.toInt(), user.id.toInt())
            .flatMap { listOf(it.user1, it.user2) }
            .distinct()

        return friends
    }
}