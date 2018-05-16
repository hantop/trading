package com.jinhui.zlrt.controller;

import com.jinhui.zlrt.service.GenerateApplyFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @autor wsc
 * @create 2018-02-11 9:03
 **/
@Controller
@RequestMapping("generateFile")
public class GenerateFileController {

    @Autowired
    private GenerateApplyFileService generateApplyFileService;


    @RequestMapping(value="/generateAllFiles",method = RequestMethod.GET)
    @ResponseBody
    public void syncProduct(){
        generateApplyFileService.generateAllFiles();

    }
}
