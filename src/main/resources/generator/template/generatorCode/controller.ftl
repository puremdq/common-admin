<#assign serviceClassName="${StringUtils.substringAfterLast(serviceFullName,'.')}"/>
<#assign serviceName="${StringUtils.deleteFirstChar(serviceClassName)?uncap_first}"/>
package ${controllerPackage};
import ${serviceFullName};
import ${entityFullName};
<#if StringUtils.isNotBlank(baseControllerFullName)>
    import ${baseControllerFullName};
</#if>
import com.aojiaoo.common.response.ServerResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/${entityName?uncap_first}")
public class ${controllerName} <#if StringUtils.isNotBlank(baseControllerFullName)>extends ${StringUtils.substringAfterLast(baseControllerFullName,".")}<#--<${StringUtils.substringAfterLast(serviceFullName,".")}>--></#if> {
@Autowired
private ${serviceClassName} ${serviceName};

@RequestMapping("")
public ServerResponse
<Page${r'<'}${entityName}>> list(Page<${entityName}> page, ${entityName} ${entityName?uncap_first}) {
    ${serviceName}.findPage(page, ${entityName?uncap_first});
    return ServerResponse.createSuccessWithDta(page);
    }

    @RequestMapping("form")
    public ServerResponse<${entityName}> edit(${entityName} ${entityName?uncap_first}) {
    if (${entityName?uncap_first}.getId() != null) {
    ${entityName?uncap_first} = ${serviceName}.get(${entityName?uncap_first}.getId());
    }

    return ServerResponse.createSuccessWithDta(${entityName?uncap_first});
    }

    @RequestMapping("delete")
    public ServerResponse delete(Long id) {
    this.${serviceName}.delete(id);
    return ServerResponse.createSuccess();
    }

    @RequestMapping("save")
    public ServerResponse save(${entityName} ${entityName?uncap_first}) {
    ${serviceName}.save(${entityName?uncap_first});
    return ServerResponse.createSuccess();
    }

    }
