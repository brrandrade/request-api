package com.engyes.request.api.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.io.ByteArrayInputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.engyes.request.api.Application;
import com.engyes.request.api.test.Fixture;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.header.InBoundHeaders;
import com.sun.jersey.spi.MessageBodyWorkers;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = Application.class, loader = AnnotationConfigContextLoader.class )
public class RequestApiTest {

	@Autowired
	private Fixture fixture;

	@Autowired
	@Spy
	private RequestApi requestApi;

	@Mock
	private WebResource wr;
	@Mock
	ClientResponse response;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks( this );
	}

	@Test
	public void processOK() throws Exception {
		doReturn( wr ).when( requestApi ).createWebResource( org.mockito.Matchers.any( Client.class ) );
		InBoundHeaders headers = fixture.createHeaders();
		MessageBodyWorkers workers = fixture.createWorkers();
		response = new ClientResponse( 200, headers,
				new ByteArrayInputStream( fixture.getContent().getBytes() ), workers );
		doReturn( response ).when( wr ).get( ClientResponse.class );

		requestApi.run( fixture.createArgs() );
		assertEquals( requestApi.getStatus(), RequestApi.STATUS_OK );
	}

	@Test
	public void processURLNOK() throws Exception {
		requestApi.setUrl( "ERRORRRRROROROROORO" );
		requestApi.run( fixture.createArgs() );
		assertEquals( requestApi.getStatus(), RequestApi.STATUS_URL_NOK );
	}

	@Test
	public void processNoArgument() throws Exception {
		requestApi.run( null );
		assertEquals( requestApi.getStatus(), RequestApi.STATUS_NOK );
	}

	@Test
	public void processErrorFile() throws Exception {
		doReturn( "\\\\////////------" ).when( requestApi ).getFilename();
		requestApi.run( fixture.createArgs() );
		assertEquals( requestApi.getStatus(), RequestApi.STATUS_FILE_ERROR );
	}

	@After
	public void clean() throws Exception {
		if ( requestApi.getStatus() == RequestApi.STATUS_OK ) {
			fixture.deleteFile( requestApi.getFilename() );
		}

	}
}
