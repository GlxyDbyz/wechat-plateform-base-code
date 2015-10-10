package org.dbyz.wechat.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方取出ApplicaitonContext.
 *
 * @ClassName: SpringContextHolder
 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a>
 * @version: V1.0
 */
public final class SpringContextHolder implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	/**
	 * 实现ApplicationContextAware接口的context注入函数, 将其存入静态度变量.
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextHolder.applicationContext = applicationContext;
	}

	/**
	 * 取得存储在静态变量中的ApplicationContext.
	 */
	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean ,By name
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean,By clazz
	 */
	public static <T> T getBean(Class<T> clazz) {
		// checkApplicationContext();
		return applicationContext.getBean(clazz);
	}

	/**
	 * 清除applicationContext静态变量.
	 */
	public static void cleanApplicationContext() {
		applicationContext = null;
	}

	private static void checkApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException(
					"applicaitonContext未注入applicationContext请在applicationContext.xml中定义SpringContextHolder");
		}
	}
}
