package com.kingdee.dome.webapi.sdktest;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class SeqHelper {

	static long seq=0;
	static int mod=10000;
	/**
	 * 获取一个ID
	 * @return
	 */
	public static long genSeq() {
		return ++seq;
	}
	/**
	 * 创建一个编码
	 * @return
	 */
	public static String genNumber(String pre) {
		SimpleDateFormat sdf=new  SimpleDateFormat("yyyyMMHHmmss"); 
		String id=sdf.format(new Date());
		if(pre==null)
			return id + (genSeq() +  mod);
		else
			return pre+id + (genSeq() +  mod);
	}
}
