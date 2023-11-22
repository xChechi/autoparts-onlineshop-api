package io.chechi.auto.repository;

import io.chechi.auto.dto.MakeDto;
import io.chechi.auto.entity.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MakeRepository extends JpaRepository<Make, Integer> {

    Make findByName(String makeName);
}
