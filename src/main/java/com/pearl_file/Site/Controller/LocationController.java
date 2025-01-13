package com.pearl_file.Site.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pearl_file.Site.Service.HospitalService;

@Controller
@RequestMapping("/api/hospitals")
public class LocationController {
	
	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping("/near")
	public ResponseEntity<List<DistancePlaceResponse>> getNearHospitals(
			@RequestParam("latitude")double latitude,
			@RequestParam("longitude")double longitude
			,
			@RequestParam("radius")double radius
			){
		List<DistancePlaceResponse> nearHospitals = 
				hospitalService.findNearHospitals(latitude,longitude
						,radius
						);
		return ResponseEntity.ok(nearHospitals);
	}
	
	@GetMapping("/list")
	@ResponseBody
	public List<HospitalEntity> getList() {
		return hospitalService.getList();
	}
	
	}
	
