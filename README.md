# mybatis-dsc-generator
    根据完善的数据库表结构，一键生成dao.java,mapper.xml,service.java,serviceImpl.java,controller.java，完成单表的增删改查、
    组合条件集合查询，组合条件分页查询。

# 源码地址
- GitHub:https://github.com/flying-cattle/mybatis-dsc-generator
- 码云：https://gitee.com/flying-cattle/mybatis-dsc-generator

# MAVEN地址
``` xml
<dependency>
    <groupId>com.github.flying-cattle</groupId>
    <artifactId>mybatis-dsc-generator</artifactId>
    <version>2.0.0.RELEASE</version>
</dependency>
```

# 数据表结构样式
``` sql
CREATE TABLE `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_no` varchar(50) NOT NULL COMMENT '订单编号',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `source` varchar(50) NOT NULL COMMENT '来源',
  `product_id` bigint(20) NOT NULL COMMENT '产品ID',
  `product_name` varchar(100) NOT NULL COMMENT '产品名字',
  `unit_price` int(10) unsigned NOT NULL COMMENT '单价',
  `number` int(10) unsigned NOT NULL COMMENT '数量',
  `selling_price` int(11) DEFAULT NULL COMMENT '卖价',
  `state` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0等待支付，1支付成功，2支付失败，3撤销',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '交易变化时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='订单信息';
```
要求必须有表注释，要求必须有主键为id,切为bigint，所有字段必须有注释（便于生成java注释）。

# 生成的实体类
生成方法参考源码中的：https://github.com/flying-cattle/mybatis-dsc-generator/blob/master/src/main/java/com/github/mybatis/test/TestMain.java

# 生成的实体类
``` java
/**
 * @filename:Order 2018年7月5日
 * @project deal-center  V1.0
 * Copyright(c) 2018 BianP Co. Ltd. 
 * All right reserved. 
 */
package com.xin.dealcenter.entity;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**   
 *  
 * @Description:  订单
 * @Author:       BianP   
 * @CreateDate:   2018年7月5日
 * @Version:      V1.0
 *    
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

	private static final long serialVersionUID = 1531104207412L;
	
	@ApiModelProperty(name = "id" , value = "ID")
	private Long id;
	@ApiModelProperty(name = "orderNo" , value = "订单编号")
	private String orderNo;
	@ApiModelProperty(name = "uid" , value = "用户ID")
	private Long uid;
	@ApiModelProperty(name = "source" , value = "来源")
	private String source;
	@ApiModelProperty(name = "productId" , value = "产品ID")
	private Long productId;
	@ApiModelProperty(name = "productName" , value = "产品名字")
	private String productName;
	@ApiModelProperty(name = "unitPrice" , value = "单价")
	private Integer unitPrice;
	@ApiModelProperty(name = "number" , value = "数量")
	private Integer number;
	@ApiModelProperty(name = "sellingPrice" , value = "卖价")
	private Integer sellingPrice;
	@ApiModelProperty(name = "state" , value = "0等待支付，1支付成功，2支付失败，3撤销")
	private Integer state;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(name = "createTime" , value = "创建时间")
	private Date createTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(name = "updateTime" , value = "交易变化时间")
	private Date updateTime;
}

```
# 生成的DAO
``` java
/**
 * @filename:OrderDao 2018年7月5日
 * @project deal-center  V1.0
 * Copyright(c) 2018 BianP Co. Ltd. 
 * All right reserved. 
 */
package com.xin.dealcenter.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.xin.dealcenter.entity.Order;

/**   
 *  
 * @Description:  订单——DAO
 * @Author:       BianP   
 * @CreateDate:   2018年7月5日
 * @Version:      V1.0
 *    
 */
@Mapper
public interface OrderDao {
	
	public Order selectByPrimaryKey(Long id);
	
	public int deleteByPrimaryKey(Long id);
	
	public int insertSelective(Order order);
	
	public int updateByPrimaryKeySelective(Order order);
	
	public List<Order> queryOrderList(Order order);
}

```
# 生成的XML
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.xin.dealcenter.dao.OrderDao">
	<resultMap id="BaseResultMap" type="com.xin.dealcenter.entity.Order">
	<id column="id" jdbcType="BIGINT" property="id" />
	<id column="order_no" jdbcType="VARCHAR" property="orderNo" />
	<id column="uid" jdbcType="BIGINT" property="uid" />
	<id column="source" jdbcType="VARCHAR" property="source" />
	<id column="product_id" jdbcType="BIGINT" property="productId" />
	<id column="product_name" jdbcType="VARCHAR" property="productName" />
	<id column="unit_price" jdbcType="INTEGER" property="unitPrice" />
	<id column="number" jdbcType="INTEGER" property="number" />
	<id column="selling_price" jdbcType="INTEGER" property="sellingPrice" />
	<id column="state" jdbcType="INTEGER" property="state" />
	<id column="create_time" jdbcType="TIMESTAMP" property="createTime" />
	<id column="update_time" jdbcType="TIMESTAMP" property="updateTime" />
	</resultMap>
	<sql id="Base_Column_List">
	id, order_no, uid, source, product_id, product_name, unit_price, number, selling_price, state, create_time, update_time
	</sql>
	<!-- 查询 -->
	<select id="selectByPrimaryKey" parameterType="java.lang.Long"
		resultMap="BaseResultMap">
		select
		<include refid="Base_Column_List" />
		from order
		where id = #{id,jdbcType=BIGINT}
	</select>
	<!-- 删除 -->
	<delete id="deleteByPrimaryKey" parameterType="java.lang.Long">
		delete from order
		where id = #{id,jdbcType=BIGINT}
	</delete>
	<!-- 选择添加 -->
	<insert id="insertSelective" parameterType="com.xin.dealcenter.entity.Order">
		<selectKey keyProperty="id" order="AFTER" resultType="java.lang.Long">
			SELECT
			LAST_INSERT_ID()
		</selectKey>
		insert into order
		<trim prefix="(" suffix=")" suffixOverrides=",">
			<if test="id != null">
				id,
			</if>
			<if test="orderNo != null">
				order_no,
			</if>
			<if test="uid != null">
				uid,
			</if>
			<if test="source != null">
				source,
			</if>
			<if test="productId != null">
				product_id,
			</if>
			<if test="productName != null">
				product_name,
			</if>
			<if test="unitPrice != null">
				unit_price,
			</if>
			<if test="number != null">
				number,
			</if>
			<if test="sellingPrice != null">
				selling_price,
			</if>
			<if test="state != null">
				state,
			</if>
			<if test="createTime != null">
				create_time,
			</if>
			<if test="updateTime != null">
				update_time,
			</if>
		</trim>
		<trim prefix="values (" suffix=")" suffixOverrides=",">
			<if test="id != null">
				#{id,jdbcType=BIGINT},
			</if>
			<if test="orderNo != null">
				#{orderNo,jdbcType=VARCHAR},
			</if>
			<if test="uid != null">
				#{uid,jdbcType=BIGINT},
			</if>
			<if test="source != null">
				#{source,jdbcType=VARCHAR},
			</if>
			<if test="productId != null">
				#{productId,jdbcType=BIGINT},
			</if>
			<if test="productName != null">
				#{productName,jdbcType=VARCHAR},
			</if>
			<if test="unitPrice != null">
				#{unitPrice,jdbcType=INTEGER},
			</if>
			<if test="number != null">
				#{number,jdbcType=INTEGER},
			</if>
			<if test="sellingPrice != null">
				#{sellingPrice,jdbcType=INTEGER},
			</if>
			<if test="state != null">
				#{state,jdbcType=INTEGER},
			</if>
			<if test="createTime != null">
				#{createTime,jdbcType=TIMESTAMP},
			</if>
			<if test="updateTime != null">
				#{updateTime,jdbcType=TIMESTAMP},
			</if>
		</trim>
	</insert>
	<!-- 选择修改 -->
	<update id="updateByPrimaryKeySelective" parameterType="com.xin.dealcenter.entity.Order">
		update order
		<set>
			<if test="id != null">
				id = #{id,jdbcType=BIGINT},
			</if>
			<if test="orderNo != null">
				order_no = #{orderNo,jdbcType=VARCHAR},
			</if>
			<if test="uid != null">
				uid = #{uid,jdbcType=BIGINT},
			</if>
			<if test="source != null">
				source = #{source,jdbcType=VARCHAR},
			</if>
			<if test="productId != null">
				product_id = #{productId,jdbcType=BIGINT},
			</if>
			<if test="productName != null">
				product_name = #{productName,jdbcType=VARCHAR},
			</if>
			<if test="unitPrice != null">
				unit_price = #{unitPrice,jdbcType=INTEGER},
			</if>
			<if test="number != null">
				number = #{number,jdbcType=INTEGER},
			</if>
			<if test="sellingPrice != null">
				selling_price = #{sellingPrice,jdbcType=INTEGER},
			</if>
			<if test="state != null">
				state = #{state,jdbcType=INTEGER},
			</if>
			<if test="createTime != null">
				create_time = #{createTime,jdbcType=TIMESTAMP},
			</if>
			<if test="updateTime != null">
				update_time = #{updateTime,jdbcType=TIMESTAMP},
			</if>
		</set>
		where id = #{id,jdbcType=BIGINT}
	</update>
	<!-- 组合条件查询 -->
	<select id="queryOrderList" parameterType="com.xin.dealcenter.entity.Order"
		resultMap="BaseResultMap">
		select
		<include refid="Base_Column_List" />
		from order
		<where>
			<if test="id != null">
				id = #{id,jdbcType=BIGINT}
			</if>
			<if test="orderNo  != null">
				AND order_no = #{orderNo ,jdbcType=VARCHAR}
			</if>
			<if test="uid  != null">
				AND uid = #{uid ,jdbcType=BIGINT}
			</if>
			<if test="source  != null">
				AND source = #{source ,jdbcType=VARCHAR}
			</if>
			<if test="productId  != null">
				AND product_id = #{productId ,jdbcType=BIGINT}
			</if>
			<if test="productName  != null">
				AND product_name = #{productName ,jdbcType=VARCHAR}
			</if>
			<if test="unitPrice  != null">
				AND unit_price = #{unitPrice ,jdbcType=INTEGER}
			</if>
			<if test="number  != null">
				AND number = #{number ,jdbcType=INTEGER}
			</if>
			<if test="sellingPrice  != null">
				AND selling_price = #{sellingPrice ,jdbcType=INTEGER}
			</if>
			<if test="state  != null">
				AND state = #{state ,jdbcType=INTEGER}
			</if>
			<if test="createTime  != null">
				AND create_time = #{createTime ,jdbcType=TIMESTAMP}
			</if>
			<if test="updateTime  != null">
				AND update_time = #{updateTime ,jdbcType=TIMESTAMP}
			</if>
		</where>
	</select>
</mapper>
```
# 生成的SERVICE
``` java
/**
 * @filename:OrderService 2018年7月5日
 * @project deal-center  V1.0
 * Copyright(c) 2018 BianP Co. Ltd. 
 * All right reserved. 
 */
package com.xin.dealcenter.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.item.util.AppPage;
import com.xin.dealcenter.entity.Order;
/**   
 *  
 * @Description:  订单——SERVICE
 * @Author:       BianP   
 * @CreateDate:   2018年7月5日
 * @Version:      V1.0
 *    
 */
public interface OrderService {
	
	/**
	 * @explain 查询订单对象
	 * @param   对象参数：id
	 * @return  Order
	 * @author  BianP
	 */
	public Order selectByPrimaryKey(Long id);
	
	/**
	 * @explain 删除订单对象
	 * @param   对象参数：id
	 * @return  int
	 * @author  BianP
	 */
	public int deleteByPrimaryKey(Long id);
	
	/**
	 * @explain 添加订单对象
	 * @param   对象参数：Order
	 * @return  int
	 * @author  BianP
	 */
	public int insertSelective(Order order);
	
	/**
	 * @explain 修改订单对象
	 * @param   对象参数：Order
	 * @return  int
	 * @author  BianP
	 */
	public int updateByPrimaryKeySelective(Order order);
	
	/**
	 * @explain 查询订单集合
	 * @param   对象参数：Order
	 * @return  List<Order>
	 * @author  BianP
	 */
	public List<Order> queryOrderList(Order order);
	
	/**
	 * @explain 分页查询订单
	 * @param   对象参数：Order
	 * @return  PageInfo<Order>
	 * @author  BianP
	 */
	public PageInfo<Order> getOrderBySearch(AppPage<Order> page);
}
```
# 生成的SERVICE_IMPL
``` java
/**
 * @filename:OrderServiceImpl 2018年7月5日
 * @project deal-center  V1.0
 * Copyright(c) 2018 BianP Co. Ltd. 
 * All right reserved. 
 */
package com.xin.dealcenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.item.util.AppPage;
import com.xin.dealcenter.entity.Order;
import com.xin.dealcenter.dao.OrderDao;
import com.xin.dealcenter.service.OrderService;

/**   
 *  
 * @Description:  订单——SERVICEIMPL
 * @Author:       BianP   
 * @CreateDate:   2018年7月5日
 * @Version:      V1.0
 *    
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	public OrderDao orderDao;
	
	//查询对象
	@Override
	public Order selectByPrimaryKey(Long id) {
		return orderDao.selectByPrimaryKey(id);
	}
	
	//删除对象
	@Override
	public int deleteByPrimaryKey(Long id) {
		return orderDao.deleteByPrimaryKey(id);
	}
	
	//添加对象
	@Override
	public int insertSelective(Order order) {
		return orderDao.insertSelective(order);
	}
	
	//修改对象
	@Override
	public int updateByPrimaryKeySelective(Order order) {
		return orderDao.updateByPrimaryKeySelective(order);
	}
	
	//查询集合
	@Override
	public List<Order> queryOrderList(Order order) {
		return orderDao.queryOrderList(order);
	}
	
	//分页查询
	@Override
	public PageInfo<Order> getOrderBySearch(AppPage<Order> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(),page.getPageSize());
		List<Order> list=orderDao.queryOrderList(page.getParam());
		PageInfo<Order> pageInfo = new PageInfo<Order>(list);
		return pageInfo;
	}
}
```
# 生成的CONTROLLER
``` java
/**
 * @filename:OrderController 2018年7月5日
 * @project deal-center  V1.0
 * Copyright(c) 2018 BianP Co. Ltd. 
 * All right reserved. 
 */
package com.xin.dealcenter.webApi;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.item.util.AppPage;
import com.item.util.JsonResult;
import com.xin.dealcenter.entity.Order;
import com.xin.dealcenter.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**   
 * 
 * @Description:  订单接口层
 * @Author:       BianP   
 * @CreateDate:   2018年7月5日
 * @Version:      V1.0
 *    
 */
@Api(description = "订单",value="订单" )
@RestController
@RequestMapping("/order")
public class OrderController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public OrderService orderServiceImpl;
	
	/**
	 * @explain 查询订单对象  <swagger GET请求>
	 * @param   对象参数：id
	 * @return  order
	 * @author  BianP
	 * @time    2018年7月5日
	 */
	@GetMapping("/getOrderById/{id}")
	@ApiOperation(value = "获取订单信息", notes = "获取订单信息[order]，作者：BianP")
	@ApiImplicitParam(paramType="path", name = "id", value = "订单id", required = true, dataType = "Long")
	public JsonResult getOrderById(@PathVariable("id")Long id){
		JsonResult result=new JsonResult();
		try {
			Order order=orderServiceImpl.selectByPrimaryKey(id);
			if (order!=null) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(order);
			} else {
				logger.error("获取订单失败ID："+id);
				result.setCode(-1);
				result.setMessage("你获取的订单不存在");
			}
		} catch (Exception e) {
			logger.error("获取订单执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 添加订单对象
	 * @param   对象参数：order
	 * @return  int
	 * @author  BianP
	 * @time    2018年7月5日
	 */
	@PostMapping("/insertSelective")
	@ApiOperation(value = "添加订单", notes = "添加订单[order],作者：BianP")
	public JsonResult insertSelective(Order order){
		JsonResult result=new JsonResult();
		try {
			int rg=orderServiceImpl.insertSelective(order);
			if (rg>0) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(order);
			} else {
				logger.error("添加订单执行失败："+order.toString());
				result.setCode(-1);
				result.setMessage("执行失败，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("添加订单执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 删除订单对象
	 * @param   对象参数：id
	 * @return  int
	 * @author  BianP
	 * @time    2018年7月5日
	 */
	@PostMapping("/deleteByPrimaryKey")
	@ApiOperation(value = "删除订单", notes = "删除订单,作者：BianP")
	@ApiImplicitParam(paramType="query", name = "id", value = "订单id", required = true, dataType = "Long")
	public JsonResult deleteByPrimaryKey(Long id){
		JsonResult result=new JsonResult();
		try {
			int reg=orderServiceImpl.deleteByPrimaryKey(id);
			if (reg>0) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(id);
			} else {
				logger.error("删除订单失败ID："+id);
				result.setCode(-1);
				result.setMessage("执行错误，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("删除订单执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 修改订单对象
	 * @param   对象参数：order
	 * @return  order
	 * @author  BianP
	 * @time    2018年7月5日
	 */
	@ApiOperation(value = "修改订单", notes = "修改订单[order],作者：BianP")
	@PostMapping("/updateByPrimaryKeySelective")
	public JsonResult updateByPrimaryKeySelective(Order order){
		JsonResult result=new JsonResult();
		try {
			int reg = orderServiceImpl.updateByPrimaryKeySelective(order);
			if (reg>0) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(order);
			} else {
				logger.error("修改订单失败ID："+order.toString());
				result.setCode(-1);
				result.setMessage("执行错误，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("修改订单执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 获取匹配订单
	 * @param   对象参数：order
	 * @return  List<Order>
	 * @author  BianP
	 * @time    2018年7月5日
	 */
	@ApiOperation(value = "条件查询订单", notes = "条件查询[order],作者：BianP")
	@PostMapping("/queryOrderList")
	public JsonResult queryOrderList(Order order){
		JsonResult result=new JsonResult();
		try {
			List<Order> list = orderServiceImpl.queryOrderList(order);
			result.setCode(1);
			result.setMessage("成功");
			result.setData(list);
		} catch (Exception e) {
			logger.error("获取订单执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 分页条件查询订单   
	 * @param   对象参数：AppPage<Order>
	 * @return  PageInfo<Order>
	 * @author  BianP
	 * @time    2018年7月5日
	 */
	@GetMapping("/getPageOrder")
	@ApiOperation(value = "分页查询", notes = "分页查询返回对象[PageInfo<Order>],作者：边鹏")
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "pageNum", value = "当前页", required = true, dataType = "int"),
        @ApiImplicitParam(paramType="query", name = "pageSize", value = "页行数", required = true, dataType = "int")
    })
	public JsonResult getOrderBySearch(Integer pageNum,Integer pageSize){
		JsonResult result=new JsonResult();
		AppPage<Order> page =new AppPage<Order>();
		page.setPageNum(pageNum);
		page.setPageSize(pageSize);
		//其他参数
		Order order=new Order();
		page.setParam(order);
		//分页数据
		try {
			PageInfo<Order> pageInfo = orderServiceImpl.getOrderBySearch(page);
			result.setCode(1);
			result.setMessage("成功");
			result.setData(pageInfo);
		} catch (Exception e) {
			logger.error("分页查询订单执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
}
```

看到这里，大家应该能看出，这个代码生成只适合一些特定的项目，首先是springboot，其次是使用的mybatis和pagehelper，并使用了swagger与lombok。
