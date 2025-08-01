package com.testingWeb.user.jpa.entity.repository;

import com.testingWeb.user.jpa.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
     List<EmployeeEntity> findByName(String name);

}

