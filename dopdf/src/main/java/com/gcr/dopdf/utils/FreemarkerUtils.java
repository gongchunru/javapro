package com.gcr.dopdf.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * Created by gongchunru
 * Date：2017/9/27.
 * Time：16:17
 */
public class FreemarkerUtils {
    /**
     * 使用传入的Map对象，渲染指定的freemarker模板
     *
     * @param baseDir 根目录
     * @param fileName 文件名
     * @param globalMap 数据绑定
     * @return html字符串
     */
    public static String loadFtlHtml(File baseDir, String fileName, Map globalMap){
        if(baseDir == null || !baseDir.isDirectory() || globalMap ==null || fileName == null || "".equals(fileName)){
            throw new IllegalArgumentException("Directory file");
        }

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        try {
            cfg.setDirectoryForTemplateLoading(baseDir);
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);//.RETHROW
            cfg.setClassicCompatible(true);
            Template temp = cfg.getTemplate(fileName);

            StringWriter stringWriter = new StringWriter();
            temp.process(globalMap, stringWriter);

            return stringWriter.toString();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
            throw new RuntimeException("load fail file");
        }
    }

}
