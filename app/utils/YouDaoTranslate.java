package utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.Translate;
import models.TranslateWord;
import play.Logger;
import play.libs.Json;

public class YouDaoTranslate {

	// http://fanyi.youdao.com/openapi.do?keyfrom=<keyfrom>&key=<key>&type=data&doctype=json&version=1.1&q=翻译
	
	public static int translatetimes = 0;
	public static int keytimes = 1;
	
	public static String sendYouDao(String str){
		
		try {
			str = URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String APIKEY = "995758606";
		String KEYFROM = "China-Howtoforge";
		if(translatetimes > 995){
			Map<String,String> map = YouDaoKey.getAPIKey(keytimes);
			APIKEY = map.get("API key");
			KEYFROM = map.get("keyfrom");
			keytimes ++;
		}
			
		String server = "http://fanyi.youdao.com/openapi.do?";
		String path = "keyfrom="+KEYFROM+"&key="+APIKEY+"&type=data&doctype=json&version=1.1&q=" + str;
		String result = RestUtils.getRest(server, path);
		translatetimes ++;
		Logger.info(result);
		if(result.contains("basic")){
			return translateWord(result);
		}
		return translate(result);
	}

	public static String translate(String str) {
		Translate translate = Json.fromJson(Json.parse(str), Translate.class);
		return  translate.translation.get(0);
	}
	
	public static String translateWord(String str) {
		TranslateWord translate = Json.fromJson(Json.parse(str), TranslateWord.class);
		return  translate.translation.get(0);
	}

	public static List<String> splitSentence(String str) {
		List<String> sentence = new ArrayList<String>();
		String commas[] = str.split(",");
		for (String comma : commas) {
			sentence.add(comma);
		}
		return sentence;
	}

	public static String translateSentence(String str){
		String cn_str = "";
		for (String s : splitSentence(str)) {
			cn_str += sendYouDao(s)+",";
		}
		return cn_str;
	}
	
	public static void main(String[] args){
		Logger.info(sendYouDao(""));
	}

}
