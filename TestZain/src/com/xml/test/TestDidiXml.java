/*
 * @(#)TestDidiXml.java
 * Author : zixian.luo001
 * Created Date: 2018年5月11日 
 */
package com.xml.test;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.xml.domain.DidiWebCallBackInfoDomain;
import com.xml.domain.DidiWebTokenReqDomain;

/**
 * @title TODO
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年5月11日 zixian.luo001 create file<br>
 *              Id:TestDidiXml.java,v1.0 2018年5月11日 下午2:13:35
 */
public class TestDidiXml {
	public static void main(String[] args) {

		try {
			JAXBContext context = JAXBContext.newInstance(DidiWebTokenReqDomain.class); // 获取上下文对象
			Marshaller marshaller = context.createMarshaller(); // 根据上下文获取marshaller对象

			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8"); // 设置编码字符集
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化XML输出，有分行和缩进
			StringWriter writer = new StringWriter();

			DidiWebTokenReqDomain req = createReq(); 
			marshaller.marshal(req, writer);
			System.out.println(writer.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static DidiWebTokenReqDomain createReq() {
		DidiWebTokenReqDomain req = new DidiWebTokenReqDomain();
		req.setClientId("clientId");
		req.setClientSecret("clientSecret");
		req.setMasterPhone("masterPhone");
		req.setPassengerPhone("passengerPhone");
		req.setAuthType("1");
		req.setCityId("cityId");
		req.setToCityId("toCityId");
		req.setForbidCityCross("forbidCityCross");
		req.setRuleList("ruleList");
		req.setRequireLevelList("requireLevelList");
		req.setClat("clat");
		req.setClng("clng");
		req.setRestrictFromPoint("restrictFromPoint");
		req.setFromName("fromName");
		req.setFlat("flat");
		req.setFlng("flng");
		req.setRestrictToPoint("restrictToPoint");
		req.setToName("toName");
		req.setTlat("tlat");
		req.setTlng("tlng");
		req.setDepartureTime("departureTime");
		DidiWebCallBackInfoDomain  back= new DidiWebCallBackInfoDomain();
		back.setAirportId("airportId");
		back.setClientOrderId("clientOrderId");
		back.setEmployeeNumber("employeeNumber");
		back.setFlightNumber("flightNumber");
		back.setFlightTime("flightTime");
		back.setOrganization("organization");
		req.setCallbackInfo(back);
		req.setTranCode("tranCode");
		req.setPartnerId("partnerId");
		return req;
	}
}
