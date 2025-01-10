package com.pearl_file.Site.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pearl_file.Site.Controller.DistancePlaceResponse;
import com.pearl_file.Site.Controller.HospitalEntity;
import com.pearl_file.Site.Controller.LocationRequest;
import com.pearl_file.Site.Mapper.HospitalRepository;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;
	
	public List<DistancePlaceResponse> findNearHospitals(double latitude,double longitude
//			,double radius
			){
		List<HospitalEntity> hospitals = hospitalRepository.findNearHospitals(latitude,longitude
//				,radius
				);
		return hospitals.stream().map(hospital -> {
            double distance = calculateDistance(latitude, longitude, hospital.getLaValue(), hospital.getLoValue()); // Haversine 공식 등으로 거리 계산
            return DistancePlaceResponse.builder()
                    .hospitalEntity(hospital)
                    .distance(distance)
                    .locationRequest(new LocationRequest(latitude, longitude, hospital.getLaValue(), hospital.getLoValue())) // 임시
                    .build();
        }).sorted((h1, h2) -> Double.compare(h1.getDistance(), h2.getDistance())) // 거리순 정렬
          .collect(Collectors.toList());}
	// harversine 공식 구현 - 지구 모양을 고려해서 두 지점간의 거리를 계산 
		private double calculateDistance (double lat1, double lon1, double lat2, double lon2) {
			final int R = 6371; 
			
			double dLat = Math.toRadians(lat2 - lat1);
			double dLon = Math.toRadians(lon2 - lon1);
			double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
					Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))*
					Math.sin(Math.toRadians(dLon/2)) * Math.sin(Math.toRadians(dLon/2));
			double c = 2* Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
			double distance = R * c;
			return distance;
		
	}
		
		public List<HospitalEntity> getList() {
			return hospitalRepository.findAll();
		}
}
