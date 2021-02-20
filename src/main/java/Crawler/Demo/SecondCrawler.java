package Crawler.Demo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
/***
 *案例二
 *
 *爬虫过程
 *
 * 1.创建httpclient客户端
 * 2.创建HttpGet对象
 * 3.通过httpclient传递get请求
 * 4.判断是否请求成功
 *      4.1如果请求成功输出相关内容
 * 5.关闭httpclient的连接
 */
public class SecondCrawler {
    public static void main(String[] args) throws  IOException {

        //1.创建httpclient客户端
        CloseableHttpClient httpClients = HttpClients.createDefault();

        //2.创建HttpGet对象
        HttpGet httpGet = new HttpGet("www.itcase.cn");

        //3.通过httpclient传递get请求
        CloseableHttpResponse response = null;
        try {
            response = httpClients.execute(httpGet);
            //4.判断是否请求成功
            if (response.getStatusLine().getStatusCode()==200){
                //4.1如果请求成功输出相关内容
                String context = EntityUtils.toString(response.getEntity());
                System.out.println(context);
            }
        } catch (IOException e) {
            //发生异常，则抛出异常
            e.printStackTrace();
        }finally {
            //5.关闭httpclient的连接
            response.close(); //编译失败，抛出
        }

        //4.判断是否请求成功
            //4.1如果请求成功输出相关内容
        //5.关闭httpclient的连接
    }
}
