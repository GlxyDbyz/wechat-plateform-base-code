package org.dbyz.wechat.app.util;

/**
 * 计算经纬度之间的距离工具类
 * 
 * @ClassName: DistanceUtil
 * @Description:
 * @author 作者 E-mail <a href="mailto:845927437@qq.com">方正</a>
 * @version 创建时间：2015
 */
public class DistanceUtil {

	/**
	 * 计算地球上任意两点(经纬度)距离
	 * 
	 * @param long1
	 *            第一点经度
	 * @param lat1
	 *            第一点纬度
	 * @param long2
	 *            第二点经度
	 * @param lat2
	 *            第二点纬度
	 * @return 返回距离 单位：米
	 */
	public static double GetDistance(double long1, double lat1, double long2,
			double lat2) {
		double a, b, R;
		R = 6378137; // 地球半径
		lat1 = lat1 * Math.PI / 180.0;
		lat2 = lat2 * Math.PI / 180.0;
		a = lat1 - lat2;
		b = (long1 - long2) * Math.PI / 180.0;
		double d;
		double sa2, sb2;
		sa2 = Math.sin(a / 2.0);
		sb2 = Math.sin(b / 2.0);
		d = 2
				* R
				* Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)
						* Math.cos(lat2) * sb2 * sb2));
		return d;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成方法存根
		double distance = GetDistance(121.491909, 31.233234, 121.491909,
				32.233234);
		System.out.println("Distance is:" + distance);
	}
}