package com.example.VinIdentify;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.VinIdentify.service.VinDBSerice;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VinIdentifyApplicationTests {

	@Autowired
	VinDBSerice service;
	
	
	@Test
	public void contextLoads() {
	}

	
	@Test
	public void testGetVins()
	{
		Assert.assertEquals(service.findAllVehicles().size(), 3);
	}


}
