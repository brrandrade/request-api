package com.engyes.request.api.service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.engyes.request.api.entity.City;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

@Service
public class RequestApi {

	private static final Logger log = Logger.getLogger( RequestApi.class );

	String city;
	@Value( "${csv.split}" )
	String csvSplit;
	@Value( "${csv.header}" )
	String header;
	@Value( "${api.url}" )
	private String url;

	public final static int STATUS_OK = 0;
	public final static int STATUS_NOK = 1;
	public final static int STATUS_URL_NOK = 2;
	public final static int STATUS_FILE_ERROR = 3;

	private int status = 1;
	private String filename;

	public int getStatus() {
		return status;
	}

	public void setStatus( int status ) {
		this.status = status;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename( String filename ) {
		this.filename = filename;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl( String url ) {
		this.url = url;
	}

	public void run( String[] args ) {
		try {

			if ( args.length == 0 ) {
				setStatus( STATUS_NOK );
				throw new Exception(
						"Please, execute again with city name as argument (e.g., java -jar request_api.jar Berlin)" );
			}
			city = args[ 0 ];

			log.info( "Requesting data for city:" + city );

			ClientResponse response = processUrl();

			List<City> cities = response.getEntity( new GenericType<List<City>>() {
			} );

			setFilename( System.currentTimeMillis() + ".csv" );

			createFile( cities );
			log.info( "File created with name:" + getFilename() );
			setStatus( STATUS_OK );

		} catch ( FileNotFoundException e ) {
			setStatus( STATUS_FILE_ERROR );
			log.info( "Error, file was not created" );

		} catch ( UnsupportedEncodingException e ) {
			setStatus( STATUS_FILE_ERROR );
			log.info( "Error, file was not created, the charset is not supported." );

		} catch ( Exception e ) {
			log.info( e.getMessage() );
		}

	}

	private ClientResponse processUrl() throws Exception {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put( JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE );

		Client client = Client.create( clientConfig );

		WebResource webResource = createWebResource( client );
		webResource.accept( MediaType.APPLICATION_JSON );
		webResource.type( MediaType.APPLICATION_JSON );
		try {
			ClientResponse response = webResource.get( ClientResponse.class );

			if ( response.getStatus() != 200 ) {
				setStatus( STATUS_URL_NOK );
				throw new RuntimeException( "Failed : HTTP error code : " + response.getStatus() );
			}
			return response;

		} catch ( ClientHandlerException e ) {
			setStatus( STATUS_URL_NOK );
			throw new Exception( e );
		}

	}

	protected WebResource createWebResource( Client client ) {
		WebResource webResource = client.resource( getUrl() + city );
		return webResource;
	}

	private void createFile( List<City> cities ) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter( getFilename(), "UTF-8" );
		writer.println( header );

		for ( City city : cities ) {

			String line = "";
			line = city.getId() + "";
			line += csvSplit;
			line += city.getName();
			line += csvSplit;
			line += city.getType();
			line += csvSplit;
			line += city.getGeoPosition().getLatitude();
			line += csvSplit;
			line += city.getGeoPosition().getLongitude();

			writer.println( line );

		}
		writer.close();

	}

}
