package com.avanade.ad_e_d.dragons.repository;

import com.avanade.ad_e_d.dragons.model.UsersGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersGameRepository extends JpaRepository<UsersGame, Long> {
}
