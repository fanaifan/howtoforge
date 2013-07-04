package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YouDaoKey {
	
	public static final String Key = 
		      "API key：995758606,keyfrom：China-Howtoforge;" +
			  "API key：181152821,keyfrom：howtoforge1;" +
		      "API key：1428057157,keyfrom：downtogo;" +
		      "API key：1091546470,keyfrom：luoser;";

	public static Map<String, String> getAPIKey(int c) {
		List<Map<String,String>> keys = new ArrayList<Map<String,String>>(); 
		String[] keyfroms = Key.split(";");
		for(String keyform : keyfroms){
			String[] apikeys = keyform.split(",");
			Map<String,String> map = new HashMap<String,String>();
			for(String apikey : apikeys){
				String[] key = apikey.split("：");
				map.put(key[0].trim(), key[1].trim());
			}
			keys.add(map);
		}
		return keys.get(c);
	}


}
