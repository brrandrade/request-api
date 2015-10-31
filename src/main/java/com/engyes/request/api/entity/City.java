package com.engyes.request.api.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@XmlRootElement
@JsonPropertyOrder( { "_id", "key", "name", "fullName", "iata_airport_code", "type", "country",
		"geo_position", "locationId", "inEurope", "countryCode", "coreCountry", "distance" } )
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty( "_id" )
	private Long id;
	@JsonProperty( "key" )
	private Object key;
	@JsonProperty( "name" )
	private String name;
	@JsonProperty( "fullName" )
	private String fullName;
	@JsonProperty( "iata_airport_code" )
	private Object iataAirportCode;
	@JsonProperty( "type" )
	private String type;
	@JsonProperty( "country" )
	private String country;
	@JsonProperty( "geo_position" )
	private GeoPosition geoPosition;
	@JsonProperty( "locationId" )
	private Integer locationId;
	@JsonProperty( "inEurope" )
	private Boolean inEurope;
	@JsonProperty( "countryCode" )
	private String countryCode;
	@JsonProperty( "coreCountry" )
	private Boolean coreCountry;
	@JsonProperty( "distance" )
	private Object distance;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public Object getKey() {
		return key;
	}

	public void setKey( Object key ) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName( String fullName ) {
		this.fullName = fullName;
	}

	public Object getIataAirportCode() {
		return iataAirportCode;
	}

	public void setIataAirportCode( Object iataAirportCode ) {
		this.iataAirportCode = iataAirportCode;
	}

	public String getType() {
		return type;
	}

	public void setType( String type ) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry( String country ) {
		this.country = country;
	}

	public GeoPosition getGeoPosition() {
		return geoPosition;
	}

	public void setGeoPosition( GeoPosition geoPosition ) {
		this.geoPosition = geoPosition;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId( Integer locationId ) {
		this.locationId = locationId;
	}

	public Boolean getInEurope() {
		return inEurope;
	}

	public void setInEurope( Boolean inEurope ) {
		this.inEurope = inEurope;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode( String countryCode ) {
		this.countryCode = countryCode;
	}

	public Boolean getCoreCountry() {
		return coreCountry;
	}

	public void setCoreCountry( Boolean coreCountry ) {
		this.coreCountry = coreCountry;
	}

	public Object getDistance() {
		return distance;
	}

	public void setDistance( Object distance ) {
		this.distance = distance;
	}

	@Override
	public boolean equals( final Object other ) {
		if ( !( other instanceof City ) ) return false;
		City castOther = (City)other;
		return new EqualsBuilder()	.append( key, castOther.key )
									.append( name, castOther.name )
									.append( fullName, castOther.fullName )
									.append( iataAirportCode, castOther.iataAirportCode )
									.append( type, castOther.type )
									.append( country, castOther.country )
									.append( geoPosition, castOther.geoPosition )
									.append( locationId, castOther.locationId )
									.append( inEurope, castOther.inEurope )
									.append( countryCode, castOther.countryCode )
									.append( coreCountry, castOther.coreCountry )
									.append( distance, castOther.distance )
									.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder( -2116639697, 354678893 ).append( key )
															.append( name )
															.append( fullName )
															.append( iataAirportCode )
															.append( type )
															.append( country )
															.append( geoPosition )
															.append( locationId )
															.append( inEurope )
															.append( countryCode )
															.append( coreCountry )
															.append( distance )
															.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder( this )	.append( "id", id )
											.append( "key", key )
											.append( "name", name )
											.append( "fullName", fullName )
											.append( "iataAirportCode", iataAirportCode )
											.append( "type", type )
											.append( "country", country )
											.append( "geoPosition", geoPosition )
											.append( "locationId", locationId )
											.append( "inEurope", inEurope )
											.append( "countryCode", countryCode )
											.append( "coreCountry", coreCountry )
											.append( "distance", distance )
											.toString();
	}

}
