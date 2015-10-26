package org.dbyz.wechat.app.util;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolUtil {
	/**
	 * 初始化可延迟的线程池
	 */
	private static ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(
			50);

	/**
	 * 执行延迟任务
	 * 
	 * @Title: schedule
	 * @param task
	 *            需要执行的任务
	 * @param second
	 *            延迟的时间（秒）
	 * @return: void
	 * @since V1.0
	 */
	public static void schedule(Runnable task, Long second) {
		pool.schedule(task, second, TimeUnit.SECONDS);
	}

	/**
	 * 执行延迟任务
	 * 
	 * @Title: schedule
	 * @param task
	 *            任务（有返回）
	 * @param second
	 *            延迟时间（秒）
	 * @return: ScheduledFuture<T>
	 * @since V1.0
	 */
	public static <T> ScheduledFuture<T> schedule(Callable<T> task, Long second) {
		return pool.schedule(task, second, TimeUnit.SECONDS);
	}

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
	 * @return: Future<T>
	 * @since V1.0
	 */
	public static <T> Future<T> submit(Callable<T> task) {
		return pool.submit(task);
	}

	/**
	 * 执行延迟任务
	 * 
	 * @Title: execute
	 * @param task
	 *            需要执行的任务
	 * @param second
	 *            延迟的时间（秒）
	 * @return: void
	 * @since V1.0
	 */
	public static void execute(Runnable task, Long second) {
		pool.schedule(task, second, TimeUnit.SECONDS);
	}

	/**
	 * 执行延迟任务
	 * 
	 * @Title: submit
	 * @param task
	 *            任务（有返回）
	 * @param second
	 *            延迟时间（秒）
	 * @return: ScheduledFuture<T>
	 * @since V1.0
	 */
	public static <T> ScheduledFuture<T> submit(Callable<T> task, Long second) {
		return pool.schedule(task, second, TimeUnit.SECONDS);
	}
}
