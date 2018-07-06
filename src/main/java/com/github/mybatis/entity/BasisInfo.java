/**
 * @filename:BasisInfo 2018年06月06日
 * @project mybatis-generator flying-cattle  V1.0
 * Copyright(c) 2018 BianP Co. Ltd. 
 * All right reserved. 
 */
package com.github.mybatis.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**   
 *  
 * @Description:  BasisInfo 基础信息
 * @Author:       flying-cattle   
 * @CreateDate:   2018-06-06
 * @Version:      v1.0
 *    
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasisInfo implements Serializable{
	private static final long serialVersionUID = 123123L;
	/**
     * @Description: 项目名字
     */
	private String project;
	/**
     * @Description: 作者名字
     */
	private String author;
	/**
     * @Description: 版本号
     */
	private String version;
	
	/**
     * @Description: 数据库连接
     */
	private String dbUrl;
	/**
     * @Description: 数据访问账户
     */
	private String dbName;
	/**
     * @Description: 数据访问密码
     */
	private String dbPassword;
	/**
     * @Description: 数据库名
     */
	private String database;
	/**
     * @Description: 数据库表
     */
	private String table;
	
	/**
     * @Description: 类名
     */
	private String entityName;
	
	/**
     * @Description: 类对象
     */
	private String objectName;
	
	/**
     * @Description: 类说明
     */
	private String entityComment;
	/**
     * @Description: 日期时间
     */ 
	private String createTime;
	
	/**
     * @Description: 随机数/sql字段
     */ 
	private String agile;
	
	/**
     * @Description: 类路径
     */
	private String entityUrl;
	/**
     * @Description: dao路径
     */
	private String daoUrl;
	/**
     * @Description: xml-mapper路径
     */
	private String mapperUrl;
	/**
     * @Description: service路径
     */
	private String serviceUrl;
	/**
     * @Description: serviceImpl路径
     */
	private String serviceImplUrl;
	/**
     * @Description: Controller路径
     */
	private String controllerUrl;
	/**
     * @Description: 类信息
     */ 
	private List<PropertyInfo> cis;
	public BasisInfo(String project, String author, String version, String dbUrl, String dbName, String dbPassword,
			String database, String createTime, String agile, String entityUrl, String daoUrl, String mapperUrl,
			String serviceUrl, String serviceImplUrl, String controllerUrl) {
		super();
		this.project = project;
		this.author = author;
		this.version = version;
		this.dbUrl = dbUrl;
		this.dbName = dbName;
		this.dbPassword = dbPassword;
		this.database = database;
		this.createTime = createTime;
		this.agile = agile;
		this.entityUrl = entityUrl;
		this.daoUrl = daoUrl;
		this.mapperUrl = mapperUrl;
		this.serviceUrl = serviceUrl;
		this.serviceImplUrl = serviceImplUrl;
		this.controllerUrl = controllerUrl;
	}
}
