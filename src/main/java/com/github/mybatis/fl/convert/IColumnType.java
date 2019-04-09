/**   
 * Copyright © 2019 dream horse Info. Tech Ltd. All rights reserved.
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * @Package: com.github.mybatis.fl.convert
 * @author: flying-cattle 
 * @date: 2019年4月9日 下午8:09:35 
 */
package com.github.mybatis.fl.convert;

/**   
* Copyright: Copyright (c) 2019 
* 
* @ClassName: IColumnType.java
* @Description: 获取实体类字段属性类信息接口
*
* @version: v1.0.0
* @author: flying-cattle
* @date: 2019年4月9日 下午8:09:35 
*
* Modification History:
* Date         		Author          Version          Description
*---------------------------------------------------------------*
* 2019年4月9日      		flying-cattle   v2.0.1           initialize
*/
public interface IColumnType {
	/**
     * @Description: 获取字段类型
     *
     * @return 字段类型
     */
    String getType();

    /**
     * @Description: 获取字段类型完整名
     *
     * @return 字段类型完整名
     */
    String getPkg();
}
