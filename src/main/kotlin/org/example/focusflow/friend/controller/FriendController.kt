package org.example.focusflow.friend.controller

import org.example.focusflow.friend.dto.AddFriendRequest
import org.example.focusflow.friend.dto.RemoveFriendRequest
import org.example.focusflow.friend.service.FriendService
import org.example.focusflow.user.entity.User
import org.example.focusflow.user.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/focusflow/friends")
class FriendController(private val friendService: FriendService, private val userRepository: UserRepository) {

    @PostMapping("/add")
    fun addFriend(@RequestBody request: AddFriendRequest): ResponseEntity<String> {
        val user1 = userRepository.findById(request.user1).orElse(null)
        user1?.let {
            val user2 = userRepository.findById(request.user2).orElse(null)
            user2?.let {
                friendService.addFriend(user1, user2)
                return ResponseEntity.ok("Friend added successfully")
            } ?: run {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID ${request.user2} not found")
            }
        } ?: run {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID ${request.user1} not found")
        }
    }

    @PostMapping("/remove")
    fun removeFriend(@RequestBody request: RemoveFriendRequest): ResponseEntity<String> {
        val user1 = userRepository.findById(request.user1).orElse(null)

        user1?.let {
            val user2 = userRepository.findById(request.user2).orElse(null)
            user2?.let {
                friendService.removeFriend(user1, user2)
                return ResponseEntity.ok("Friend removed successfully")
            } ?: run {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID ${request.user2} not found")
            }
        } ?: run {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID ${request.user1} not found")
        }
    }

    @GetMapping("/{userId}")
    fun getFriends(@PathVariable userId: Long): ResponseEntity<List<User>> {
        val user = userRepository.findById(userId).orElse(null)

        user?.let {
            val friends = friendService.getFriends(user)
            return ResponseEntity.ok(friends)
        } ?: run {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(emptyList())
        }
    }
}