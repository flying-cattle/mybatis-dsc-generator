/**
 * @filename:GeneratorFileUrl 2018年06月06日
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
 * @Description:  GeneratorFileUrl 生产文件地址
 * @Author:       flying-cattle   
 * @CreateDate:   2018-06-06
 * @Version:      v1.0
 *    
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneratorFileUrl implements Serializable{
	private static final long serialVersionUID = 123125L;
	/**
     * @Description: 实体类路径
     */
	private String entityUrl;
	/**
     * @Description: dao路径
     */
	private String daoUrl;
	/**
     * @Description: mapper配置文件路径
     */
	private String mapperUrl;
	/**
     * @Description: service路径
     */
	private String serviceUrl;
	/**
     * @Description: service实现类路径
     */
	private String serviceImplUrl;
	/**
     * @Description: controller 控制类的
     */
	private String controllerUrl;
}
