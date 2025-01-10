package com.pearl_file.Site.Mapper;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pearl_file.Site.Controller.HospitalEntity;
@Repository
public interface HospitalRepository extends JpaRepository<HospitalEntity,Integer> {
//native query 사용 - ST_Distance_Sphere 과 Point 사용 
	@Query(value = "SELECT * FROM animal_hospital h "
	        + "ORDER BY ST_Distance_Sphere(Point(h.LO_VLUE, h.LA_VLUE), Point(:longitude, :latitude))", nativeQuery = true)
	List<HospitalEntity> findNearHospitals(@Param("latitude") double latitude, @Param("longitude") double longitude
//			, @Param("radius") double radius
			);

	List<HospitalEntity>findAll();
}
