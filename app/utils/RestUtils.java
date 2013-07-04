package utils;

import javax.ws.rs.core.MediaType;

import play.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;


/**
 * Rest请求处理类
 * 针对Jersey框架提供的RestAPI接口调用的封装
 * @author zp
 *
 */
public class RestUtils {

	/**
	 * 使用本类需要了解的概念
	 *  1. 基础地址变量：
	 *  |http://127.0.0.1/system_context | /getinfo  		| /name/a.json  	|
	 *  |系统部署地址                      | 类Path    		| 方法Path       	|
	 *  |Rest服务器地址					 | RestAPI接口		| RestAPI接口地址	    |
	 *  |server	                         | restURI		    | path 		        |
	 */
	public static Client  c = null;
	public static Client getClient(){
		if(c == null){
			ClientConfig config = new DefaultClientConfig();
			config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
			c = Client.create(config);
		}
		return c;
	}

	/**
	 * 创建JerseyClient实例
	 * @param server Rest服务器地址
	 * @param restURI  RestAPI接口
	 * @return  webResource
	 */
	public static WebResource getWebResource(String server, String restURI){
		WebResource webResource = getClient().resource(server+restURI);
		return webResource;
	}


	
	/**
	 * GET请求的处理
	 * @param server	 Rest服务器地址
	 * @param path		 RestAPI接口地址
	 * @return 服务器返回内容
	 */
	public static String getRest(String server, String path) {

		String str = null;
		try {
			ClientResponse response = getWebResource(server, path)
					.header("Content-Type", MediaType.APPLICATION_JSON)
					.type(MediaType.APPLICATION_JSON)
					.get(ClientResponse.class);
			str = response.getEntity(String.class);

		} catch (Throwable t){
			t.printStackTrace();
		}
		return str;
	}


}