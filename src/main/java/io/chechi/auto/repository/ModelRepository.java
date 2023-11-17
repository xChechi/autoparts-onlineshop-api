package io.chechi.auto.repository;

import io.chechi.auto.entity.Make;
import io.chechi.auto.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {

    List<Model> findByMake (Make make);
}
