package com.incito.logistics.base;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.incito.logistics.util.SeleniumUtil;

public class BaseParpare {
	protected SeleniumUtil seleniumUtil = null;
	/*添加成员变量来获取beforeClass传入的context参数*/
	protected ITestContext testContext = null;

	@BeforeClass
	public void beforeClass(ITestContext context) {
		seleniumUtil = new SeleniumUtil();
		  //这里得到了context值
		this.testContext = context;  
		String browserName = context.getCurrentXmlTest().getParameter(
				"browserName");
	try{
			seleniumUtil.launchBrower(browserName, context);
	}catch(Exception e){
		System.out.println("Setup Failed！！-->>这是异常中的退出");
		seleniumUtil.quit();
	}
	//设置一个testng上下文属性，将driver存起来，之后可以使用context随时取到
		testContext.setAttribute("SELENIUM_DRIVER",seleniumUtil.driver);  
	}

	@AfterClass
	public void afterClass() {
		System.out.println("这是afterclass中的退出");
		seleniumUtil.quit();
	}

}
