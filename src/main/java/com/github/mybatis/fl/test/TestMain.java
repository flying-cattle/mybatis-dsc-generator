package com.github.mybatis.fl.test;

import java.sql.SQLException;
import java.util.Date;

import com.github.mybatis.fl.entity.BasisInfo;
import com.github.mybatis.fl.util.EntityInfoUtil;
import com.github.mybatis.fl.util.Generator;
import com.github.mybatis.fl.util.MySqlToJavaUtil;

public class TestMain {
	//基础信息
	public static final String PROJECT="qixingbao-show";
	public static final String AUTHOR="BianP";
	public static final String VERSION="V1.0";
	//数据库连接信息
	public static final String URL="jdbc:mysql://127.0.0.1:3306/qixingbao?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&useSSL=true";
	public static final String NAME="root";
	public static final String PASSWORD="123456";
	public static final String DATABASE="qixingbao";
	//类信息
	public static final String TABLE="product";
	public static final String CLASSNAME="Product";
	public static final String CLASSCOMMENT="产品";
	public static final String TIME="2018年7月5日";
	public static final String AGILE=new Date().getTime()+"";
	//路径信息
	public static final String ENTITY_URL="com.qixingbao.show.entity";
	public static final String DAO_URL="com.qixingbao.show.dao";
	public static final String XML_URL="com.qixingbao.show.dao.impl";
	public static final String SERVICE_URL="com.qixingbao.show.service";
	public static final String SERVICE_IMPL_URL="com.qixingbao.show.service.impl";
	public static final String CONTROLLER_URL="com.qixingbao.show.webApi";
	
	
	public static void main(String[] args) {
		BasisInfo bi=new BasisInfo(PROJECT, AUTHOR, VERSION, URL, NAME, PASSWORD, DATABASE, TIME, AGILE, ENTITY_URL, DAO_URL, XML_URL, SERVICE_URL, SERVICE_IMPL_URL, CONTROLLER_URL);
		bi.setTable(TABLE);
		bi.setEntityName(MySqlToJavaUtil.getClassName(TABLE));
		bi.setObjectName(MySqlToJavaUtil.changeToJavaFiled(TABLE));
		bi.setEntityComment(CLASSCOMMENT);
		try {
			bi=EntityInfoUtil.getInfo(bi);
			String aa1=Generator.createEntity("E:\\A-ZM-work\\work_qxb2\\qxbplatform\\qixingbao-show\\src\\main\\java\\", bi).toString();
			String aa2=Generator.createDao("E:\\A-ZM-work\\work_qxb2\\qxbplatform\\qixingbao-show\\src\\main\\java\\", bi).toString();
			String aa3=Generator.createDaoImpl("E:\\A-ZM-work\\work_qxb2\\qxbplatform\\qixingbao-show\\src\\main\\java\\", bi).toString();
			String aa4=Generator.createService("E:\\A-ZM-work\\work_qxb2\\qxbplatform\\qixingbao-show\\src\\main\\java\\", bi).toString();
			String aa5=Generator.createServiceImpl("E:\\A-ZM-work\\work_qxb2\\qxbplatform\\qixingbao-show\\src\\main\\java\\", bi).toString();
			String aa6=Generator.createController("E:\\A-ZM-work\\work_qxb2\\qxbplatform\\qixingbao-show\\src\\main\\java\\", bi).toString();
			
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
