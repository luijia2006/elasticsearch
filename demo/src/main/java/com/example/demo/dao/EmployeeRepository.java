package com.example.demo.dao;

import com.example.demo.pojo.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
 

@Component
public interface EmployeeRepository extends ElasticsearchRepository<Employee,String> {

    Employee queryEmployeeById(String id);

}