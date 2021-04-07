package com.aojiaoo.admin.gen;

import com.aojiaoo.common.utils.FileUtils;
import com.aojiaoo.common.utils.PropertiesUtil;
import com.aojiaoo.common.utils.ResourceUtil;
import com.aojiaoo.common.utils.StringUtils;
import com.aojiaoo.generator.util.DbInfoUtil;
import com.aojiaoo.generator.util.FreemakerUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang3.time.DateFormatUtils;

import javax.swing.filechooser.FileSystemView;
import java.io.FileWriter;
import java.util.*;

public class GeneratorDoc {

    public static void startGeneratorDoc() throws Exception {

        Properties generatorProperties = PropertiesUtil.getProperties("classpath:generator/generatorDoc.properties");
        Properties jdbcProperties = PropertiesUtil.getProperties("classpath:generator/jdbc.properties");
        Configuration cfg = getConfiguration(generatorProperties);
        String tables = generatorProperties.getProperty("generator.table");
        List<Map<String, Object>> tableInfoList = DbInfoUtil.getTableInfo(jdbcProperties, tables);
        Map<String, Object> templateMap = new HashMap<>();
        templateMap.put("tableInfoList", tableInfoList);
        String fileName = DateFormatUtils.format(new Date(), "yyyy-MM-dd") + "数据库文档.md";
        String filePath = FileUtils.getFilePathByClasspathOrSelf(generatorProperties.getProperty("generatorDoc.path"));
        filePath = StringUtils.isBlank(filePath) ? FileSystemView.getFileSystemView().getHomeDirectory().getPath() : filePath;
        Template template = cfg.getTemplate("databaseDoc.ftl");
        template.process(templateMap, new FileWriter(FileUtils.spliceFilePath(filePath, fileName)));
        System.out.println("生成文件到 " + FileUtils.spliceFilePath(filePath, fileName));

    }


    private static Configuration getConfiguration(Properties properties) {
        Configuration cfg = FreemakerUtil.getConfiguration();
        try {
            FreemakerUtil.setStaticPacker(cfg, "StringUtils", StringUtils.class.getName());
            cfg.setClassLoaderForTemplateLoading(ResourceUtil.getDefaultClassLoader(), ResourceUtil.deleteClassPathPrefix(properties.getProperty("generatorDoc.templatePath")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cfg;
    }

    public static void main(String[] args) throws Exception {
        startGeneratorDoc();
    }


}
