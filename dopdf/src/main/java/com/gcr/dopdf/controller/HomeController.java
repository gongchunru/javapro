package com.gcr.dopdf.controller;

import com.gcr.dopdf.config.GlobalConfig;
import com.gcr.dopdf.services.BusinessPdfView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gongchunru
 * Date：2017/9/27.
 * Time：16:02
 */
@Controller
@RequestMapping(value = "")
public class HomeController {
    @RequestMapping(value = "")
    public String index(ModelMap globalModel){
        globalModel.put("mobile", GlobalConfig.readProperty("form.mobile"));
        globalModel.put("email", GlobalConfig.readProperty("form.email"));
        globalModel.put("name", GlobalConfig.readProperty("form.name"));
        globalModel.put("mode", "html");
        return "simpleForm";
    }

    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public ModelAndView downloadSample(){
        Map<String, Object> globalModel = new HashMap<>();
        globalModel.put("status",true);
        globalModel.put("code", "data");
        globalModel.put("message","data");
        return new ModelAndView("simplePDF",globalModel);
    }


    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ModelAndView downLoadForm(){
        Map<String,Object> globalModel = new HashMap<>();

        globalModel.put("mobile", GlobalConfig.readProperty("form.mobile"));
        globalModel.put("email", GlobalConfig.readProperty("form.email"));
        globalModel.put("name", GlobalConfig.readProperty("form.name"));
        globalModel.put("mode", "pdf");

        return new ModelAndView("simpleFormPDF",globalModel);
    }

    @RequestMapping("/app.pdf")
    public ModelAndView pdf(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        BusinessPdfView view = new BusinessPdfView();
        view.setAttributesMap(map);
        return new ModelAndView(view);
    }


}
