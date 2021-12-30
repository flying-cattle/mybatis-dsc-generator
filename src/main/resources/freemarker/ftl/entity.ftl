package ${entityUrl};

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * ${entityComment}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ${entityName} implements Serializable {

	private static final long serialVersionUID = ${agile}L;

<#list cis as ci>
	<#if ci.javaType=="Date">
	<#if ci.jdbcType=="date">
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    <#elseif ci.jdbcType=="time">
    @DateTimeFormat(pattern = "HH:mm:ss")
	@JsonFormat(pattern="HH:mm:ss", timezone = "GMT+8")
	<#else>
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	</#if>
	</#if>
	@ApiModelProperty(name = "${ci.property}", value = "${ci.comment}")
	private ${ci.javaType} ${ci.property};
</#list>
}
	