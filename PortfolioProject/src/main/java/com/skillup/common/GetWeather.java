package com.skillup.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetWeather {
	
	
	public static String GetWeather(String location) {
        BufferedReader br = null;
        String result = "";
        try{            
            String urlstr = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?serviceKey="+Constants.ApiKey+"&numOfRows=1&pageNo=1&stationName="+location+"&dataTerm=DAILY&ver=1.3&_returnType=json";
            URL url = new URL(urlstr);
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
           
            String line;
            while((line = br.readLine()) != null) {
                result +=  line ;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}

