package com.github.mybatis.util;

import java.util.List;

import com.github.mybatis.entity.BasisInfo;
import com.github.mybatis.entity.JsonResult;
import com.github.mybatis.entity.PropertyInfo;

public class Generator {
	//路径信息
	public static final String ENTITY="entity";
	public static final String DAO="dao";
	public static final String DAO_IMPL="daoImpl";
	public static final String SERVICE="service";
	public static final String SERVICE_IMPL="serviceImpl";
	public static final String CONTROLLER="controller";
	
	
	//①创建实体类
	public static JsonResult createEntity(String url,BasisInfo bi) {
		String fileUrl= EntityInfoUtil.getGeneratorFileUrl(url, bi.getEntityUrl(), bi.getEntityName(), ENTITY);
		return FreemarkerUtil.createFile(bi, "entity.ftl", fileUrl);
	}
	
	//②创建DAO
	public static JsonResult createDao(String url,BasisInfo bi) {
		String fileUrl= EntityInfoUtil.getGeneratorFileUrl(url, bi.getDaoUrl(), bi.getEntityName(), DAO);
		return FreemarkerUtil.createFile(bi, "dao.ftl", fileUrl);
	}
	
	//③创建mapper配置文件
	public static JsonResult createDaoImpl(String url,BasisInfo bi) {
		String fileUrl= EntityInfoUtil.getGeneratorFileUrl(url, bi.getMapperUrl(), bi.getEntityName(), DAO_IMPL);
		List<PropertyInfo> list=bi.getCis();
		String agile="";
		for (PropertyInfo propertyInfo : list) {
			agile=agile+propertyInfo.getColumn()+", ";
		}
		agile=agile.substring(0, agile.length()-2);
		bi.setAgile(agile);
		return FreemarkerUtil.createFile(bi, "mapper.ftl", fileUrl);
	}
	
	//④创建SERVICE
	public static JsonResult createService(String url,BasisInfo bi) {
		String fileUrl= EntityInfoUtil.getGeneratorFileUrl(url, bi.getServiceUrl(), bi.getEntityName(), SERVICE);
		return FreemarkerUtil.createFile(bi, "service.ftl", fileUrl);
	}
	
	//⑤创建SERVICE_IMPL
	public static JsonResult createServiceImpl(String url,BasisInfo bi) {
		String fileUrl= EntityInfoUtil.getGeneratorFileUrl(url, bi.getServiceImplUrl(), bi.getEntityName(), SERVICE_IMPL);
		return FreemarkerUtil.createFile(bi, "serviceImpl.ftl", fileUrl);
	}
	
	//⑥创建CONTROLLER
	public static JsonResult createController(String url,BasisInfo bi) {
		String fileUrl= EntityInfoUtil.getGeneratorFileUrl(url, bi.getControllerUrl(), bi.getEntityName(), CONTROLLER);
		return FreemarkerUtil.createFile(bi, "controller.ftl", fileUrl);
	}
}
