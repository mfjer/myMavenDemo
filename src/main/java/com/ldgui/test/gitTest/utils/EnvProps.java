package com.ldgui.test.gitTest.utils;

import java.util.PropertyResourceBundle;

/**
 * 
 * @Title: EnvProps.java 
 * @Package com.ldgui.test.gitTest.utils 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Liaodg
 * @date 2017年12月4日 下午5:23:39
 * @version V1.0
 */
public class EnvProps {
	private static EnvProps _instance;
	private static String configFilePath = "env";
	private String ENV_TYPE;//运行环境标识，P：生产环境；T：测试环境；D：开发环境
	private String staticResource;//静态资源URL参数
	private String basePath;//应用的上下文根

	/**
	 * @return the basePath
	 */
	public String getBasePath() {
		return basePath;
	}

	/**
	 * @param basePath the basePath to set
	 */
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	/**
	 * @return the staticResource
	 */
	public String getStaticResource() {
		return staticResource;
	}

	/**
	 * @param staticResource
	 *            the staticResource to set
	 */
	public void setStaticResource(String staticResource) {
		this.staticResource = staticResource;
	}

	public String getENV_TYPE() {
		return ENV_TYPE;
	}

	public void setENV_TYPE(String eNV_TYPE) {
		ENV_TYPE = eNV_TYPE;
	}

	public static EnvProps getInstance() {
		if (_instance == null)
			_instance = new EnvProps();
		return _instance;
	}

	private EnvProps() {
		PropertyResourceBundle configBundle = (PropertyResourceBundle) PropertyResourceBundle.getBundle(configFilePath);
		ENV_TYPE = configBundle.getString("ENV_TYPE");
		if (ENV_TYPE.equals("D")) {
			staticResource = configBundle.getString("StaticResource_DEV");
			basePath = configBundle.getString("BasePath_DEV");
		} else if (ENV_TYPE.equals("T")) {
			staticResource = configBundle.getString("StaticResource_TEST");
			basePath = configBundle.getString("BasePath_TEST");
		} else if (ENV_TYPE.equals("P")) {
			staticResource = configBundle.getString("StaticResource_PRODU");
			basePath = configBundle.getString("BasePath_PRODU");
		}
	}

	public static void main(String args[]) {
		System.out.println("EVN==" + EnvProps.getInstance().getENV_TYPE());
		System.out.println("staticResource==" + EnvProps.getInstance().getStaticResource());
	}
}
