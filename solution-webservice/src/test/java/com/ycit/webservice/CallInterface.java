package com.ycit.webservice;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import java.util.Vector;


/**
 * Created by xlch on 2016/11/24.
 */
public class CallInterface {

    @Test
    public void getWeather() {
        String endPoint = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?WSDL";//提供接口的地址,也可去掉后面的 "?WSDL"
        String targetNamespace = "http://WebXml.com.cn/";
        String methodName = "getWeatherbyCityName";
        String soapAction = targetNamespace + methodName;   //详情打开 endPoint链接 搜索 soapaction 即可查看 soapaction
        String paramName = "theCityName";
        String paramValue = "苏州";
        Service service = new Service();
        try {
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(endPoint);
            call.setOperationName(new QName(targetNamespace, methodName)); //设置要调用哪个方法
            call.addParameter(new QName(targetNamespace, paramName), XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(new QName(targetNamespace, methodName), Vector.class); //要返回的数据类型（自定义类型）
//             call.setReturnType(XMLType.XSD_STRING);//（标准的类型）
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(soapAction);
            Vector v = (Vector) call.invoke(new Object[]{paramValue});//调用方法并传递参数
            for (int i = 0; i < v.size(); i++) {
                System.out.println(v.get(i));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
