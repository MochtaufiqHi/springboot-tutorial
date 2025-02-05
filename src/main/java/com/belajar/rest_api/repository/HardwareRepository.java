package com.belajar.rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belajar.rest_api.entity.Hardware;

/**
 * @author fascal
 */

public interface HardwareRepository extends JpaRepository<Hardware, Long>{
    
}
