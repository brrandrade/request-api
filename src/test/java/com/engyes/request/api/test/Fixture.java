package com.engyes.request.api.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.engyes.request.api.entity.City;
import com.engyes.request.api.entity.GeoPosition;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.core.header.InBoundHeaders;
import com.sun.jersey.spi.MessageBodyWorkers;

@Component
public class Fixture {

	public City createCity() {
		City city = new City();
		city.setCoreCountry( true );
		city.setCountry( "Germany" );
		city.setCountryCode( "DE" );
		city.setDistance( null );
		city.setFullName( "Berlin Tegel (TXL), Germany" );
		GeoPosition geo = createGeoPosition();
		city.setGeoPosition( geo );
		city.setIataAirportCode( "TXL" );
		city.setId( 314826L );
		city.setInEurope( true );
		city.setKey( null );
		city.setLocationId( null );
		city.setName( "Berlin Tegel" );
		city.setType( "airport" );

		return city;
	}

	public GeoPosition createGeoPosition() {
		GeoPosition geo = new GeoPosition();
		geo.setLatitude( 52.5548F );
		geo.setLongitude( 13.28903F );
		return geo;
	}

	public String[] createArgs() {
		return new String[] { "Berlin" };
	}

	@Value( "${api.url}" )
	public String url;

	public String getUrl() {
		return url + createArgs()[ 0 ];
	}

	public List<City> getEntity() {
		List<City> cities = new ArrayList<City>();
		cities.add( createCity() );

		City city = createCity();
		city.setCountry( "Germany" );
		city.setCountryCode( "DE" );
		city.setDistance( null );
		city.setFullName( "Berlingo" );
		city.setIataAirportCode( "TXL" );
		city.setId( 448103L );
		city.setInEurope( true );
		city.setKey( null );
		city.setLocationId( null );
		city.setName( "Berlingo" );
		city.setType( "location" );

		cities.add( city );

		return cities;
	}

	public String getContent() {
		return "[{\"_id\":376217,\"key\":null,\"name\":\"Berlin\",\"fullName\":\"Berlin, Germany\",\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"Germany\",\"geo_position\":{\"latitude\":52.52437,\"longitude\":13.41053},\"locationId\":8384,\"inEurope\":true,\"countryCode\":\"DE\",\"coreCountry\":true,\"distance\":null},{\"_id\":448103,\"key\":null,\"name\":\"Berlingo\",\"fullName\":\"Berlingo, Italy\",\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"Italy\",\"geo_position\":{\"latitude\":45.50298,\"longitude\":10.04366},\"locationId\":147721,\"inEurope\":true,\"countryCode\":\"IT\",\"coreCountry\":true,\"distance\":null}]";

	}

	public void deleteFile( String filename ) {
		try {

			File file = new File( filename );
			file.delete();

		} catch ( Exception e ) {

			e.printStackTrace();

		}
	}
	
	public MessageBodyWorkers createWorkers() {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put( JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE );
		Client client = Client.create( clientConfig );
		MessageBodyWorkers workers = client.getMessageBodyWorkers();
		return workers;
	}
	
	public InBoundHeaders createHeaders() {
		InBoundHeaders headers = new InBoundHeaders();
		headers.add( "Vary", "Accept-Encoding" );
		headers.add( "Transfer-Encoding", "chunked" );
		headers.add( "Date", "Fri, 25 Sep 2015 01:42:36 GMT" );
		headers.add( "X-Backend-Server", "search-be-4bhe" );
		headers.add( "Connection", "close" );
		headers.add( "Content-Type", "application/json;charset=UTF-8" );
		headers.add( "Server", "nginx/1.4.6 (Ubuntu)" );
		return headers;
	}
}