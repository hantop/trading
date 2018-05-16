package com.jinhui.api.constants;

import com.jinhui.api.mapper.trade.ProductDao;
import com.jinhui.common.exception.BizException;
import com.jinhui.common.utils.SpringContextUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 证联支付分配给交易后台的机构代码(商户号)
 * <p>
 * Created by Administrator on 2018/2/1 0001.
 */
public enum ZlrtInstCode {

    JINHUI("金汇交易平台", "B00000603");//平台商户号


    private String name;
    private String code;

    ZlrtInstCode(String name, String code) {
        this.name = name;
        this.code = code;
    }

    /**
     *  根据产品代码查询对应的交易所的商户号
     */
    public static String  getZlrtInstCodeByProduct(String productNo){

        ProductDao productDao = SpringContextUtils.getBean("productDao", ProductDao.class);
        String instCode = productDao.selectZlrtInstCode(productNo);
        if(StringUtils.isBlank(instCode)){
            throw new BizException("结算商户号不能为空");
        }
        return instCode;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
