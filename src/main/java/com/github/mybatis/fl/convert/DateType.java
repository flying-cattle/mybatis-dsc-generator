/**   
 * Copyright © 2019 dream horse Info. Tech Ltd. All rights reserved.
 * 
 * @Package: com.github.mybatis.fl.convert
 * @author: flying-cattle  
 * @date: 2019年4月9日 下午8:15:25 
 */
package com.github.mybatis.fl.convert;

/**   
* Copyright: Copyright (c) 2019 
* 
* @ClassName: DateType.java
* @Description: 数据库时间类型 到 实体类时间类型 对应策略
*
* @version: v1.0.0
* @author: flying-cattle
* @date: 2019年4月9日 下午8:13:13 
*
* Modification History:
* Date         		Author          Version          Description
*---------------------------------------------------------------*
* 2019年4月9日      		flying-cattle   v2.0.1           initialize
*/
public enum DateType {
    /**
     * @Description: 只使用 java.util.date 代替
     */
    ONLY_DATE,
    /**
     * @Description: 使用 java.sql 包下的
     */
    SQL_PACK,
    /**
     * @Description: 使用 java.time 包下的
     * <p>java8 新的时间类型</p>
     */
    TIME_PACK
}

