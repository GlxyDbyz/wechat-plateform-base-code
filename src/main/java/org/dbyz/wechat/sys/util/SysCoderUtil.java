package org.dbyz.wechat.sys.util;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

public final class SysCoderUtil {
	/**
	 * 密码加密矢量
	 */
	private static final String PASSWORD_ENCODE_VECTOR = "G6DZeMYjQWuF";

	/**
	 * 密码加密
	 * 
	 * @Title: encodePassword
	 * @param @param password 明文
	 * @param @param name 明文
	 * @param @return
	 * @return: String 加密密码
	 * @since V1.0
	 */
	public static final String encodePassword(String password, String name) {
		return DigestUtils.md5Hex(name + password + PASSWORD_ENCODE_VECTOR);
	}

	/**
	 * Uuid 生成
	 * 
	 * @Title: generateUuid
	 * @param @return
	 * @return: String
	 * @since V1.0
	 */
	public static final String generateUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static void main(String[] args) {
		System.out.println(encodePassword("123456", "sys"));
		System.out.println(generateUuid());
	}

}
