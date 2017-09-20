
  
package com.essential.common.utils;  

import java.util.HashMap;
import java.util.Map;

import com.essential.common.model.DataTable;
 
/**
 * @ClassName: DataTableUtils
 * @Description: dataTable工具类
 * @author: xush
 * @date: 2015年2月11日 上午11:33:51
 *
 */ 
public class DataTableUtils {
	
	/**
	 * @Description: mybatis查询 将dataTables转换成map
	 * @author: xush
	 * @param: @param dataTables
	 * @param: @return
	 * @return: Map<String,Object>
	 * @throws
	 */ 
	public static  Map<String, Object> dataTableToMap(DataTable dataTable){
		 Map<String, Object> map = new  HashMap<String, Object>();
		 map.put("draw", dataTable.getDraw());
		 map.put("length", dataTable.getLength()==-1?2147483645:dataTable.getLength());
		 map.put("recordsFiltered", dataTable.getRecordsFiltered());
		 map.put("search", dataTable.getSearch());
		 map.put("start", dataTable.getStart());
		return map;
	}

}
  
