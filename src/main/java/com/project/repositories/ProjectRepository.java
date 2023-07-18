package com.project.repositories;

import com.project.model.Projekt;
import com.project.model.Zadanie;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ProjectRepository extends JpaRepository<Projekt, Integer>, JpaSpecificationExecutor<Projekt> {
    Page<Projekt> findByNazwaContainingIgnoreCase(String nazwa, Pageable pageable);

    List<Projekt> findByNazwaContainingIgnoreCase(String nazwa);
    
    @Query("SELECT p FROM Projekt p")
    List<Projekt> getProjectsListForSelect();
   // Map<Integer, String> getProjectsListForSelect();
    
    Optional<Projekt> findTopByOrderByProjektIdDesc();
    
    List<Projekt> findByModificationDateBefore(LocalDateTime timestamp);
    
    List<Projekt> findBySyncedFalse();
    
    List<Projekt> findBytoBeDeletedTrue();
    
    Page<Projekt> findAllByprojektId(Integer projektId, Pageable pageable);
    
//    @Modifying
//    @Query("UPDATE Projekt p SET p.modificationDate = :modificationDate WHERE p.projektId = :projektId")
//    void updateProjektModificationDate(@Param("modificationDate") LocalDateTime modificationDate, @Param("projektId") Integer projektId);
//    
}
