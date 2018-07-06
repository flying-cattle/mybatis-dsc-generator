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
	
	/**
	 * @explain ①创建实体类
	 * @param   对象参数：url、BasisInfo
	 * @return  JsonResult
	 * @author  BianP
	 */
	public static JsonResult createEntity(String url,BasisInfo bi) {
		String fileUrl= EntityInfoUtil.getGeneratorFileUrl(url, bi.getEntityUrl(), bi.getEntityName(), ENTITY);
		return FreemarkerUtil.createFile(bi, "entity.ftl", fileUrl);
	}
	
	/**
	 * @explain ②创建DAO
	 * @param   对象参数：url、BasisInfo
	 * @return  JsonResult
	 * @author  BianP
	 */
	public static JsonResult createDao(String url,BasisInfo bi) {
		String fileUrl= EntityInfoUtil.getGeneratorFileUrl(url, bi.getDaoUrl(), bi.getEntityName(), DAO);
		return FreemarkerUtil.createFile(bi, "dao.ftl", fileUrl);
	}
	
	/**
	 * @explain ③创建mapper配置文件
	 * @param   对象参数：url、BasisInfo
	 * @return  JsonResult
	 * @author  BianP
	 */
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
	
	/**
	 * @explain ④创建SERVICE
	 * @param   对象参数：url、BasisInfo
	 * @return  JsonResult
	 * @author  BianP
	 */
	public static JsonResult createService(String url,BasisInfo bi) {
		String fileUrl= EntityInfoUtil.getGeneratorFileUrl(url, bi.getServiceUrl(), bi.getEntityName(), SERVICE);
		return FreemarkerUtil.createFile(bi, "service.ftl", fileUrl);
	}
	
	/**
	 * @explain ⑤创建SERVICE_IMPL
	 * @param   对象参数：url、BasisInfo
	 * @return  JsonResult
	 * @author  BianP
	 */
	public static JsonResult createServiceImpl(String url,BasisInfo bi) {
		String fileUrl= EntityInfoUtil.getGeneratorFileUrl(url, bi.getServiceImplUrl(), bi.getEntityName(), SERVICE_IMPL);
		return FreemarkerUtil.createFile(bi, "serviceImpl.ftl", fileUrl);
	}
	
	/**
	 * @explain ⑥创建CONTROLLER
	 * @param   对象参数：url、BasisInfo
	 * @return  JsonResult
	 * @author  BianP
	 */
	public static JsonResult createController(String url,BasisInfo bi) {
		String fileUrl= EntityInfoUtil.getGeneratorFileUrl(url, bi.getControllerUrl(), bi.getEntityName(), CONTROLLER);
		return FreemarkerUtil.createFile(bi, "controller.ftl", fileUrl);
	}
}
