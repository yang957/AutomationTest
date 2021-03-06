package com.incito.logistics.pages.pageshelper;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.LoginPage;
import com.incito.logistics.util.SeleniumUtil;

public class LoginPageHelper {
	
	/**待页面元素加载出来*/
	public static void waitLPageToLoad(int timeOut,SeleniumUtil seleniumUtil){
		seleniumUtil.waitForElementToLoad(timeOut,LoginPage.LP_CHECKBOX_AUTO);
		seleniumUtil.waitForElementToLoad(timeOut,LoginPage.LP_INPUT_USERNAME);
		seleniumUtil.waitForElementToLoad(timeOut,LoginPage.LP_INPUT_PASSCODE);
	     seleniumUtil.waitForElementToLoad(timeOut,LoginPage.LP_BUTTON_LOGIN);
	     seleniumUtil.waitForElementToLoad(timeOut,LoginPage.LP_LABEL_AUTO);

	}
	
	/**检查该页面上的文本*/
	public static void checkLoginPageText(SeleniumUtil seleniumUtil){
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(LoginPage.LP_INPUT_USERNAME).getAttribute("placeholder"),"手机/用户名");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(LoginPage.LP_INPUT_PASSCODE).getAttribute("placeholder"),"密码");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(LoginPage.LP_BUTTON_LOGIN).getText(),"登录");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(LoginPage.LP_LABEL_AUTO).getText(),"下次自动登录");
		
	}
	
	/**判断输入登陆界面框输入是否正确*/
	public static void isInputCorrect(SeleniumUtil seleniumUtil){
		//设置用户名
		seleniumUtil.clear(seleniumUtil.findElementBy(LoginPage.LP_INPUT_USERNAME));
		seleniumUtil.sendKeys(seleniumUtil.findElementBy(LoginPage.LP_INPUT_USERNAME), "AG00005");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(LoginPage.LP_INPUT_USERNAME).getAttribute("value"),"AG00005");
		//设置密码
		seleniumUtil.clear(seleniumUtil.findElementBy(LoginPage.LP_INPUT_PASSCODE));
		seleniumUtil.sendKeys(seleniumUtil.findElementBy(LoginPage.LP_INPUT_PASSCODE), "123456");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(LoginPage.LP_INPUT_PASSCODE).getAttribute("value"),"123456");
		
	}
	
	/**检查登陆成功后用户信息是不是正确的*/
	public static void verifyUserInfo(int timeOut,int sleepTime,SeleniumUtil seleniumUtil,String username){
		seleniumUtil.sleep(sleepTime);
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_TEXT_USERINFO);
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(HomePage.HP_TEXT_USERINFO).getText(), username+" | 退出");
	}

}
