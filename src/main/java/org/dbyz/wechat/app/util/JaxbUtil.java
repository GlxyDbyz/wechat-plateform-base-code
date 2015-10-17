package org.dbyz.wechat.app.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Xml 和 javabean 的 数据转换帮助类
 *
 * @ClassName: JaxbUtil
 * @author: 作者 E-mail <a href="mailto:845927437@qq.com">Dbyz</a> 
 * @version: V1.0
 */
@SuppressWarnings("unchecked")
public class JaxbUtil {

	/**
	 * Xml转换成JavaBean
	 * 
	 * @Title: xml2Bean
	 * @Description:
	 * @param @param xml Xml数据源
	 * @param @param clazz 转换的类
	 * @param @return
	 * @return T
	 * @throws JAXBException 
	 */
	public static <T> T xml2Bean(String xml, Class<T> clazz) throws JAXBException {
		T t = null;
		// 应用的入口，用于管理XML/Java绑定信息
		JAXBContext context = JAXBContext.newInstance(clazz);
		// 将XML数据反序列化为Java对象
		Unmarshaller unmarshaller = context.createUnmarshaller();
		t = (T) unmarshaller.unmarshal(new StringReader(xml));
		return t;
	}

	/**
	 * JavaBean转换Xml
	 * 
	 * @param <T>
	 * 
	 * @Title: bean2Xml
	 * @Description:
	 * @param @param obj 需要转换的类
	 * @param @param encoding 编码（推荐UTF-8）
	 * @return String
	 * @throws JAXBException
	 */
	public static <T> String bean2Xml(T obj, String encoding)
			throws JAXBException {
		if (obj == null) {
			return null;
		}
		String result = null;

		// 应用的入口，用于管理XML/Java绑定信息
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		// Marshaller接口，将Java对象序列化为XML数据。
		Marshaller marshaller = context.createMarshaller();
		// 格式化
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// 设置编码
		marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

		// StringReader reader = new StringReader("as");
		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);
		result = writer.toString();

		return result;
	}

	public static <T> T getXmlBeanFromUrl(String url, Class<T> clazz)
			throws JAXBException, MalformedURLException {
		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		T result = (T) unmarshaller.unmarshal(new URL(url));
		return result;
	}
}
