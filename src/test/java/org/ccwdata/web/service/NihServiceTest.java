package org.ccwdata.web.service;

import java.util.ArrayList;
import java.util.List;

import org.ccwdata.web.pojo.nih.FullInteraction;

public class NihServiceTest {

	public static void main(String[] args) {
		NihService nihService = new NihService();
		List<String> rxcuiList = new ArrayList<String>();
		rxcuiList.add("207106");
		rxcuiList.add("152923");
		rxcuiList.add("656659");
		FullInteraction fullInteraction = nihService.retrieveInteractionForList(rxcuiList);
		
	}
}
