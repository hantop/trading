package com.jinhui.zlrt.utils;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zlink.zlpay.commonofs.common.ZlpayUtil;
import com.zlink.zlpay.commonofs.common.exception.MsgException;
import com.zlink.zlpay.commonofs.common.util.Constants;

import demo.util.HttpRequestParam;
import demo.util.HttpUtils;

/**
 * @ClassName Demo
 * @author SULONG.TIAN
 * @date 2015-4-16 下午8:25:02
 */
public class Demo {
	private static String sendUrl = "http://219.143.244.227:7082/zlrt-fund/fundofs/bg/marginRegisterReq";
	private static String cerPath = "F:\\证书和开发包\\zlzf_uat.cer";
	private static String pfxPath = "F:\\证书和开发包\\通用商户私钥.pfx";
	private static String keyPwd = "111111";
	/**
	 * @Description: TODO
	 * @param args
	 * void
	 * @author SULONG.TIAN
	 * @throws MsgException 
	 */
	public static void main(String[] args) throws MsgException {

		//String data = "instuId=B00000538|fundDate=20171107|fundTime=223940|fundSeqId=20170808000000321|counterNo=001|custType=0|userNameText=测试|certType=00|certId=1101233211223222|bankCode=0105|cardNo=6217000000000000111|resv=demo";
		//String data =   "instuId=B00000603|fundDate=20180226|fundTime=163801|fundSeqId=7013333330303332|counterNo=001|custType=0|userNameText=测试用户|certType=00|certId=362401199010274811|bankCode=0308|cardNo=6214836552045814|";
		String data = "instuId=B00000603|fundDate=20180310|fundTime=170522|fundSeqId=201803100000003796|busiType=0004|userId=CP0000041588|userNameText=张三|certType=00|certId=362438199010274811|bankType=0308|cardNo=6214836552335144|flag=0|transAmt=1000||fundCode=GZ0001|fundType=10|||";
		System.out.println("明文：：：：：：："+data);
		
		/**
		 * 加密：用证联公钥
		 * @data   加密数据
		 * @cerPath  cer公钥证书路径，例：D:/jks_cer/zlzf.cer
		 */
		String encryptData = ZlpayUtil.encryptData(data, cerPath);
		System.out.println("加密结果：：：：：：："+encryptData);
		/**
		 * 加签：用自己的私钥
		 * @data  加签数据
		 * @pfxPath  pfx私钥证书路径，例：D:/jks_cer/B00000001.pfx
		 * @keyPwd   pfx私钥密码   测试为：111111
		 */
		String signData = ZlpayUtil.signData(data, pfxPath, keyPwd);
		System.out.println("加签结果：：：：：：："+signData);
		
		String responseMsg = sendMsg("B00000603", "108", encryptData, signData, sendUrl);;
		System.out.println("证联响应数据：：：：：：："+responseMsg);
		/**
		 * 解析返回数据
		 * @responseMsg  证联响应数据
		 * @cerPath  cer公钥证书路径，例：D:/jks_cer/zlzf.cer
		 * @pfxPath  pfx私钥证书路径，例：D:/jks_cer/B00000001.pfx
		 * @keyPwd   pfx私钥密码   测试为：111111
		 */
		String response = ZlpayUtil.parseResponse(responseMsg, cerPath, pfxPath, keyPwd);
		System.out.println("证联响应数据解析结果：：：：：：："+response);
	}
	/**
	 * @description 发送请求业务并返回响应
	 * @param instuId
	 * @param transType
	 * @param encMsg
	 * @param checkValue
	 * @return
	 * @throws MsgException 
	 * @author ZhangDM(Mingly)
	 * @date 2012-10-22
	 */
	@SuppressWarnings("unused")
	private static String sendMsg(String instuId, String transType, 
			String encMsg, String checkValue, String sendUrl) throws MsgException{
		
		try {
			List<HttpRequestParam> params = bulidParam(instuId, transType,  URLEncoder.encode(encMsg,"UTF-8"), URLEncoder.encode(checkValue,"UTF-8"));
			HttpUtils http = new HttpUtils();
			http.openConnection();
			String responseMsg = http.executeHttpPost(sendUrl, params, Constants.ENCODING);
			//logger.info("调用http请求之后响应的内容：" + responseMsg);
			http.closeConnection();
			if("".equals(responseMsg)||responseMsg == null){
				//logger.info("连接网络超时！请稍后查询交易记录");
				throw new MsgException(Constants.ERROR_SENDFAIL);
			}
			return responseMsg;
		} catch (Exception e){
			//throw new MsgException(Constants.ERROR_SENDFAIL,e);
		}
		
		return null;
	}
	/**
	 * @description 组装发送参数
	 * @param instuId
	 * @param transType
	 * @param encMsg
	 * @param checkValue
	 * @return 
	 * @author ZhangDM(Mingly)
	 * @date 2012-10-21
	 */
	private static List<HttpRequestParam> bulidParam(String instuId, String transType, 
			String encMsg, String checkValue){
		
		HttpRequestParam verNumParam = new HttpRequestParam();
		verNumParam.setParaName(Constants.VERNUM);
		verNumParam.setParaValue(Constants.VERNUM_VALUE);
		HttpRequestParam sysDateTimeParam = new HttpRequestParam();
		sysDateTimeParam.setParaName(Constants.SYSDATETIME);
		sysDateTimeParam.setParaValue(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		HttpRequestParam instuIdParam = new HttpRequestParam();
		instuIdParam.setParaName(Constants.INSTUID);
		instuIdParam.setParaValue(instuId);
		HttpRequestParam transTypeParam = new HttpRequestParam();
		transTypeParam.setParaName(Constants.TRANSTYPE);
		transTypeParam.setParaValue(transType);
		HttpRequestParam encMsgParam = new HttpRequestParam();
		encMsgParam.setParaName(Constants.ENCMSG);
		encMsgParam.setParaValue(encMsg);
		HttpRequestParam checkValueParam = new HttpRequestParam();
		checkValueParam.setParaName(Constants.CHECKVALUE);
		checkValueParam.setParaValue(checkValue);
		
		List<HttpRequestParam> params=new ArrayList<HttpRequestParam>();
		params.add(verNumParam);
		params.add(sysDateTimeParam);
		params.add(instuIdParam);
		params.add(transTypeParam);
		params.add(encMsgParam);
		params.add(checkValueParam);
		
		return params;
	}
}
