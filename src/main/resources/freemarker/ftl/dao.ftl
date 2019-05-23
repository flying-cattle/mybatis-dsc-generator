/**
 * @filename:${entityName}Dao ${createTime}
 * @project ${project}  ${version}
 * Copyright(c) 2020 ${author} Co. Ltd. 
 * All right reserved. 
 */
package ${daoUrl};

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import ${entityUrl}.${entityName};

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： ${entityComment}数据访问层</p>
 * @version: ${version}
 * @author: ${author}
 * 
 */
@Mapper
public interface ${entityName}Dao extends BaseMapper<${entityName}> {
	
}
	