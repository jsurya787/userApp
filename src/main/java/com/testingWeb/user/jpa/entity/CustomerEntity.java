package com.testingWeb.user.jpa.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String description;

    // Constructors
    public CustomerEntity() {
        // required by JPA
    }

    public  CustomerEntity(String name, String description, Integer age){
        this.name = name;
        this.age = age;
        this.description = description;

    }


//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//

    // need to laod data from db, with instances
    public String getDescription() {
        return description;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
