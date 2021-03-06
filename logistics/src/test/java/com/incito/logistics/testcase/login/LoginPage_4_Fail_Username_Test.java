package com.incito.logistics.testcase.login;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.LoginPage;
import com.incito.logistics.pages.pageshelper.AlertPageHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
/**
 *@author  xy-incito
 *@Description 登陆失败-只输入用户名不输入密码 点击登陆会提示“请输入密码”
 * */
public class LoginPage_4_Fail_Username_Test extends BaseParpare{
    
  @Test
  public void loginFailTest_Username(ITestContext context) {
	  String username = context.getCurrentXmlTest().getParameter("username");
	  int timeOut =Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
	  int waitMillisecondsForAlert =Integer.valueOf(context.getCurrentXmlTest().getParameter("waitMillisecondsForAlert"));
	  
	  HomePageHelper.waitHomePageToLoad(timeOut,seleniumUtil);
	  seleniumUtil.click(seleniumUtil.findElementBy(HomePage.HP_BUTTON_LOGIN));
	 LoginPageHelper.waitLPageToLoad(timeOut, seleniumUtil);
	  seleniumUtil.clear(seleniumUtil.findElementBy(LoginPage.LP_INPUT_USERNAME));
	  seleniumUtil.sendKeys(seleniumUtil.findElementBy(LoginPage.LP_INPUT_USERNAME), username);
	  seleniumUtil.click(seleniumUtil.findElementBy(LoginPage.LP_BUTTON_LOGIN));
	 AlertPageHelper.isAlertPassword(seleniumUtil, waitMillisecondsForAlert);
  }
  

}
