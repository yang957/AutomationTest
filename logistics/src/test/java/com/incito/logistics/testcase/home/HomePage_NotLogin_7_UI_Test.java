package com.incito.logistics.testcase.home;
/**
 *@author  xy-incito
 *@Description 测试用例：首页UI测试
 *
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.pageshelper.HomePageHelper;

public class HomePage_NotLogin_7_UI_Test extends BaseParpare {
	@Test
	public void uiTest(ITestContext context){
		  int timeOut =Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		  HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		  HomePageHelper.checkHomePageText(seleniumUtil);
		
	}

}
