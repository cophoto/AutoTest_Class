package com.demos.httpclientdemo;
import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import java.io.IOException;

public class SalesforceTest {

    private static String getSalesForceToken() throws IOException {

        String getTokenUrl = "https://login.salesforce.com/services/oauth2/token";
        String grant_type = "password";
        String username = "daviddemo2@163.com";
        String password = "";
        String client_id = "3MVG9d8..z.hDcPKr_.DMFFAtQyqhYunDq.kNex9foBdqnsaKX9JUqlenPBDKlnrL2qRGQwoohNhtLRJuK.Yn";
        String client_secret = "5199409257295918746";

        //获取token的链接和请求参数
        String endpoint = getTokenUrl + "?" + "grant_type=" + grant_type +
                "&client_id=" + client_id + "&client_secret=" +
                client_secret + "&username=" + username + "&password=" + password;
        System.out.println("Endpoint is : " + endpoint);

        CloseableHttpClient req = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(endpoint);

        CloseableHttpResponse response = req.execute(httpPost);

        HttpEntity entity = response.getEntity();

        String result = EntityUtils.toString(entity);

        JSONObject jsonResult = new JSONObject(result);

        return jsonResult.getString("access_token");
    }

    public static void main(String[] args)
    {
        try {
            String tokens = SalesforceTest.getSalesForceToken();
            System.out.println("access_token:"+tokens);
        }
        catch(IOException i){
            System.out.println((i.toString()));
    }

    }
}
