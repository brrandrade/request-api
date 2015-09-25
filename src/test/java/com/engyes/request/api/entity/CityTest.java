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
public class CityTest {
	@Autowired
	private Fixture fixture;

	@Test
	public void compareOk() throws Exception {

		City city = fixture.createCity();
		City city2 = fixture.createCity();

		assertEquals( city, city2 );
	}

	@Test
	public void compareNOk() throws Exception {

		City city = fixture.createCity();
		City city2 = fixture.createCity();
		city2.setFullName( "Different" );

		assertNotEquals( city, city2 );
	}

	@Test
	public void compareNOkGeoPosition() throws Exception {

		City city = fixture.createCity();
		City city2 = fixture.createCity();
		city2.getGeoPosition().setLatitude( 544545F );

		assertNotEquals( city, city2 );
	}

}
