<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${daoUrl}.${entityName}Dao">
	<resultMap id="BaseResultMap" type="${entityUrl}.${entityName}">
	<#list cis as ci>
	<id column="${ci.column}" jdbcType="${ci.jdbcType?upper_case}" property="${ci.property}" />
	</#list>
	</resultMap>
	<sql id="Base_Column_List">
	${agile}
	</sql>
	<!-- 查询 -->
	<select id="selectByPrimaryKey" parameterType="java.lang.${idType}"
		resultMap="BaseResultMap">
		select
		<include refid="Base_Column_List" />
		from ${table}
		where id = ${r'#{'}id,jdbcType=${idJdbcType?upper_case}}
	</select>
	<!-- 删除 -->
	<delete id="deleteByPrimaryKey" parameterType="java.lang.${idType}">
		delete from ${table}
		where id = ${r'#{'}id,jdbcType=${idJdbcType?upper_case}}
	</delete>
	<!-- 选择添加 -->
	<insert id="insertSelective" parameterType="${entityUrl}.${entityName}">
		<selectKey keyProperty="id" order="AFTER" resultType="java.lang.${idType}">
			SELECT
			LAST_INSERT_ID()
		</selectKey>
		insert into ${table}
		<trim prefix="(" suffix=")" suffixOverrides=",">
			<#list cis as ci>
			<if test="${ci.property} != null">
				${ci.column},
			</if>
			</#list>
		</trim>
		<trim prefix="values (" suffix=")" suffixOverrides=",">
			<#list cis as ci>
			<if test="${ci.property} != null">
				${r'#{'}${ci.property},jdbcType=${ci.jdbcType?upper_case}},
			</if>
			</#list>
		</trim>
	</insert>
	<!-- 选择修改 -->
	<update id="updateByPrimaryKeySelective" parameterType="${entityUrl}.${entityName}">
		update ${table}
		<set>
			<#list cis as ci>
			<if test="${ci.property} != null">
				${ci.column} = ${r'#{'}${ci.property},jdbcType=${ci.jdbcType?upper_case}},
			</if>
			</#list>
		</set>
		where id = ${r'#{'}id,jdbcType=${idJdbcType}}
	</update>
	<!-- 组合条件查询 -->
	<select id="query${entityName}List" parameterType="${entityUrl}.${entityName}"
		resultMap="BaseResultMap">
		select
		<include refid="Base_Column_List" />
		from ${table}
		<where>
			<if test="id != null">
				id = ${r'#{'}id,jdbcType=${idJdbcType?upper_case}}
			</if>
			<#list cis as ci>
			<#if ci.column!="id">
			<if test="${ci.property}  != null">
				AND ${ci.column} = ${r'#{'}${ci.property} ,jdbcType=${ci.jdbcType?upper_case}}
			</if>
			</#if>
			</#list>
		</where>
	</select>
</mapper>