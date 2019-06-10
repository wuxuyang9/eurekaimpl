package com.lrving.util;

import org.apache.commons.lang3.StringEscapeUtils;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @Description: 字符串类型处理类
* @Author: luolang
* @Date: 2019/2/23
*/
public class StringUtils extends org.apache.commons.lang3.StringUtils {

	/**首字母小写*/
	public static String lowerFirst(String str){
		if(StringUtils.isBlank(str)) {
			return "";
		} else {
			return str.substring(0,1).toLowerCase() + str.substring(1);
		}
	}

	/**首字母大写*/
	public static String upperFirst(String str){
		if(StringUtils.isBlank(str)) {
			return "";
		} else {
			return str.substring(0,1).toUpperCase() + str.substring(1);
		}
	}

	/**
	 * 替换掉HTML标签方法
	 */
	public static String replaceHtml(String html) {
		if (isBlank(html)){
			return "";
		}
		String regEx = "<.+?>";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(html);
		String s = m.replaceAll("");
		return s;
	}

	/**
	 * 缩略字符串（不区分中英文字符）
	 * @param str 目标字符串
	 * @param length 截取长度
	 * @return
	 */
	public static String abbr(String str, int length) {
		if (str == null) {
			return "";
		}
		try {
			StringBuilder sb = new StringBuilder();
			int currentLength = 0;
			for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
				currentLength += String.valueOf(c).getBytes("GBK").length;
				if (currentLength <= length - 3) {
					sb.append(c);
				} else {
					sb.append("...");
					break;
				}
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 缩略字符串（替换html）
	 * @param str 目标字符串
	 * @param length 截取长度
	 * @return
	 */
	public static String rabbr(String str, int length) {
        return abbr(replaceHtml(str), length);
	}
		
	
	/**
	 * 转换为Double类型
	 */
	public static Double toDouble(Object val){
		if (val == null){
			return 0D;
		}
		try {
			return Double.valueOf(trim(val.toString()));
		} catch (Exception e) {
			return 0D;
		}
	}

	/**
	 * 转换为Float类型
	 */
	public static Float toFloat(Object val){
		return toDouble(val).floatValue();
	}

	/**
	 * 转换为Long类型
	 */
	public static Long toLong(Object val){
		return toDouble(val).longValue();
	}

	/**
	 * 转换为Integer类型
	 */
	public static Integer toInteger(Object val){
		return toLong(val).intValue();
	}

	/**
	 * 判断字符串是否不为空，不为空则返回true
	 *
	 * @param str 源数据
	 * @return Boolean
	 */
	public static boolean isNotEmpty(String str) {
		if (str != null && !"".equals(str.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否不为空，为空则返回true
	 *
	 * @param str 源数据
	 * @return Boolean
	 */
	public static boolean isEmpty(String str) {
		if (str != null && !"".equals(str.trim())) {
			return false;
		}
		return true;
	}


	/**
	* @Description: 获取指定长度的随机字符串
	* @Param:  * @param null
	* @return:
	* @Author: luolang
	* @Date: 2019/5/5
	*/
	public static String getRandomString(Integer length) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}


	/**
	* @Description: 获取指定长度的数字随机字符串
	* @Param:  * @param null
	* @return:
	* @Author: luolang
	* @Date: 2019/5/5
	*/
	public static String getRandomNum(Integer length) {
		String base = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 右补位，左对齐
	 *
	 * @param oriStr   原字符串
	 * @param len      目标字符串长度
	 * @param fillChar 补位字符
	 * @return 目标字符串
	 */
	public static String padRight(String oriStr, int len, char fillChar) {
		String str = "";
		int strlen = oriStr.length();
		if (strlen < len) {
			for (int i = 0; i < len - strlen; i++) {
				str = str + fillChar;
			}
		}
		str = str + oriStr;
		return str;
	}

	/**
	 * 左补位，右对齐
	 *
	 * @param oriStr   原字符串
	 * @param len      目标字符串长度
	 * @param fillChar 补位字符
	 * @return 目标字符串
	 */
	public static String padLeft(String oriStr, int len, char fillChar) {
		int strlen = oriStr.length();
		String str = "";
		if (strlen < len) {
			for (int i = 0; i < len - strlen; i++) {
				str = str + fillChar;
			}
		}
		str = oriStr + str;
		return str;
	}
}
