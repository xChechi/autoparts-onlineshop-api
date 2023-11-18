package io.chechi.auto.repository;

import io.chechi.auto.dto.PartRequest;
import io.chechi.auto.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {

    //@Query("SELECT p FROM Part p JOIN p.category c WHERE c.name = :categoryName")
    //List<PartDto> findByCategory (Integer categoryId);

    PartRequest findByName (String name);
}
