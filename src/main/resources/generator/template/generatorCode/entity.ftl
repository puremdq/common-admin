<#assign idNum=0/>
<#assign idType="INPUT"/>
<#list columnList as columnMap>
    <#if columnMap.isId=='true'>
        <#assign idNum=idNum+1/>
    </#if>
</#list>
package ${entityPackage};

<#if StringUtils.isNotBlank(baseEntityFullName)>
    import ${baseEntityFullName};
</#if>
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
<#if (idNum>0)>
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.IdType;
</#if>

@EqualsAndHashCode(callSuper=true)
@Data
@TableName("${tableName}")
public class ${entityName} <#if StringUtils.isNotBlank(baseEntityFullName)>extends ${StringUtils.substringAfterLast(baseEntityFullName,".")}<${entityName}></#if> {

private static final long serialVersionUID = 1L;

public ${entityName}() {
}
<#if (idNum>0)>
    <#assign idAndTypeStrList><#list columnList as columnMap> <#if columnMap.isId=='true'>${columnMap.javaType} ${StringUtils.underlineToCamelCase(columnMap.col)},</#if></#list></#assign>
    <#assign idAndTypeStrList="${StringUtils.trimToEmpty(idAndTypeStrList)}"/>
    <#assign constructorStr>
        <#list columnList as columnMap>
            <#if columnMap.isId=='true'>
                this.${StringUtils.underlineToCamelCase(columnMap.col)}=${StringUtils.underlineToCamelCase(columnMap.col)};
            </#if>
        </#list>
    </#assign>
    <#assign constructorStr="${StringUtils.trimToEmpty(constructorStr)}"/>

    public ${entityName}(${idAndTypeStrList?substring(0,(idAndTypeStrList?length)-1)}) {
    ${StringUtils.trimToEmpty(constructorStr)}
    }
</#if>

<#list columnList as columnMap>
    <#if (!existFieldList.contains(StringUtils.underlineToCamelCase(columnMap.col)))>
        /**
        * ${columnMap.remarks}
        * 表字段： ${tableName}.${columnMap.col}
        */
        <#if columnMap.isId=='true'>
            <#if (idNum==1)>
                <#if (columnMap.javaType=='Integer'||columnMap.javaType=='Long')>
                    <#assign idType="AUTO"/>
                <#else>
                    <#assign idType="UUID"/>
                </#if>
            </#if>
            @TableId(value = "${columnMap.col}", type = IdType.${idType})
        <#else>
            @TableField(value = "${columnMap.col}")
        </#if>
        private ${columnMap.javaType} ${StringUtils.underlineToCamelCase(columnMap.col)};
    </#if>
</#list>

}
