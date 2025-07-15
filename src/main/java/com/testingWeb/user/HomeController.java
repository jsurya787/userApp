package com.testingWeb.user;

import com.testingWeb.user.dto.EmployeeResponse;
import com.testingWeb.user.jpa.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    private final OrderService orderService;

    @Value("${spring.application.count}")
    private String count;

    public HomeController(OrderService orderService) {
        this.orderService = orderService;
    }

    //@RequestMapping("/")
    @GetMapping("/")
    public ResponseEntity<?> index(){
       EmployeeResponse employeeResponse=  orderService.placeOrder();
        System.out.println("here i am in home controller-----" + count);

        return ResponseEntity.ok(employeeResponse);

    }
    @GetMapping("/get")
    public ResponseEntity<?> getEmployees(){
        List< EmployeeEntity > employeeResponse=  orderService.getEmployees();

        return ResponseEntity.ok(employeeResponse);

    }
    @RequestMapping("/contact")
    public  String contact(){
        return "contact.html";
    }
}
