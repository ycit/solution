package com.ycit.webservice;

import com.ycit.WeatherWebService;
import com.ycit.WeatherWebServiceLocator;
import com.ycit.WeatherWebServiceSoap_PortType;
import org.junit.Test;

/**
 * Created by xlch on 2016/11/24.
 */
public class CallJavaCode {

    @Test
    public void getSupportProvince() throws Exception {
        WeatherWebService service = new WeatherWebServiceLocator();
        WeatherWebServiceSoap_PortType soap = service.getWeatherWebServiceSoap();
        String[] results = soap.getSupportProvince();
        for (String result : results) {
            System.out.println(result);
        }
    }

    @Test
    public void getWeather() throws Exception {
        WeatherWebService service = new WeatherWebServiceLocator();
        WeatherWebServiceSoap_PortType soap = service.getWeatherWebServiceSoap();
        String[] results = soap.getWeatherbyCityName("苏州");
        for (String result : results) {
            System.out.println(result);
        }
    }

}
