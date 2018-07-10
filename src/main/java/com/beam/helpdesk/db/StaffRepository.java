package com.beam.helpdesk.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beam.helpdesk.domain.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

}