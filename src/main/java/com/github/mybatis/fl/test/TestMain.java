/**   
 * Copyright © 2019 dream horse Info. Tech Ltd. All rights reserved.
 * @Package: com.github.mybatis.fl.convert
 * @author: flying-cattle  
 * @date: 2019年4月9日 下午8:15:25 
 */
package com.github.mybatis.fl.test;

import java.sql.SQLException;
import java.util.Date;

import com.github.mybatis.fl.entity.BasisInfo;
import com.github.mybatis.fl.util.EntityInfoUtil;
import com.github.mybatis.fl.util.Generator;
import com.github.mybatis.fl.util.MySqlToJavaUtil;

public class TestMain {
	//基础信息
	public static final String PROJECT="user_center";
	public static final String AUTHOR="BianPeng";
	public static final String VERSION="V1.0";
	//数据库连接信息
	public static final String URL="jdbc:mysql://127.0.0.1:3306/earn_knife?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&useSSL=true&serverTimezone=UTC";
	public static final String NAME="root";
	public static final String PASSWORD="pwd2020";
	public static final String DATABASE="earn_knife";
	//类信息
	public static final String TABLE="user";
	public static final String CLASSNAME="User";
	public static final String CLASSCOMMENT="用户";
	public static final String TIME="2019年4月9日";
	public static final String AGILE=new Date().getTime()+"";
	//路径信息
	public static final String ENTITY_URL="com.xin.usercenter.entity";
	public static final String DAO_URL="com.xin.usercenter.dao";
	public static final String XML_URL="com.xin.usercenter.dao.impl";
	public static final String SERVICE_URL="com.xin.usercenter.service";
	public static final String SERVICE_IMPL_URL="com.xin.usercenter.service.impl";
	public static final String CONTROLLER_URL="com.xin.usercenter.webApi";
	
	
	public static void main(String[] args) {
		BasisInfo bi=new BasisInfo(PROJECT, AUTHOR, VERSION, URL, NAME, PASSWORD, DATABASE, TIME, AGILE, ENTITY_URL, DAO_URL, XML_URL, SERVICE_URL, SERVICE_IMPL_URL, CONTROLLER_URL);
		bi.setTable(TABLE);
		bi.setEntityName(MySqlToJavaUtil.getClassName(TABLE));
		bi.setObjectName(MySqlToJavaUtil.changeToJavaFiled(TABLE));
		bi.setEntityComment(CLASSCOMMENT);
		try {
			bi=EntityInfoUtil.getInfo(bi);
			String aa1=Generator.createEntity("E:\\b_test_work\\", bi).toString();
			String aa2=Generator.createDao("E:\\b_test_work\\", bi).toString();
			String aa3=Generator.createDaoImpl("E:\\b_test_work\\", bi).toString();
			String aa4=Generator.createService("E:\\b_test_work\\", bi).toString();
			String aa5=Generator.createServiceImpl("E:\\b_test_work\\", bi).toString();
			String aa6=Generator.createController("E:\\b_test_work\\", bi).toString();
			
			System.out.println(aa1);
			System.out.println(aa2);
			System.out.println(aa3);
			System.out.println(aa4);
			System.out.println(aa5);
			System.out.println(aa6);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
