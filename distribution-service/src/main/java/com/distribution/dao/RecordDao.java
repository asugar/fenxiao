package com.distribution.dao;

import com.distribution.model.ReqRecord;





/**
 * 
 * Description:
 *
 * @author oyyf
 *
 * @date 2017年12月21日 下午2:46:51
 */
public interface RecordDao {
	/**
	 * 插入操作记录
	 * @param record 操作记录对象
	 * @return  插入结果
	 */
	public int insertRecord(ReqRecord record);
	/**
	 * 操作记录状态修改
	 * @param record 
	 * @return 修改结果
	 */
	public int updateRecord(ReqRecord record);
	
	
	

}
