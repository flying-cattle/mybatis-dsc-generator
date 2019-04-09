/**   
 * Copyright © 2019 dream horse Info. Tech Ltd. All rights reserved.
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * @Package: com.github.mybatis.fl.convert
 * @author: flying-cattle  
 * @date: 2019年4月9日 下午8:06:16 
 */
package com.github.mybatis.fl.convert;

/**   
* Copyright: Copyright (c) 2019 
* 
* @ClassName: ITypeConvert.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: flying-cattle
* @date: 2019年4月9日 下午8:06:16 
*
* Modification History:
* Date         		Author          Version          Description
*---------------------------------------------------------------*
* 2019年4月9日      		flying-cattle        v2.0.1           initialize
*/
public interface ITypeConvert {
	/**
     * @Description: 执行类型转换
     *
     * @param globalConfig 全局配置
     * @param fieldType    字段类型
     * @return ignore
     */
    IColumnType processTypeConvert(DateType dateType , String fieldType);
}
