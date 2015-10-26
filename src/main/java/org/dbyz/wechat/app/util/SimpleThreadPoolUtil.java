package org.dbyz.wechat.app.util;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SimpleThreadPoolUtil {
	/**
	 * 初始化线程池
	 */
	private static ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 60,
			TimeUnit.MINUTES, new LinkedBlockingDeque<Runnable>(50));

	/**
	 * 执行任务
	 * 
	 * @Title: execute
	 * @param task
	 *            需要执行的任务
	 * @return: void
	 * @since V1.0
	 */
	public static void execute(Runnable task) {
		pool.execute(task);
	}

	/**
	 * 提交任务
	 * 
	 * @Title: submit
	 * @param task
	 *            需要执行的任务（有返回）
	 * @return: void
	 * @since V1.0
	 */
	public static <T> void submit(Callable<T> task) {
		pool.submit(task);
	}

}
