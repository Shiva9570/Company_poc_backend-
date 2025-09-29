//Created by Shibendra Mishra on 26/09/2025

package com.companypoc.dto;
import java.math.BigDecimal;
import jakarta.validation.constraints.*;

public class CompanyMasterDto {
	private Long vendorId;

	 @NotBlank(message = "Vendor name is required")
	    @Size(max = 100, message = "Vendor name cannot exceed 100 characters")
	    private String vendorName;

	    @NotBlank(message = "Category is required")
	    @Size(max = 50, message = "Category cannot exceed 50 characters")
	    private String category;

	    @NotBlank(message = "Contact person is required")
	    @Size(max = 60, message = "Contact person cannot exceed 60 characters")
	    private String contactPerson;

	    @NotBlank(message = "Contact number is required")
	    @Pattern(regexp = "^[0-9]{10,15}$", message = "Contact number must be 10–15 digits")
	    private String contactNumber;

	    @NotBlank(message = "Address is required")
	    @Size(max = 255, message = "Address cannot exceed 255 characters")
	    private String address;

	    @NotNull(message = "SLA percentage is required")
	    @DecimalMin(value = "0.00", message = "SLA percentage must be at least 0")
	    @DecimalMax(value = "100.00", message = "SLA percentage cannot exceed 100")
	    private BigDecimal slaPercentage;

	    @NotNull(message = "Quality percentage is required")
	    @DecimalMin(value = "0.00", message = "Quality must be at least 0")
	    @DecimalMax(value = "100.00", message = "Quality cannot exceed 100")
	    private BigDecimal quality;

	    @NotNull(message = "Security percentage is required")
	    @DecimalMin(value = "0.00", message = "Security percentage must be at least 0")
	    @DecimalMax(value = "100.00", message = "Security percentage cannot exceed 100")
	    private BigDecimal securityPercentage;

	    @NotNull(message = "Annual spend amount is required")
	    @DecimalMin(value = "0.00", message = "Annual spend must be positive")
	    private BigDecimal annualSpendAmount;
	// Getters and Setters

	    // Getters & Setters

	    public Long getVendorId() {
	        return vendorId;
	    }

	    public void setVendorId(Long vendorId) {
	        this.vendorId = vendorId;
	    }

	    public String getVendorName() {
	        return vendorName;
	    }

	    public void setVendorName(String vendorName) {
	        this.vendorName = vendorName;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

	    public String getContactPerson() {
	        return contactPerson;
	    }

	    public void setContactPerson(String contactPerson) {
	        this.contactPerson = contactPerson;
	    }

	    public String getContactNumber() {
	        return contactNumber;
	    }

	    public void setContactNumber(String contactNumber) {
	        this.contactNumber = contactNumber;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public BigDecimal getSlaPercentage() {
	        return slaPercentage;
	    }

	    public void setSlaPercentage(BigDecimal slaPercentage) {
	        this.slaPercentage = slaPercentage;
	    }

	    public BigDecimal getQuality() {
	        return quality;
	    }

	    public void setQuality(BigDecimal quality) {
	        this.quality = quality;
	    }

	    public BigDecimal getSecurityPercentage() {
	        return securityPercentage;
	    }

	    public void setSecurityPercentage(BigDecimal securityPercentage) {
	        this.securityPercentage = securityPercentage;
	    }

	    public BigDecimal getAnnualSpendAmount() {
	        return annualSpendAmount;
	    }

	    public void setAnnualSpendAmount(BigDecimal annualSpendAmount) {
	        this.annualSpendAmount = annualSpendAmount;
	    }
	}

