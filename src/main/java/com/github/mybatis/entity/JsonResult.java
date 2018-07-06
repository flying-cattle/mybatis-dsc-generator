package com.github.mybatis.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult implements Serializable{
	
	private static final long serialVersionUID = 123126L;
	/**
     * @Description: 状态码（大于0成功，小于0失败）
     */
	private Integer code;
	/**
     * @Description: 消息说明
     */
	private String message;
	/**
     * @Description: 返回对象
     */
	private Object data;
}
