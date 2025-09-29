//Created by Shibendra Mishra on 26/09/2025

package com.companypoc.services;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.companypoc.dao.CompanyMasterDao;
import com.companypoc.entity.CompanyMasterEntity;

@Service
public class CompanyMasterService {

    @Autowired
    private CompanyMasterDao companyMasterDao;

    // Create new Vendor
    public CompanyMasterEntity createVendor(CompanyMasterEntity vendor) {
        // Check for duplicate vendor name
        if (companyMasterDao.existsByVendorNameAndIsActiveTrue(vendor.getVendorName())) {
            throw new IllegalArgumentException(
                "Vendor with name '" + vendor.getVendorName() + "' already exists."
            );
        }

        // Check for duplicate contact number
        if (companyMasterDao.existsByContactNumberAndIsActiveTrue(vendor.getContactNumber())) {
            throw new IllegalArgumentException(
                "Vendor with contact number '" + vendor.getContactNumber() + "' already exists."
            );
        }

        // Ensure vendor is active by default
        vendor.setIsActive(true);

        // Save and return
        return companyMasterDao.save(vendor);
    }

    // Get all active vendors
    public List<CompanyMasterEntity> getAllActiveVendors() {
        return companyMasterDao.findByIsActiveTrue();
    }

    // Update vendor
    public CompanyMasterEntity updateVendor(Long vendorId, CompanyMasterEntity updatedVendor) {
        CompanyMasterEntity existing = companyMasterDao.findById(vendorId)
            .filter(CompanyMasterEntity::getIsActive)
            .orElseThrow(() -> new IllegalArgumentException("Vendor not found or inactive"));

        // Check duplicates for update
        if (companyMasterDao.existsByVendorNameAndIsActiveTrueAndVendorIdNot(updatedVendor.getVendorName(), vendorId)) {
            throw new IllegalArgumentException(
                "Vendor with name '" + updatedVendor.getVendorName() + "' already exists."
            );
        }

        if (companyMasterDao.existsByContactNumberAndIsActiveTrueAndVendorIdNot(updatedVendor.getContactNumber(), vendorId)) {
            throw new IllegalArgumentException(
                "Vendor with contact number '" + updatedVendor.getContactNumber() + "' already exists."
            );
        }

        // Update fields
        existing.setVendorName(updatedVendor.getVendorName());
        existing.setCategory(updatedVendor.getCategory());
        existing.setContactPerson(updatedVendor.getContactPerson());
        existing.setContactNumber(updatedVendor.getContactNumber());
        existing.setAddress(updatedVendor.getAddress());
        existing.setSlaPercentage(updatedVendor.getSlaPercentage());
        existing.setQuality(updatedVendor.getQuality());
        existing.setSecurityPercentage(updatedVendor.getSecurityPercentage());
        existing.setAnnualSpendAmount(updatedVendor.getAnnualSpendAmount());

        return companyMasterDao.save(existing);
    }

    // Soft delete vendor
    public CompanyMasterEntity deleteVendor(Long vendorId) {
        return companyMasterDao.findById(vendorId).map(vendor -> {
            vendor.setIsActive(false);
            return companyMasterDao.save(vendor);
        }).orElseThrow(() -> new IllegalArgumentException("Vendor with ID " + vendorId + " not found."));
    }

}