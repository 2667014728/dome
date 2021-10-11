package com.kingdee.dome.webapi.sdktest;

import com.google.gson.Gson;
import com.kingdee.dome.webapi.entities.Customer;
import com.kingdee.bos.webapi.sdk.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.fail;


public class CommonTest {
		
	@Test
	public void testGson() {

		Gson gson = new Gson();
		String json = "{\"TaskId\":\"7\",\"Status\":2,\"Result\":{\"Result\":{\"ResponseStatus\":{\"IsSuccess\":true,\"Errors\":[],\"SuccessEntitys\":[{\"Id\":100082,\"Number\":\"BC20190914023210001\",\"DIndex\":0},{\"Id\":100083,\"Number\":\"BC20190914023310002\",\"DIndex\":1},{\"Id\":100084,\"Number\":\"BC20190914023310003\",\"DIndex\":2},{\"Id\":100085,\"Number\":\"BC20190914023310004\",\"DIndex\":3},{\"Id\":100086,\"Number\":\"BC20190914023310005\",\"DIndex\":4},{\"Id\":100087,\"Number\":\"BC20190914023310006\",\"DIndex\":5},{\"Id\":100088,\"Number\":\"BC20190914023310007\",\"DIndex\":6},{\"Id\":100089,\"Number\":\"BC20190914023310008\",\"DIndex\":7},{\"Id\":100090,\"Number\":\"BC20190914023310009\",\"DIndex\":8},{\"Id\":100091,\"Number\":\"BC20190914023310010\",\"DIndex\":9},{\"Id\":100092,\"Number\":\"BC20190914023310011\",\"DIndex\":10},{\"Id\":100093,\"Number\":\"BC20190914023310012\",\"DIndex\":11},{\"Id\":100094,\"Number\":\"BC20190914023310013\",\"DIndex\":12},{\"Id\":100095,\"Number\":\"BC20190914023310014\",\"DIndex\":13},{\"Id\":100096,\"Number\":\"BC20190914023310015\",\"DIndex\":14},{\"Id\":100097,\"Number\":\"BC20190914023310016\",\"DIndex\":15},{\"Id\":100098,\"Number\":\"BC20190914023310017\",\"DIndex\":16},{\"Id\":100099,\"Number\":\"BC20190914023310018\",\"DIndex\":17},{\"Id\":100100,\"Number\":\"BC20190914023310019\",\"DIndex\":18},{\"Id\":100101,\"Number\":\"BC20190914023310020\",\"DIndex\":19}],\"SuccessMessages\":[],\"MsgCode\":0},\"NeedReturnData\":[]}},\"Cancelled\":false,\"IsFaulted\":false,\"FaultedException\":null,\"ProgressInfos\":null,\"Successful\":true,\"Message\":\"\",\"Progress\":100,\"ProgressDesc\":\"\"}";
		QueryResultInfo ret = gson.fromJson(json, QueryResultInfo.class);
		String oStr = gson.toJson(ret.getResult());

	}

	/* 保存单个客户信息 */
	@Test
	public void testSaveCustomer() throws Exception {
		K3CloudApi api=new K3CloudApi();
		Customer c = new Customer();
		c.setFNumber(SeqHelper.genNumber("BC"));
		c.setFName("aimin_客户名称-A" + UUID.randomUUID().toString());
		c.setFShortName("aimin_客户简称-A" + UUID.randomUUID().toString());
		SaveResult sRet = api.save("BD_Customer", new SaveParam<Customer>(c));
		if (sRet.isSuccessfully()) {
			Gson gson = new Gson();
			System.out.println(
					String.format("%s", gson.toJson(sRet.getResult().getResponseStatus().getSuccessEntitys())));
		} else {
			fail("dcs is null!");
		}

	}
	
	/*批量保存客户信息*/
	@Test
	public void testBatchSaveCustomer() throws Exception {
		K3CloudApi api=new K3CloudApi();
		List<Customer> custs = new ArrayList<Customer>();
		for (int i = 0; i < 10; i++) {
			Customer c = new Customer();
			c.setFNumber(SeqHelper.genNumber("BC"));
			c.setFName("zam_客户名称-批量" + UUID.randomUUID().toString());
			c.setFShortName("zam_客户简称-批量" + UUID.randomUUID().toString());
			custs.add(c);
		}

		// 批量保存客户信息
		SaveResult sRet = api.batchSave("BD_Customer", new BatchSave<Customer>(custs), InvokeMode.Query);

		if (sRet.isSuccessfully()) {
			Gson gson = new Gson();
			for (int i = 0; i < custs.size(); i++)
				System.out.println(String.format("get(%s)=%s", i,
						gson.toJson(sRet.getResult().getResponseStatus().getSuccessEntitys().get(i))));
		} else {
			fail("dcs is null!");
		}
	}
	
	/*表单查询接口：查询客户信息*/
	@Test
	public void testQueryCustomer() {
		K3CloudApi api = new K3CloudApi();
		List<Customer> datas = null;
		try {
			datas = api.executeBillQuery(
					new QueryParam().setFormId("BD_Customer").setFieldKeys("FCUSTID,FNumber,FName,FCreateDate"),
					Customer.class);
			if (datas != null) {
				Customer meta = ((Customer) (datas.toArray()[0]));
				System.out.println(String.format("%s", new Gson().toJson(meta)));
			} else {
				fail("datas is null!");
			}
		} catch (Exception e) {

			fail(e.getMessage());
		}

		if (datas != null) {
			System.out.println(String.format("Total:%s", datas.size()));
		} else {
			fail("dcs is null!");
		}
	}
	
	
}
