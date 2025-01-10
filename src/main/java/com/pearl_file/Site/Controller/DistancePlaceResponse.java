package com.pearl_file.Site.Controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class DistancePlaceResponse {
	//동물병원 정보
	private HospitalEntity hospitalEntity;
	//사용자와 동물병원 간의 거리
	private double distance;
	//요청된 위치 정보 
	private LocationRequest locationRequest;
}
