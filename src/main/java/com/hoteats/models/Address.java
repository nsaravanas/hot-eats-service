package com.hoteats.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long addressId;

	@Column
	private String doorNo;

	@Column
	private String steet;

	@Column
	private String city;

	@Column
	private String state;

	@Column
	private String country;

	@Column
	private Integer zipCode;

	@Column
	private String addressName;

//	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
//	@JoinColumn(name = "locationId", nullable = true)
//	private Location location;

	public Long getAddressId() {
		return addressId;
	}

//	public Location getLocation() {
//		return location;
//	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

//	public void setLocation(Location location) {
//		this.location = location;
//	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getSteet() {
		return steet;
	}

	public void setSteet(String steet) {
		this.steet = steet;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

}
