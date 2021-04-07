<#if tableInfoList??>
    <#list tableInfoList as tableInfo>
### 表${tableInfo.tableName}(${tableInfo.tableRemarks})
字段|类型|大小|是否可为空|默认值|备注
:---:|:---:|:---:|:---:|:---:|:---:
<#list tableInfo.currentTableInfoList as columnMap>
    ${columnMap.col}|${columnMap.databaseType}|${columnMap.columnSize}|${columnMap.nullAble}|${columnMap.colDef}|${columnMap.remarks}
</#list>

    </#list>
</#if>

