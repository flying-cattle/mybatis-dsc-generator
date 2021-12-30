package ${serviceUrl};

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.item.util.AppPage;
import ${entityUrl}.${entityName};

/**
 * ${entityComment}
 */
public interface ${entityName}Service {

	//根据id查询
	public ${entityName} selectByPrimaryKey(${idType} id);

	//根据id删除
	public int deleteByPrimaryKey(${idType} id);

	//新增
	public int insertSelective(${entityName} ${objectName});

	//修改
	public int updateByPrimaryKeySelective(${entityName} ${objectName});

	//条件查询
	public List<${entityName}> query${entityName}List(${entityName} ${objectName});

	//分页查询
	public PageInfo<${entityName}> get${entityName}BySearch(AppPage<${entityName}> page);
}