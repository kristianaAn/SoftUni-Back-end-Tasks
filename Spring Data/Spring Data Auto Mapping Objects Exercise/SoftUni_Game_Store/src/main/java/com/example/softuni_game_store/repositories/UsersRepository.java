package com.example.softuni_game_store.repositories;

import com.example.softuni_game_store.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    User findFirstByEmail(String email);
}
