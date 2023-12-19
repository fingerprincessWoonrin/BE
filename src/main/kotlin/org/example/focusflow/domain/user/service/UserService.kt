package org.example.focusflow.domain.user.service

import org.example.focusflow.domain.user.entity.User
import org.example.focusflow.domain.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.TypedQuery
import javax.transaction.Transactional

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository,
    private val entityManager: EntityManager
) {

    @Transactional
    fun registerUser(user: User): User {
        // 가장 마지막 UserID 조회
        val lastUserId = findLastUserId()

        // 새로운 UserID 설정
        user.userID = lastUserId + 1

        // 회원 등록
        return userRepository.save(user)
    }

    private fun findLastUserId(): Long {
        val query: TypedQuery<Long> = entityManager.createQuery(
            "SELECT MAX(u.userID) FROM User u",
            Long::class.java
        )

        return query.singleResult ?: 0L
    }

    fun loginUser(userName: String, password: String): Boolean {
        val user = userRepository.findByUserName(userName)
        return user != null && user.password == password
    }
}