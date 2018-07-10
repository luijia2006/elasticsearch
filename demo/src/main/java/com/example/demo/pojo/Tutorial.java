package com.example.demo.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Tutorial implements Serializable {
    private Long id;
	private String name;//教程名称
}