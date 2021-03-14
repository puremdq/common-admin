package ${servicePackage}.impl;

import ${servicePackage}.I${serviceName};
import ${entityFullName};
<#if StringUtils.isNotBlank(baseImplServiceFullName)>
    import ${baseImplServiceFullName};
    import ${mapperFullName};
</#if>

import org.springframework.stereotype.Service;

@Service
public class ${serviceName}Impl<#if StringUtils.isNotBlank(baseServiceFullName)> extends ${StringUtils.substringAfterLast(baseImplServiceFullName,".")}<${StringUtils.substringAfterLast(entityFullName,".")},${StringUtils.substringAfterLast(mapperFullName,".")}></#if> implements I${serviceName}{


}
