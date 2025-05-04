package com.sparkplug.catalog.domain.repository;

import com.sparkplug.catalog.application.dto.modification.DetailedModificationDto;
import com.sparkplug.catalog.domain.model.Modification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface DetailedModificationRepository extends JpaRepository<Modification, Long> {

    String FIND_DETAILED_BY_ID_QUERY = """
        SELECT new com.sparkplug.catalog.application.dto.modification.DetailedModificationDto(
            m.id,
            m.name,

            new com.sparkplug.catalog.application.dto.modification.DetailedModificationDto$Engine(
                e.fuelType,
                e.type,
                e.horsepower,
                e.torque
            ),
        
            new com.sparkplug.catalog.application.dto.modification.DetailedModificationDto$Transmission(
                t.type,
                t.numberOfGears
            ),
   
            new com.sparkplug.catalog.application.dto.modification.DetailedModificationDto$Drivetrain(
                d.type
            ),
        
            new com.sparkplug.catalog.application.dto.modification.DetailedModificationDto$Generation(
                g.id,
                g.name,
                g.startYear
            ),
        
            new com.sparkplug.catalog.application.dto.modification.DetailedModificationDto$Model(
                mod.id,
                mod.name
            ),
        
            new com.sparkplug.catalog.application.dto.modification.DetailedModificationDto$Manufacturer(
                man.id,
                man.name,
                man.country
            )
        )
        FROM Modification m
        JOIN m.engine e
        JOIN m.drivetrain d
        JOIN m.transmission t
        JOIN m.generation g
        JOIN g.carModel mod
        JOIN mod.manufacturer man
        """;

    @Query(FIND_DETAILED_BY_ID_QUERY + "WHERE m.id = :modificationId")
    Optional<DetailedModificationDto> findDetailedById(@Param("modificationId") Long modificationId);

    @Query(FIND_DETAILED_BY_ID_QUERY + "WHERE m.id in :modificationIds")
    List<DetailedModificationDto> findDetailedInIds(@Param("modificationIds") Set<Long> modificationIds);
}