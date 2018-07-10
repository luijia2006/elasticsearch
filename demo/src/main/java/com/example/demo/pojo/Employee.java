package com.example.demo.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
 
// indexName ：索引名字（对应mysql的数据库名字）
//type:类型（对应mysql的表名
@Data
@Document(indexName = "megacorp",type = "employee", shards = 1,replicas = 0, refreshInterval = "-1")
public class Employee { 
@Id 
private String id; 
@Field 
private String firstName; 
@Field 
private String lastName; 
@Field 
private Integer age=0; 
@Field 
private String about; 
}