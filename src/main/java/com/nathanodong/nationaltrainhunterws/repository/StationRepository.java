package com.nathanodong.nationaltrainhunterws.repository;

import com.nathanodong.nationaltrainhunterws.model.Station;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, String> {
    List<Station> findByStationCodeOrStationName(String searchTerm, Pageable pageable);
}
