package com.jongh.star.weather;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;


@Service
public class WeatherDAO {
	public static void weather(HttpServletRequest req, HttpServletResponse res) {
		try {
			URL u = new URL("http://api.openweathermap.org/data/2.5/weather?q=Seoul&units=metric&appid=f909790638d1446210f179910acaa4c5&lang=kr"); 
			
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(isr);
			Wearther w = new Wearther();
			JSONArray wearther = (JSONArray) jo.get("weather");
			JSONObject wearther2 = (JSONObject) wearther.get(0); 
			JSONObject main = (JSONObject) jo.get("main");
			w.setDescription((String) wearther2.get("description"));
			w.setIcon((String) wearther2.get("icon"));
			w.setTemp(Double.parseDouble(main.get("temp").toString()));
			
			w.setHumidity(Double.parseDouble(main.get("humidity").toString()));
			
			req.setAttribute("w", w);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
