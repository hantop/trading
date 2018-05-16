package com.jinhui.zlrt.common;

import java.math.BigDecimal;

/**
 * 常量
 *
 * create by wsc 2017-05-22 20:02
 **/
public class ChnCodeDirEnum {

    //渠道代码_渠道文件上传文件夹
    public static enum ChnDirectory {
        PURCHASE("1018", "imiqian"),     //爱蜜钱
        REDEEM("9910", "xwbank");   //新网银行

        private String chnCode;
        private String directory;

        ChnDirectory(String chnCode, String directory) {
            this.chnCode = chnCode;
            this.directory = directory;
        }

        public static String getDirectory(String code) {
            for (ChnDirectory chn : ChnDirectory.values()) {
                if (chn.getChnCode().equals(code)) {
                    return chn.getDirectory();
                }
            }
            return null;
        }

        public String getChnCode() {
            return chnCode;
        }

        public String getDirectory() {
            return directory;
        }
    }

}
