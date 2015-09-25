package com.engyes.request.api.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.engyes.request.api.Application;
import com.engyes.request.api.test.Fixture;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = Application.class, loader = AnnotationConfigContextLoader.class )
public class GeoPositionTest {
	@Autowired
	private Fixture fixture;

	@Test
	public void compareOk() throws Exception {

		GeoPosition geo = fixture.createGeoPosition();
		GeoPosition geo2 = fixture.createGeoPosition();

		assertEquals( geo, geo2 );
	}

	@Test
	public void compareNOk() throws Exception {

		GeoPosition geo = fixture.createGeoPosition();
		GeoPosition geo2 = fixture.createGeoPosition();
		geo2.setLatitude( 544545F );;

		assertNotEquals( geo, geo2 );
	}

}