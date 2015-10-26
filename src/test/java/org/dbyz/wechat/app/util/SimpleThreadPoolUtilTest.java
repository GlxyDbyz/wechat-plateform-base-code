package org.dbyz.wechat.app.util;


public class SimpleThreadPoolUtilTest {
	public static void main(String[] args) {
		SimpleThreadPoolUtil.execute(new Runnable() {
			public void run() {
				System.out.println(1121);
			}
		});
	}
}
