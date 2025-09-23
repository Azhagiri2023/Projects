package com.giri.realestatelist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.giri.realestatelist.models.FinalEstate;

@Repository
public interface FinalEstateRepository extends JpaRepository<FinalEstate, Long> {
    @Query("SELECT f FROM FinalEstate f WHERE " +
           "(:city IS NULL OR LOWER(f.city) LIKE LOWER(CONCAT('%', :city, '%'))) AND " +
           "(:type IS NULL OR f.propertyType = :type) AND " +
           "(:category IS NULL OR f.propertyCategory = :category) AND " +
           "(:minRate IS NULL OR f.rate >= :minRate) AND " +
           "(:maxRate IS NULL OR f.rate <= :maxRate)")
    List<FinalEstate> searchProperties(
            @Param("city") String city,
            @Param("type") String propertyType,
            @Param("category") String propertyCategory,
            @Param("minRate") Double minRate,
            @Param("maxRate") Double maxRate
    );
}
