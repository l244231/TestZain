/*
 * @(#)TestCtripXml.java
 * Author : zixian.luo001
 * Created Date: 2018年7月24日 
 */
package com.xml.test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.xml.domain.CtipCarPickUpEndorsementDetail;
import com.xml.domain.CtripCarQuickEndorsementDetail;
import com.xml.domain.CtripCompanyAddressDetail;
import com.xml.domain.CtripPassengerDetail;
import com.xml.domain.CtripSetapproval;
import com.xml.domain.CtripUseTimeDetail;

/**
 * @title TODO
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年7月24日 zixian.luo001 create file<br>
 *              Id:TestCtripXml.java,v1.0 2018年7月24日 下午2:28:07
 */
public class TestCtripXml {
	public static void main(String[] args) {
		CtripSetapproval apply = new CtripSetapproval();
		apply.setPartnerId("MTRS_CTRIP");
		apply.setTranCode("setapproval");

		apply.setCarQuickEndorsementDetails(createCarQuick());

		try {
			JAXBContext context = JAXBContext.newInstance(CtripSetapproval.class); // 获取上下文对象
			Marshaller marshaller = context.createMarshaller(); // 根据上下文获取marshaller对象

			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8"); // 设置编码字符集
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化XML输出，有分行和缩进
			StringWriter writer = new StringWriter();

			marshaller.marshal(apply, writer);
			System.out.println(writer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void createCar(){
		CtipCarPickUpEndorsementDetail carUse = new CtipCarPickUpEndorsementDetail();
	}
	

	public static List<CtripCarQuickEndorsementDetail> createCarQuick() {
		CtripCarQuickEndorsementDetail carUse = new CtripCarQuickEndorsementDetail();
		carUse.setCities("21547,21541");
		carUse.setProductType(53);
		carUse.setBeginUseDate("2018-07-24");
		carUse.setEndUseDate("2018-07-25");
		carUse.setPrice(158.12f);
		carUse.setVehicleGroup("1");
		carUse.setPreVerifyFields(3);
		carUse.setSkipFields(0);

		List<CtripUseTimeDetail> useTimeList = new ArrayList<CtripUseTimeDetail>();
		CtripUseTimeDetail useTime = new CtripUseTimeDetail();
		useTime.setBeginUseTime("00:00");
		useTime.setEndUseTime("08:00");
		useTimeList.add(useTime);

		CtripUseTimeDetail useTime1 = new CtripUseTimeDetail();
		useTime1.setBeginUseTime("21:00");
		useTime1.setEndUseTime("24:00");
		useTimeList.add(useTime1);

		carUse.setUseTimeList(useTimeList);

		List<CtripPassengerDetail> passengerList = new ArrayList<CtripPassengerDetail>();
		CtripPassengerDetail passenger = new CtripPassengerDetail();
		passenger.setEID("102841");
		passenger.setName("罗梓贤");
		passengerList.add(passenger);
		carUse.setPassengerList(passengerList);

		List<CtripCompanyAddressDetail> companyAddressList = new ArrayList<CtripCompanyAddressDetail>();
		CtripCompanyAddressDetail address = new CtripCompanyAddressDetail();
		address.setAddressName("深圳新亚洲花园");
		address.setLatitude("22.7155162015326980");
		address.setLongitude("114.2379856109620000");
		address.setAllowRadius("1000");

		CtripCompanyAddressDetail address2 = new CtripCompanyAddressDetail();
		address2.setAddressName("深圳新亚洲花园");
		address2.setLatitude("22.7155162015326980");
		address2.setLongitude("114.2379856109620000");
		address2.setAllowRadius("1000");
		companyAddressList.add(address);
		companyAddressList.add(address2);

		carUse.setCompanyAddressList(companyAddressList);

		List<CtripCarQuickEndorsementDetail> carQuickEndorsementDetails = new ArrayList<CtripCarQuickEndorsementDetail>();
		carQuickEndorsementDetails.add(carUse);
		return carQuickEndorsementDetails;
	}
}
