package com.jinhui.zlrt.common;

import com.jinhui.zlrt.service.impl.GenerateApplyFileServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContext;

/**
 * Created by wsc on 2017/05/21
 */
@Component
public class AccountFileConstants {
    private static Logger logger = LoggerFactory.getLogger(AccountFileConstants.class);
    private static String root = RequestContext.class.getResource("/").getFile();

    public static final String INDEXFILE_STARTFLAG = "OFDCFIDX";
    public static final String FILE_ENDFLAG = "OFDCFEND";
    public static final String FILE_VERSION = "20";
    public static final String FILE_TA = "JFB666";
    public static final String HEADERFILEPATH_01 = root + "file/OFD_1018_JFB666_01_header.TXT";  //账户申请文件头
    public static final String HEADERFILEPATH_03 = root + "file/OFD_1018_JFB666_03_header.TXT";  //交易申请文件头
    public static final String HEADERFILEPATH_INDEX = root +  "file/OFI_1018_JFB666_header.TXT";  //索引文件

    public static String OUT_FILE_DIRECTORY;  //生成的申请文件目录

    public static final String OUT_DOWNLOAD = "download";

    @Value("${OUT_FILE_DIRECTORY}")
    public void setOutFileDirectory(String outFileDirectory) {
        OUT_FILE_DIRECTORY = outFileDirectory;
    }

    public String test(){
        logger.info(" dddd " + OUT_FILE_DIRECTORY);
        return null;
    }
}