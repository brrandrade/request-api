package com.engyes.request.api.service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

/**
 * Request the API and proccess the information, also it generates a file 
 * with information received from the API
 *
 * @author  Bruno Andrade
 */
@Service
public class RequestApi {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger( RequestApi.class );

	/** The city. */
	String city;
	
	/** The csv split. */
	@Value( "${csv.split}" )
	String csvSplit;
	
	/** The header. */
	@Value( "${csv.header}" )
	String header;
	
	/** The url. */
	@Value( "${api.url}" )
	private String url;

	/** The Constant STATUS_OK. */
	public final static int STATUS_OK = 0;
	
	/** The Constant STATUS_NOK. */
	public final static int STATUS_NOK = 1;
	
	/** The Constant STATUS_URL_NOK. */
	public final static int STATUS_URL_NOK = 2;
	
	/** The Constant STATUS_FILE_ERROR. */
	public final static int STATUS_FILE_ERROR = 3;

	/** The status. */
	private int status = 1;
	
	/** The filename. */
	private String filename;

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus( int status ) {
		this.status = status;
	}

	/**
	 * Gets the filename.
	 *
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * Sets the filename.
	 *
	 * @param filename the new filename
	 */
	public void setFilename( String filename ) {
		this.filename = filename;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl( String url ) {
		this.url = url;
	}

	/**
	 * Run.
	 *
	 * @param args the city desired to process the information
	 */
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

	/**
	 * Process url.
	 *
	 * @return the client response
	 * @throws Exception the exception
	 */
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

	/**
	 * Creates the web resource.
	 *
	 * @param client the client
	 * @return the web resource
	 */
	protected WebResource createWebResource( Client client ) {
		WebResource webResource = client.resource( getUrl() + city );
		return webResource;
	}

	/**
	 * Creates the file.
	 *
	 * @param cities the cities
	 * @throws FileNotFoundException the file not found exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
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
