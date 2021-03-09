package com.niroshan.backend.repository;

import com.niroshan.backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Integer> {
}
