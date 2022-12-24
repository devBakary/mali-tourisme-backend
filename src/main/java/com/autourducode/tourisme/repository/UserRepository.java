package com.autourducode.tourisme.repository;

import java.util.List;
import java.util.Optional;

import com.autourducode.tourisme.models.Commentaire;
import com.autourducode.tourisme.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  @Query(value="select * from users where username = ?", nativeQuery = true)
  public User findUsername(String username);
}
