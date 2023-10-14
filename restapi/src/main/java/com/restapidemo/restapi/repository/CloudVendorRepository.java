package com.restapidemo.restapi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapidemo.restapi.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String>{
    List<CloudVendor> findByVendorName(String vendorName);
    
}
