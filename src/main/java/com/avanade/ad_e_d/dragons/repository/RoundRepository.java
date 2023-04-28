package com.avanade.ad_e_d.dragons.repository;

import com.avanade.ad_e_d.dragons.model.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long> {
}
