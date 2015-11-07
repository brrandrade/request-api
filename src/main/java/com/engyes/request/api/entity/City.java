package com.engyes.request.api.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 * The Class City.
 *
 * @author  Bruno Andrade
 */
@XmlRootElement
@JsonPropertyOrder( { "_id", "key", "name", "fullName", "iata_airport_code", "type", "country",
		"geo_position", "locationId", "inEurope", "countryCode", "coreCountry", "distance" } )
public class City implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@JsonProperty( "_id" )
	private Long id;
	
	/** The key. */
	@JsonProperty( "key" )
	private Object key;
	
	/** The name. */
	@JsonProperty( "name" )
	private String name;
	
	/** The full name. */
	@JsonProperty( "fullName" )
	private String fullName;
	
	/** The iata airport code. */
	@JsonProperty( "iata_airport_code" )
	private Object iataAirportCode;
	
	/** The type. */
	@JsonProperty( "type" )
	private String type;
	
	/** The country. */
	@JsonProperty( "country" )
	private String country;
	
	/** The geo position. */
	@JsonProperty( "geo_position" )
	private GeoPosition geoPosition;
	
	/** The location id. */
	@JsonProperty( "locationId" )
	private Integer locationId;
	
	/** The in europe. */
	@JsonProperty( "inEurope" )
	private Boolean inEurope;
	
	/** The country code. */
	@JsonProperty( "countryCode" )
	private String countryCode;
	
	/** The core country. */
	@JsonProperty( "coreCountry" )
	private Boolean coreCountry;
	
	/** The distance. */
	@JsonProperty( "distance" )
	private Object distance;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId( Long id ) {
		this.id = id;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public Object getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key the new key
	 */
	public void setKey( Object key ) {
		this.key = key;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName( String name ) {
		this.name = name;
	}

	/**
	 * Gets the full name.
	 *
	 * @return the full name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Sets the full name.
	 *
	 * @param fullName the new full name
	 */
	public void setFullName( String fullName ) {
		this.fullName = fullName;
	}

	/**
	 * Gets the iata airport code.
	 *
	 * @return the iata airport code
	 */
	public Object getIataAirportCode() {
		return iataAirportCode;
	}

	/**
	 * Sets the iata airport code.
	 *
	 * @param iataAirportCode the new iata airport code
	 */
	public void setIataAirportCode( Object iataAirportCode ) {
		this.iataAirportCode = iataAirportCode;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType( String type ) {
		this.type = type;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry( String country ) {
		this.country = country;
	}

	/**
	 * Gets the geo position.
	 *
	 * @return the geo position
	 */
	public GeoPosition getGeoPosition() {
		return geoPosition;
	}

	/**
	 * Sets the geo position.
	 *
	 * @param geoPosition the new geo position
	 */
	public void setGeoPosition( GeoPosition geoPosition ) {
		this.geoPosition = geoPosition;
	}

	/**
	 * Gets the location id.
	 *
	 * @return the location id
	 */
	public Integer getLocationId() {
		return locationId;
	}

	/**
	 * Sets the location id.
	 *
	 * @param locationId the new location id
	 */
	public void setLocationId( Integer locationId ) {
		this.locationId = locationId;
	}

	/**
	 * Gets the in europe.
	 *
	 * @return the in europe
	 */
	public Boolean getInEurope() {
		return inEurope;
	}

	/**
	 * Sets the in europe.
	 *
	 * @param inEurope the new in europe
	 */
	public void setInEurope( Boolean inEurope ) {
		this.inEurope = inEurope;
	}

	/**
	 * Gets the country code.
	 *
	 * @return the country code
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Sets the country code.
	 *
	 * @param countryCode the new country code
	 */
	public void setCountryCode( String countryCode ) {
		this.countryCode = countryCode;
	}

	/**
	 * Gets the core country.
	 *
	 * @return the core country
	 */
	public Boolean getCoreCountry() {
		return coreCountry;
	}

	/**
	 * Sets the core country.
	 *
	 * @param coreCountry the new core country
	 */
	public void setCoreCountry( Boolean coreCountry ) {
		this.coreCountry = coreCountry;
	}

	/**
	 * Gets the distance.
	 *
	 * @return the distance
	 */
	public Object getDistance() {
		return distance;
	}

	/**
	 * Sets the distance.
	 *
	 * @param distance the new distance
	 */
	public void setDistance( Object distance ) {
		this.distance = distance;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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
