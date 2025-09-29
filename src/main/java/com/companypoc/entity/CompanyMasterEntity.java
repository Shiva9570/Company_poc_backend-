//created by Shibendra Mishra on 26/09/2024


package com.companypoc.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "company_master")
public class CompanyMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorId;

    @NotBlank(message = "Vendor name is required")
    @Size(max = 100, message = "Vendor name cannot exceed 100 characters")
    @Column(name = "vendor_name", nullable = false, unique = true, length = 100)
    private String vendorName;

    @NotBlank(message = "Category is required")
    @Size(max = 50, message = "Category cannot exceed 50 characters")
    @Column(name = "category", nullable = false, length = 50)
    private String category;

    @NotBlank(message = "Contact person is required")
    @Size(max = 60, message = "Contact person cannot exceed 100 characters")
    @Column(name = "contact_person", nullable = false, length = 100)
    private String contactPerson;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Contact number must be 10–15 digits")
    @Column(name = "contact_number", nullable = false, length = 15, unique = true)
    private String contactNumber;

    @NotBlank(message = "Address is required")
    @Size(max = 255, message = "Address cannot exceed 255 characters")
    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @NotNull(message = "SLA percentage is required")
    @DecimalMin(value = "0.00", message = "SLA percentage must be at least 0")
    @DecimalMax(value = "100.00", message = "SLA percentage cannot exceed 100")
    @Column(name = "sla_percentage", nullable = false, precision = 5, scale = 2)
    private BigDecimal slaPercentage;

    @NotNull(message = "Quality percentage is required")
    @DecimalMin(value = "0.00", message = "Quality must be at least 0")
    @DecimalMax(value = "100.00", message = "Quality cannot exceed 100")
    @Column(name = "quality", nullable = false, precision = 5, scale = 2)
    private BigDecimal quality;

    @NotNull(message = "Security percentage is required")
    @DecimalMin(value = "0.00", message = "Security percentage must be at least 0")
    @DecimalMax(value = "100.00", message = "Security percentage cannot exceed 100")
    @Column(name = "security_percentage", nullable = false, precision = 5, scale = 2)
    private BigDecimal securityPercentage;

    @NotNull(message = "Annual spend amount is required")
    @DecimalMin(value = "0.00", message = "Annual spend must be positive")
    @Column(name = "annual_spend_amount", nullable = false, precision = 20, scale = 2)
    private BigDecimal annualSpendAmount;
    
    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;  // default true for all new records

    // Getters & Setters for all fields 
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
    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
