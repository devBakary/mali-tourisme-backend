package com.autourducode.tourisme.repository;

import java.util.Optional;

import com.autourducode.tourisme.models.ERole;
import com.autourducode.tourisme.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
