package com.testingWeb.user;

import com.testingWeb.user.dto.EmployeeResponse;
import com.testingWeb.user.jpa.entity.EmployeeEntity;
import com.testingWeb.user.jpa.entity.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    private final paymentService _paymentService;


    private final EmployeeRepository employeeRepository;

    public OrderService(paymentService paymentService, EmployeeRepository employeeRepository) {
        _paymentService = paymentService;
        this.employeeRepository = employeeRepository;
    }


    public EmployeeResponse placeOrder(){
        _paymentService.amount(23.3);
        System.out.println("placeOrder is called");

        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(1212);
        employeeResponse.setName("Jaisrua");

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName("asasas");
        employeeRepository.save(employeeEntity);

        return employeeResponse;
    }

    public List<EmployeeEntity> getEmployees() {
        //return employeeRepository.findAll();
        return  employeeRepository.findAll();
    }
}

