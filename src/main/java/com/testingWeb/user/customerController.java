package com.testingWeb.user;
import com.testingWeb.user.dto.CustomerResponse;
import com.testingWeb.user.jpa.entity.CustomerEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class customerController {
    final  private  CustomerService customerService;

    public  customerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCustomerData(@RequestBody CustomerResponse request){
        //System.out.println("request -----" + request);
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setAge(request.getAge());
        customerResponse.setName(request.getName());
        customerResponse.setDescription(request.getDescription());
        CustomerEntity customerEntity = new CustomerEntity(
                request.getName(),
                request.getDescription(),
                request.getAge()
        );

        this.customerService.SaveCustomerData(customerEntity);
        return  ResponseEntity.ok(customerResponse);

    }

    @GetMapping("/list")
    public  ResponseEntity<?> getCustomerList(){
        List<?> response = this.customerService.getCustomerList();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deteleCustomer(@RequestBody CustomerResponse response){
        System.out.println(" ===== deteleCustomer ===");
        System.out.println(response.getId());
        this.customerService.deleteCustomer(new CustomerEntity(response.getName(), response.getDescription(), response.getAge()));
        return ResponseEntity.ok("done");
    }
}
