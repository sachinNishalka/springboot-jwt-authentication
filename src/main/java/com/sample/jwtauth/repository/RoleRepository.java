package com.sample.jwtauth.repository;

import com.sample.jwtauth.constants.ERoles;
import com.sample.jwtauth.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

    Optional<RoleEntity> findByName(ERoles roleName);
}
