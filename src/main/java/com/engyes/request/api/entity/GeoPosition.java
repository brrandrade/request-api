package com.engyes.request.api.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder( { "latitude", "longitude" } )
public class GeoPosition implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@JsonProperty( "latitude" )
	private Float latitude;
	@JsonProperty( "longitude" )
	private Float longitude;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude( Float latitude ) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude( Float longitude ) {
		this.longitude = longitude;
	}

	@Override
	public boolean equals( final Object other ) {
		if ( !( other instanceof GeoPosition ) ) return false;
		GeoPosition castOther = (GeoPosition)other;
		return new EqualsBuilder().append( latitude, castOther.latitude ).append( longitude,
				castOther.longitude ).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder( -2046549587, -1492543485 ).append( latitude ).append(
				longitude ).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder( this ).append( "id", id ).append( "latitude", latitude ).append(
				"longitude", longitude ).toString();
	}

}
