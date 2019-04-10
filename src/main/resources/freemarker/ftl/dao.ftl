/**
 * @filename:${entityName}Dao ${createTime}
 * @project ${project}  ${version}
 * Copyright(c) 2018 ${author} Co. Ltd. 
 * All right reserved. 
 */
package ${daoUrl};

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import ${entityUrl}.${entityName};

/**   
 * Copyright: Copyright (c) 2019 
 * 
 * <p>说明： ${entityComment}数据访问层</P>
 * @version: ${version}
 * @author: ${author}
 * 
 * Modification History:
 * Date         	Author          Version          Description
 *---------------------------------------------------------------*
 * ${createTime}      ${author}    ${version}         initialize
 */
@Mapper
public interface ${entityName}Dao extends BaseMapper<${entityName}> {
	
}
	