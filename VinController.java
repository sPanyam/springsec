package com.example.VinIdentify.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.VinIdentify.service.VinDBSerice;
import com.example.VinIdentify.vo.Vehicle;

@RestController
@RequestMapping("/findVinByNumber")
public class VinController {

	@Autowired
	VinDBSerice vinService;
	
	@Autowired
	ConsumeRestEndPoint consumeRest;
	
	@RequestMapping(value = "/{vin}", method = RequestMethod.GET)
	public @ResponseBody Vehicle getVehicleInformation(@PathVariable String vin)
	{
		try {
			
			Vehicle v = vinService.findOne(vin);
			return v;
		}
		catch (IndexOutOfBoundsException ex) {
			throw new IndexOutOfBoundsException();
		}
		catch(NullPointerException npe) {
			throw new NullPointerException();
		}
	}
}
