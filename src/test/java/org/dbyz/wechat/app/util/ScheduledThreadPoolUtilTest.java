package org.dbyz.wechat.app.util;

public class ScheduledThreadPoolUtilTest {
	public static void main(String[] args) {
		ScheduledThreadPoolUtil.schedule(new Runnable() {
			public void run() {
				System.out.println("hello");
			}
		}, 10L);
	}
}
