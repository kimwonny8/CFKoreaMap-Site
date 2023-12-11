package com.crossfit.server.repository;

import com.crossfit.server.entity.Gym;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.From;
import java.util.Optional;

@Repository
public interface GymRepository extends JpaRepository<Gym, Long> {

    Optional<Gym> findByMemberId(Long memberId);

    Optional<Gym> findByGymName(String name);
}
