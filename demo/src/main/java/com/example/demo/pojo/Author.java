package com.example.demo.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Author implements Serializable {
    /**
	 * 作者id
	 */
	private Long id;
	/**
	 * 作者姓名
	 */
	private String name;
	/**
	 * 作者简介
	 */
	private String remark;
	
	//setters and getters
	//toString
	
}