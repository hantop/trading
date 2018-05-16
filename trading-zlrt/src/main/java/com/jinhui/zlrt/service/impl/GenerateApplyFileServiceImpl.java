package com.jinhui.zlrt.service.impl;

import com.jinhui.common.service.HolidayService;
import com.jinhui.common.utils.DateUtils;
import com.jinhui.zlrt.common.AccountFileConstants;
import com.jinhui.zlrt.common.ChnCodeDirEnum;
import com.jinhui.zlrt.entity.domain.*;
import com.jinhui.zlrt.mapper.trade.BatchStateMapperTrade;
import com.jinhui.zlrt.mapper.trade.ChnInfoMapperTrade;
import com.jinhui.zlrt.mapper.trade.TradeConsignMapperTrade;
import com.jinhui.zlrt.mapper.trade.UserMapperTrade;
import com.jinhui.zlrt.service.GenerateApplyFileService;
import com.jinhui.zlrt.utils.ConvertorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * 生成申请文件（账户申请文件，交易申请文件）
 *
 * @autor wsc
 * @create 2018-02-09 14:37
 **/
@Service("generateApplyFileService")
public class GenerateApplyFileServiceImpl implements GenerateApplyFileService{
    private static Logger logger = LoggerFactory.getLogger(GenerateApplyFileServiceImpl.class);

    @Autowired
    private UserMapperTrade userMapperTrade;
    @Autowired
    private TradeConsignMapperTrade tradeConsignMapperTrade;
    @Autowired
    private ChnInfoMapperTrade chnInfoMapperTrade;
    @Autowired
    private BatchStateMapperTrade batchStateMapperTrade;
    @Autowired
    private HolidayService holidayService;

    /**
     * 生成所有渠道的所有文件
     * 每天15:30定时生成
     *
     */
    @Scheduled(cron="0 30 15 * * *")
    public void generateAllFiles() {
        BatchState batchState = batchStateMapperTrade.findNewest();

        boolean flag = holidayService.isWorkDay(DateUtils.getCurrentDate());
        //工作日才生成文件
        if(flag){
            List<ChnInfo> chnInfoList = chnInfoMapperTrade.selectAllChnInfoList();
            String batchDate = new SimpleDateFormat("yyyyMMdd").format(batchState.getDate());
            String preDate = holidayService.getPreWorkDay(batchDate);
            logger.info("preDate:  " + preDate + "      batchDate: " +  new SimpleDateFormat("yyyyMMdd").format(batchState.getDate()));
            for(ChnInfo chnInfo : chnInfoList){
                try {
                    generateIndexFile(chnInfo.getChnCode(),batchDate);
                    generateAccountApplyFile(chnInfo.getChnCode(),preDate,batchDate);
                    generateTradeApplyFile(chnInfo.getChnCode(),preDate,batchDate);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 生成索引文件
     * @param chnCode
     * @param applyDate
     * @throws IOException
     */
    public void generateIndexFile(String chnCode,String applyDate) throws IOException {
        logger.info("渠道文件生成根目录： " + AccountFileConstants.OUT_FILE_DIRECTORY);
        logger.info("----------------------- 生成索引文件开始 -----------------------");
        File file = ResourceUtils.getFile(AccountFileConstants.HEADERFILEPATH_INDEX);//账户索引文件头信息模板
        File outFile = ResourceUtils.getFile(AccountFileConstants.OUT_FILE_DIRECTORY + "/" +
                                       ChnCodeDirEnum.ChnDirectory.getDirectory(chnCode) + "/" +
                                       AccountFileConstants.OUT_DOWNLOAD + "/" + applyDate );
        if(!outFile.exists()){outFile.mkdirs();}
        FileOutputStream writerStream = new FileOutputStream(outFile  + "/" + "OFI_"+chnCode+"_JFB666_"+applyDate+".TXT");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(writerStream, "GBK"));
        StringBuilder result= new StringBuilder();
        try{
            result = generateHeader(file,chnCode,applyDate,result);
            writer.write(result.toString());
        }catch(Exception e){
            logger.info("账户索引文件生成出错了",e);
        }finally {
            writer.close();
            writerStream.close();
        }
        logger.info("----------------------- 生成索引文件结束 -----------------------");
    }

    /**
     * 生成账户申请文件
     * @param chnCode
     * @param applyDate
     * @throws IOException
     */
    public void generateAccountApplyFile(String chnCode,String preDate,String applyDate) throws IOException{
        logger.info("----------------------- 生成账户申请文件开始 -----------------------");
        File file = ResourceUtils.getFile(AccountFileConstants.HEADERFILEPATH_01);//账户申请文件头信息模板
        File outFile = ResourceUtils.getFile(AccountFileConstants.OUT_FILE_DIRECTORY + "/" +
                                        ChnCodeDirEnum.ChnDirectory.getDirectory(chnCode) + "/" +
                                        AccountFileConstants.OUT_DOWNLOAD + "/" + applyDate);
        if(!outFile.exists()){outFile.mkdirs();}
        FileOutputStream writerStream = new FileOutputStream(outFile + "/" + "OFD_"+chnCode+"_JFB666_"+applyDate+"_01.TXT");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(writerStream, "GBK"));
        StringBuilder result= new StringBuilder();
        try{
            result = generateHeader(file,chnCode,applyDate,result);
            result = generateAccountApplyRecords(chnCode,result,preDate,applyDate);
           // logger.info(result.toString());

            writer.write(result.toString());

        }catch(Exception e){
            logger.info("账户申请文件生成出错了",e);
        }finally {
            writer.close();
            writerStream.close();
        }
        logger.info("----------------------- 生成账户申请文件结束 -----------------------");
    }

    /**
     * 生成交易申请文件
     * @param chnCode
     * @param applyDate
     * @throws IOException
     */
    public void generateTradeApplyFile(String chnCode,String preDate,String applyDate) throws IOException{
        logger.info("----------------------- 生成交易申请文件开始 -----------------------");
        File file = ResourceUtils.getFile(AccountFileConstants.HEADERFILEPATH_03);//交易申请文件头信息模板
        File outFile = ResourceUtils.getFile(AccountFileConstants.OUT_FILE_DIRECTORY + "/" +
                                    ChnCodeDirEnum.ChnDirectory.getDirectory(chnCode) + "/" +
                                    AccountFileConstants.OUT_DOWNLOAD + "/" + applyDate);
        if(!outFile.exists()){outFile.mkdirs();}
        FileOutputStream writerStream = new FileOutputStream(outFile + "/" + "OFD_"+chnCode+"_JFB666_"+applyDate+"_03.TXT");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(writerStream, "GBK"));
        StringBuilder result = new StringBuilder();
        try{
            result = generateHeader(file,chnCode,applyDate,result);
            result = generateTradeApplyRecords(chnCode,result,preDate,applyDate);
          //  logger.info(result.toString());

            writer.write(result.toString());
        }catch(Exception e){
            logger.info("交易申请文件生成出错了",e);
        }finally {
            writer.close();
            writerStream.close();
        }
        logger.info("----------------------- 生成交易申请文件结束 -----------------------");
    }



    private StringBuilder generateHeader(File file,String chnCode,String applyDate,StringBuilder result) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = "";
        while((s = br.readLine())!=null){
            if(s.contains("#{applyDate}")) {
                s = s.replace("#{applyDate}",applyDate);
            }
            if(s.contains("#{chnCode}")) {
                s = s.replace("#{chnCode}",chnCode);
            }
            result.append(s + System.lineSeparator());
        }
        br.close();


        return result;
    }

    private StringBuilder generateAccountApplyRecords(String chnCode,StringBuilder result,String preDate,String applyDate) throws Exception {
        List<User> userList = userMapperTrade.selectConfirmUserList(chnCode,preDate,applyDate);
        logger.info("账户申请记录数： " + userList.size());
        result.append(String.format("%08d",userList.size()) + System.lineSeparator());//记录数
        String[] keys = new String[]{"","ApplyNo","IdType","IdNo","Name","TransDate","TransTime","UserFlag","","ChnId","ChnCode","BusCode","","Phone","ChnCode","","ZlUserId"};
        Object [] temp = new Object[keys.length];
        String format = "%-171s%-24s%-1s%-30s%-120s%-8s%-6s%-1s%-57s%-17s%-9s%-3s%-228s%-24s%-9s%-748s%-12s";
        for(User user:userList){
            for(int i=0;i<keys.length;i++){
                try {
                    if( i == 0 || i == temp.length -2 || "".equals(keys[i])){
                        temp[i] = "";
                    }else{
                        Method m = user.getClass().getMethod("get" + keys[i]);
                        String value = (String) m.invoke(user);
                        temp[i] = new String(value.getBytes("GBK"),"ISO-8859-1");
                    }

                } catch (UnsupportedEncodingException e) {
                    logger.info("系统不支持编码GBK或ISO-8859-1");
                }
            }
            String tempFormat = String.format(Locale.getDefault(),format,temp);
            String returmVal = new String(tempFormat.getBytes("ISO-8859-1"),"GBK");
            result.append(returmVal + System.lineSeparator());
        }
        result.append( AccountFileConstants.FILE_ENDFLAG);
        return result;
    }

    private StringBuilder generateTradeApplyRecords(String chnCode,StringBuilder result,String preDate,String applyDate) throws UnsupportedEncodingException {
        List<TradeConsign> tradeList = tradeConsignMapperTrade.selectConfirmTradeList(chnCode,preDate,applyDate);
        logger.info("交易申请记录数： " + tradeList.size());
        result.append(String.format("%08d",tradeList.size()) + System.lineSeparator());//记录数
        for(TradeConsign trade:tradeList){
            if(trade.getHugeRedemFlag() == null){
                trade.setHugeRedemFlag("");
            }if(trade.getInvestorId() == null){
                trade.setInvestorId("");
            }if(trade.getRedeemFlag() == null){
                trade.setRedeemFlag("");
            }
            result.append(String.format(Locale.getDefault(),"%-24s",trade.getApplyNo()) +  //申请单编号
                    String.format(Locale.getDefault(),"%-6s",trade.getProductNo()) +  //基金代码
                    String.format(Locale.getDefault(),"%-1s",trade.getHugeRedemFlag()) +  //巨额赎回处理标志
                    String.format(Locale.getDefault(),"%-8s",trade.getTransDate()) +  //交易发生日期
                    String.format(Locale.getDefault(),"%-6s",trade.getTransTime()) +  //交易发生时间
                    String.format(Locale.getDefault(),"%-17s",trade.getChnId()) +  //投资人基金交易帐号
                    String.format(Locale.getDefault(),"%-9s",trade.getChnCode()) +  //销售人代码
                    ConvertorUtils.convertToStrMulOneHundred("%016d",trade.getTransVol().toString()) +  //申请基金份数
                    ConvertorUtils.convertToStrMulOneHundred("%016d",trade.getTransAmount().toString()) +   //申请金额
                    String.format(Locale.getDefault(),"%-3s",trade.getBussCode()) +   //业务代码
                    String.format(Locale.getDefault(),"%-12s",trade.getInvestorId()) +  //投资人基金帐号
                    String.format(Locale.getDefault(),"%-28s","") +
                    String.format(Locale.getDefault(),"%-3s","0") +   //结算币种
                    String.format(Locale.getDefault(),"%-9s",trade.getChnCode()) +   //网点号码
                    String.format(Locale.getDefault(),"%-507s","") +
                    String.format(Locale.getDefault(),"%-32s",trade.getTransferNo()) +  //商户系统流水号
                    String.format(Locale.getDefault(),"%-1s",trade.getRedeemFlag()) +  //赎回标识
                    String.format(Locale.getDefault(),"%-60s",trade.getTransBankCode()) +  //银行代码
                    String.format(Locale.getDefault(),"%-24s",trade.getTransBankAct())   //银行账号
            );

            result.append(System.lineSeparator());
        }
        result.append( AccountFileConstants.FILE_ENDFLAG);
        return result;
    }

    /*private String strFormat(String str,String format) throws UnsupportedEncodingException {
        String name = "";
        String temp = "";
        String returnValue = "";
        if(!"".equals(str) && str != null){
            name = new String(str.getBytes("GBK"),"ISO-8859-1");
            temp = String.format(Locale.getDefault(),format,name);
            returnValue = new String(temp.getBytes("ISO-8859-1"),"GBK");
        }

        return returnValue;
    }*/

}
