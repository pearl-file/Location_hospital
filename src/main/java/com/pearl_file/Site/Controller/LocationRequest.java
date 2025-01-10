package com.pearl_file.Site.Controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LocationRequest {
	// 요청된 위치 정보를 담는 DTO (두 지점간의 거리 계산시에 사용된다함)

	private double startLatitude;
	private double startLongitude;
	private double endLatitude;
	private double endLongitude;
}
