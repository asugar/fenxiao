package com.distribution.service.impl;



import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribution.dao.RecordDao;
import com.distribution.form.CommonProperties;
import com.distribution.form.ReqFromProperties;
import com.distribution.model.ReqRecord;
import com.distribution.service.i.FraudServiceI;
import com.distribution.utils.ResponseDataUtils;
import com.distribution.utils.StringUtil;


/**
 * 
 * Description:欺诈信息入库
 *
 * @author oyyf
 *
 * @date 2017年12月21日 下午3:00:51
 */
@Service("fraudServiceImpl")
public class FraudServiceImpl implements FraudServiceI{
	private final static Logger logger = Logger
			.getLogger(FraudServiceImpl.class);
//	@Autowired
//	FraudDao fraudDao;
	@Autowired
	RecordDao recordDao;
	/**
	 * 风险信息入库，包括各种类型的信息入库
	 */
	public String insertFraudinfo(String data) {
		ReqRecord rr= new ReqRecord();
		 recoedInfo(rr,data);//
		String retCode = ResponseDataUtils.STATUS_SUCCESS_CODE;
		String retMsg="";
//		Map<String,Object> map = new HashMap<String,Object>();
//		if(!StringUtils.isEmpty(data)){
//			retCode = ReqDataUtils.reqDatatoMap(data, map);//解析请求参数数据 到map
//			if(retCode.equals(ResponseDataUtils.STATUS_SUCCESS_CODE)){
//				ReqDataUtils.addCommonProperties(map);//将公共字段加入map
//				try {
//					int ii = insert(map);
//					if(ii!=1){
//						retCode = 	ResponseDataUtils.STATUS_DB_INSERT_CODE;
//					}
//				} catch (Exception e) {
//					logger.error("数据库入库异常",e);
//					retMsg = "数据库入库异常";
//					retCode = 	ResponseDataUtils.STATUS_DB_INSERT_CODE;
//				}
//			}
//		}else{
//			retCode = ResponseDataUtils.STATUS_NULL_REQDATA_CODE;
//		}
//		unpdateRecordInfo(rr,retCode,map);//更新状态
		return ResponseDataUtils.ownDefinedResponseStr(retCode, retMsg);
	}
	
	/**
	 * 枚举入库操作
	 * @param map 入库参数集合
	 * @return 入库状态
	 */
//	public int insert(Map<String, Object> map) {
//		
//		
//		switch (map.get(ReqFromProperties.SUB_DATA_CODE).toString()) {
//		// 风险电话库
//		case ReqFromProperties.D_RM_01_02:
//			return fraudDao.insertFraudPhone(map);
//			// 风险IP
//		case ReqFromProperties.D_RM_01_03:
//			return fraudDao.insertFraudIp(map);
//			// 风险地址库
//		case ReqFromProperties.D_RM_01_04:
//			return fraudDao.insertFraudAddress(map);
//			// D_RM_02_01
//		case ReqFromProperties.D_RM_02_01:
//			return fraudDao.insertFraudName(map);
//			// 地址可疑词汇库
//		case ReqFromProperties.D_RM_02_02:
//			return fraudDao.insertFraudKeyWord(map);
//			// 高危账号库
//		case ReqFromProperties.D_RM_03_01:
//			return fraudDao.insertFraudHighriskAccount(map);
//			// 风险APP列表库
//		case ReqFromProperties.D_RM_04_01:
//			return fraudDao.insertFraudApps(map);
//			// 欺诈风险设备库
//		case ReqFromProperties.D_RM_04_02:
//			return fraudDao.insertFraudUd(map);
//		default:
//			return -1;
//		}
//	}
	/**
	 * 更新入库操作流水
	 * @param rr 入库流水原始记录
	 * @param code 如果结果返回码
	 * @param map 入库状态结合
	 */
	private void unpdateRecordInfo(ReqRecord rr,String code,Map<String,Object> map) {
		rr.setReq_reason((String) map.get(ReqFromProperties.DB_REASON));
		rr.setReq_type((String)map.get(ReqFromProperties.OPERA_STATUS));
		rr.setStatus(code.equals(ResponseDataUtils.STATUS_SUCCESS_CODE)?CommonProperties.STATUS_SUCCESS:CommonProperties.STATUS_FAIL);
		rr.setStatus_detail(ResponseDataUtils.mapData.get(code));
		recordDao.updateRecord(rr);
	}
	/**
	 * 记录入库流水
	 * @param rr 流水状态
	 * @param data 数据
	 * @return 入库状态结果
	 */
	private ReqRecord recoedInfo(ReqRecord rr,String data){
		rr.setPid(StringUtil.randomNumber(15));
		rr.setCreate_time(new Date());
		rr.setReq_data(data);
		rr.setStatus(CommonProperties.STATUS_SUCCESS);
		recordDao.insertRecord(rr);
		return rr;
	}
	

}
