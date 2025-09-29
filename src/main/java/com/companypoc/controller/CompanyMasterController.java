// Created by Shibendra Mishra on 26/09/2025

package com.companypoc.controller;
import com.companypoc.services.CompanyMasterService;
import com.companypoc.entity.CompanyMasterEntity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/vendors")
public class CompanyMasterController {

    @Autowired
    private CompanyMasterService companyMasterService;

    // Add a new vendor
    @PostMapping
    public ResponseEntity<?> createVendor(@RequestBody CompanyMasterEntity vendor) {
        try {
            CompanyMasterEntity createdVendor = companyMasterService.createVendor(vendor);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdVendor);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    // Get all active vendors
    @GetMapping
    public ResponseEntity<List<CompanyMasterEntity>> getAllActiveVendors() {
        List<CompanyMasterEntity> vendors = companyMasterService.getAllActiveVendors();
        return ResponseEntity.ok(vendors);
    }

    // Update vendor
    @PutMapping("/{vendorId}")
    public ResponseEntity<?> updateVendor(@PathVariable Long vendorId,
                                          @RequestBody CompanyMasterEntity updatedVendor) {
        try {
            CompanyMasterEntity vendor = companyMasterService.updateVendor(vendorId, updatedVendor);
            return ResponseEntity.ok(vendor);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    // Soft delete vendor
    @DeleteMapping("/{vendorId}")
    public ResponseEntity<?> deleteVendor(@PathVariable Long vendorId) {
        try {
        	companyMasterService.deleteVendor(vendorId);
        	return ResponseEntity.ok("Vendor with ID " + vendorId + " has been deleted.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}