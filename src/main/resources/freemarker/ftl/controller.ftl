/**
 * @filename:${entityName}Controller ${createTime}
 * @project ${project}  ${version}
 * Copyright(c) 2018 ${author} Co. Ltd. 
 * All right reserved. 
 */
package ${controllerUrl};



import com.item.util.JsonResult;
import ${entityUrl}.${entityName};
import ${serviceUrl}.${entityName}Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**   
 * Copyright: Copyright (c) 2019 
 * 
 * <p>说明： ${entityComment}API接口层</P>
 * @version: ${version}
 * @author: ${author}
 * 
 * Modification History:
 * Date         	Author          Version          Description
 *---------------------------------------------------------------*
 * ${createTime}      ${author}    ${version}           initialize
 */
@Api(description = "${entityComment}",value="${entityComment}" )
@RestController
@RequestMapping("/${objectName}")
public class ${entityName}Controller {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public ${entityName}Service ${objectName}ServiceImpl;
	
	/**
	 * @explain 查询${entityComment}对象  <swagger GET请求>
	 * @param   对象参数：id
	 * @return  ${objectName}
	 * @author  ${author}
	 * @time    ${createTime}
	 */
	@GetMapping("/get${entityName}ById/{id}")
	@ApiOperation(value = "获取${entityComment}信息", notes = "获取${entityComment}信息[${objectName}]，作者：${author}")
	@ApiImplicitParam(paramType="path", name = "id", value = "${entityComment}id", required = true, dataType = "${idType}")
	public JsonResult<${entityName}> get${entityName}ById(@PathVariable("id")${idType} id){
		JsonResult<${entityName}> result=new JsonResult<${entityName}>();
		try {
			${entityName} ${objectName}=${objectName}ServiceImpl.getById(id);
			if (${objectName}!=null) {
				result.setType("success");
				result.setMessage("成功");
				result.setData(${objectName});
			} else {
				logger.error("获取${entityComment}失败ID："+id);
				result.setType("fail");
				result.setMessage("你获取的${entityComment}不存在");
			}
		} catch (Exception e) {
			logger.error("获取${entityComment}执行异常："+e.getMessage());
			result=new JsonResult<${entityName}>(e);
		}
		return result;
	}
	
	/**
	 * @explain 添加或者更新${entityComment}对象
	 * @param   对象参数：${objectName}
	 * @return  int
	 * @author  ${author}
	 * @time    ${createTime}
	 */
	@PostMapping("/insertSelective")
	@ApiOperation(value = "添加${entityComment}", notes = "添加${entityComment}[${objectName}],作者：${author}")
	public JsonResult<${entityName}> insertSelective(${entityName} ${objectName}){
		JsonResult<${entityName}> result=new JsonResult<${entityName}>();
		try {
			boolean rg=${objectName}ServiceImpl.saveOrUpdate(${objectName});
			if (rg) {
				result.setType("success");
				result.setMessage("成功");
				result.setData(${objectName});
			} else {
				logger.error("添加${entityComment}执行失败："+${objectName}.toString());
				result.setType("fail");
				result.setMessage("执行失败，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("添加${entityComment}执行异常："+e.getMessage());
			result=new JsonResult<${entityName}>(e);
		}
		return result;
	}
	
	/**
	 * @explain 删除${entityComment}对象
	 * @param   对象参数：id
	 * @return  int
	 * @author  ${author}
	 * @time    ${createTime}
	 */
	@PostMapping("/deleteByPrimaryKey")
	@ApiOperation(value = "删除${entityComment}", notes = "删除${entityComment},作者：${author}")
	@ApiImplicitParam(paramType="query", name = "id", value = "${entityComment}id", required = true, dataType = "${idType}")
	public JsonResult<Object> deleteByPrimaryKey(${idType} id){
		JsonResult<Object> result=new JsonResult<Object>();
		try {
			boolean reg=${objectName}ServiceImpl.removeById(id);
			if (reg) {
				result.setType("success");
				result.setMessage("成功");
				result.setData(id);
			} else {
				logger.error("删除${entityComment}失败ID："+id);
				result.setType("fail");
				result.setMessage("执行错误，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("删除${entityComment}执行异常："+e.getMessage());
			result=new JsonResult<Object>(e);
		}
		return result;
	}
	
	/**
	 * @explain 分页条件查询${entityComment}   
	 * @param   对象参数：AppPage<${entityName}>
	 * @return  PageInfo<${entityName}>
	 * @author  ${author}
	 * @time    ${createTime}
	 */
	@GetMapping("/get${entityName}Pages")
	@ApiOperation(value = "分页查询", notes = "分页查询返回对象[IPage<${entityName}>],作者：边鹏")
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "pageNum", value = "当前页", required = true, dataType = "int"),
        @ApiImplicitParam(paramType="query", name = "pageSize", value = "页行数", required = true, dataType = "int")
    })
	public JsonResult<IPage<${entityName}>> get${entityName}Pages(Integer pageNum,Integer pageSize){
	
		JsonResult<IPage<${entityName}>> result=new JsonResult<IPage<${entityName}>>();
		Page<${entityName}> page=new Page<${entityName}>(pageNum,pageSize);
		QueryWrapper<${entityName}> queryWrapper =new QueryWrapper<${entityName}>();
		//分页数据
		try {
			IPage<${entityName}> pageInfo=${objectName}ServiceImpl.page(page, queryWrapper);
			result.setType("success");
			result.setMessage("成功");
			result.setData(pageInfo);
		} catch (Exception e) {
			logger.error("分页查询${entityComment}执行异常："+e.getMessage());
			result=new JsonResult<IPage<${entityName}>>(e);
		}
		return result;
	}
}