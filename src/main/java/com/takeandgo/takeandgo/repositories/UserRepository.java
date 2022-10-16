package com.takeandgo.takeandgo.repositories;

import com.takeandgo.takeandgo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
