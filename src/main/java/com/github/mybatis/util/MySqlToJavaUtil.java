package com.github.mybatis.util;

public class MySqlToJavaUtil {
	
	/**
	 * 
	 * @Title: firstTocapitalLetters 
	 * @Description: TODO(类名首先字母变大写) 
	 * @param table 
	 * @return 设定文件 
	 * @return String 返回类型 
	 * @author BianPeng 
	 * @date 2018年6月30日 
	 */
	public static String getClassName(String table) {
		table=changeToJavaFiled(table);
		StringBuilder sbuilder = new StringBuilder();
		char[] cs = table.toCharArray();
		cs[0] -= 32;
		sbuilder.append(String.valueOf(cs));
		return sbuilder.toString();
	}
	
	/**
	 * 
	 * @Title: changeToJavaFiled 
	 * @Description: TODO(将数据库中带下划线的字段转换为Java常用的驼峰字段) 
	 * @param field 
	 * @return 设定文件 
	 * @return String 返回类型 
	 * @author BianPeng 
	 * @date 2018年6月30日 
	 */
	public static String changeToJavaFiled(String field) {
		String[] fields = field.split("_");
		StringBuilder sbuilder = new StringBuilder(fields[0]);
		for (int i = 1; i < fields.length; i++) {
			char[] cs = fields[i].toCharArray();
			cs[0] -= 32;
			sbuilder.append(String.valueOf(cs));
		}
		return sbuilder.toString();
	}
	
	/**
	 * 
	 * @Title: sqlTypeToJavaType 
	 * @Description: TODO(功能：感觉数据类型获得Java的数据类型) 
	 * @param sqlType
	 * @return javaType
	 * @return String 返回类型 
	 * @author BianPeng 
	 * @date 2018年6月30日 
	 */
	public static String jdbcTypeToJavaType(String sqlType) {
		if (sqlType.equalsIgnoreCase("bit")) {
			return "Boolean";
		} else if (sqlType.equalsIgnoreCase("tinyint")) {
			return "Integer";
		} else if (sqlType.equalsIgnoreCase("smallint")) {
			return "Integer";
		} else if (sqlType.equalsIgnoreCase("int")) {
			return "Integer";
		} else if (sqlType.equalsIgnoreCase("bigint")) {
			return "Long";
		} else if (sqlType.equalsIgnoreCase("float")) {
			return "Float";
		} else if (sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric") || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money") || sqlType.equalsIgnoreCase("smallmoney")) {
			return "Double";
		} else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char") || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar") || sqlType.equalsIgnoreCase("text")) {
			return "String";
		} else if (sqlType.equalsIgnoreCase("datetime") || sqlType.equalsIgnoreCase("date") || sqlType.equalsIgnoreCase("timestamp")) {
			return "Date";
		} else if (sqlType.equalsIgnoreCase("image")) {
			return "Blod";
		}
		return null;
	}
}
