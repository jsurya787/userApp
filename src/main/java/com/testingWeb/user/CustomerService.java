package com.testingWeb.user;

import com.testingWeb.user.jpa.entity.CustomerEntity;
import com.testingWeb.user.jpa.entity.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import com.testingWeb.user.jpa.entity.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

  //  @Autowired
    final  private CustomerRepository customerRepository;
    final  private EmployeeRepository employeeRepository;

    public CustomerService(CustomerRepository customerRepository, EmployeeRepository employeeRepository){
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }

    public void SaveCustomerData(CustomerEntity customer){
        this.customerRepository.save(customer);
    }

    public List<?> getCustomerList(){
        System.out.println("------- getCustomerList ------");
        return this.customerRepository.findAll();
//        System.out.println("------- getCustomerList ------");
//        System.out.println(list);
//        return list;
    }

    public void deleteCustomer(CustomerEntity customer){
        this.customerRepository.delete(customer);
    }
}
