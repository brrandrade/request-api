package com.engyes.request.api.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 * The Class GeoPosition.
 *
 * @author  Bruno Andrade
 */
@JsonPropertyOrder( { "latitude", "longitude" } )
public class GeoPosition implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;
	
	/** The latitude. */
	@JsonProperty( "latitude" )
	private Float latitude;
	
	/** The longitude. */
	@JsonProperty( "longitude" )
	private Float longitude;

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
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	public Float getLatitude() {
		return latitude;
	}

	/**
	 * Sets the latitude.
	 *
	 * @param latitude the new latitude
	 */
	public void setLatitude( Float latitude ) {
		this.latitude = latitude;
	}

	/**
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
	public Float getLongitude() {
		return longitude;
	}

	/**
	 * Sets the longitude.
	 *
	 * @param longitude the new longitude
	 */
	public void setLongitude( Float longitude ) {
		this.longitude = longitude;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals( final Object other ) {
		if ( !( other instanceof GeoPosition ) ) return false;
		GeoPosition castOther = (GeoPosition)other;
		return new EqualsBuilder()	.append( latitude, castOther.latitude )
									.append( longitude, castOther.longitude )
									.isEquals();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder( -2046549587, -1492543485 )	.append( latitude )
																.append( longitude )
																.toHashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder( this )	.append( "id", id )
											.append( "latitude", latitude )
											.append( "longitude", longitude )
											.toString();
	}

}
