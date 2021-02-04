package com.debarz.recipeapp.user.repository;

import com.debarz.recipeapp.user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
