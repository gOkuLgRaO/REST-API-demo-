package com.restapidemo.restapi.repository;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.restapidemo.restapi.model.CloudVendor;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CloudVendorRepositoryTest {
    
    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp(){
        cloudVendor=new CloudVendor("1", "Amazon", "USA", "xxxxxxxx");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown(){
        cloudVendor=null;
        cloudVendorRepository.deleteAll();
    }

    // Test case SUCCESS

    @Test
    void findByVendorName_Found(){
        List<CloudVendor> cloudVendorList= cloudVendorRepository.findByVendorName("Amazon");
        assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
    }
    // Test case FAILURE 
    @Test
    void findByVendorName_NotFound(){
        List<CloudVendor> cloudVendorList= cloudVendorRepository.findByVendorName("GCP");
        assertThat(cloudVendorList.isEmpty()).isTrue();
    }
}
