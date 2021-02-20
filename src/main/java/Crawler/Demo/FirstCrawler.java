package Crawler.Demo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class FirstCrawler {
    public static void main(String[] args) throws IOException {
        //测试程序正常运行
        System.out.println("wo");

        //1.打开浏览器，创建httpclients对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.输入网址，创建HttpGet对象发出get请求
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        //3.使用httpClient对象发送httpget请求,
        CloseableHttpResponse response = httpClient.execute(httpGet);    //可能出现io异常
        //4.根据响应返回数据
        //判断响应状态码是否为200
        if (response.getStatusLine().getStatusCode() == 200){
            System.out.println("成功解析");
        }
    }
}
