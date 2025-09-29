//Created by Shibendra Mishra on 26/09/2025

package com.companypoc.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.companypoc.entity.CompanyMasterEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyMasterDao extends JpaRepository<CompanyMasterEntity, Long> {
	boolean existsByVendorNameAndIsActiveTrue(String vendorName);
	boolean existsByContactNumberAndIsActiveTrue(String contactNumber);
	List<CompanyMasterEntity> findByIsActiveTrue();
	boolean existsByVendorNameAndIsActiveTrueAndVendorIdNot(String vendorName, Long vendorId);
	boolean existsByContactNumberAndIsActiveTrueAndVendorIdNot(String contactNumber, Long vendorId);
	
}
