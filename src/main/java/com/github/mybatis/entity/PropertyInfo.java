/**
 * @filename:ClassInfo 2018年06月06日
 * @project mybatis-generator flying-cattle  V1.0
 * Copyright(c) 2018 BianP Co. Ltd. 
 * All right reserved. 
 */
package com.github.mybatis.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**   
 *  
 * @Description:  ClassInfo 表基础信息
 * @Author:       flying-cattle   
 * @CreateDate:   2018-06-06
 * @Version:      v1.0
 *    
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyInfo implements Serializable{
	
	private static final long serialVersionUID = 123124L;
	/**
     * @Description: 数据库列名
     */
	private String column;
	/**
     * @Description: 数据库类型
     */
	private String jdbcType;
	/**
     * @Description: 数据库字段注释
     */
	private String comment;
	/**
     * @Description: 属性名
     */
	private String property;
	/**
     * @Description: Java类型
     */
	private String javaType;
}
