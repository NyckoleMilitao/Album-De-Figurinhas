package com.prj.albumdefigurinhas.view;



import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class HttpClientUtils {

     private static final HttpClient httpClient = HttpClients.createDefault();
     private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String doGet(String url) throws IOException {
        HttpGet request = new HttpGet(url);

        try (CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity);
            }
        }

        return null; // ou uma string vazia, dependendo do comportamento desejado
    }

    public static <T> ResponseEntity<T> doPost(String url, Object requestBody, Class<T> responseType) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        String requestBodyJson = objectMapper.writeValueAsString(requestBody);
        StringEntity stringEntity = new StringEntity(requestBodyJson);
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Content-type", "application/json");

        HttpResponse httpResponse = httpClient.execute(httpPost);
        String responseBody = EntityUtils.toString(httpResponse.getEntity());

        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK.value()) {
            T response = objectMapper.readValue(responseBody, responseType);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



    public static <T> ResponseEntity<T> doPut(String url, Object requestBody, Class<T> responseType) throws IOException {
        HttpPut httpPut = new HttpPut(url);
        String requestBodyJson = objectMapper.writeValueAsString(requestBody);
        StringEntity stringEntity = new StringEntity(requestBodyJson);
        httpPut.setEntity(stringEntity);
        httpPut.setHeader("Content-type", "application/json");

        HttpResponse httpResponse = httpClient.execute(httpPut);
        String responseBody = EntityUtils.toString(httpResponse.getEntity());

        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            T response = objectMapper.readValue(responseBody, responseType);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public static ResponseEntity<Void> doDelete(String url) throws IOException {
        HttpDelete httpDelete = new HttpDelete(url);

        HttpResponse httpResponse = httpClient.execute(httpDelete);

        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public static <T> ResponseEntity<T> doGet(String url, Class<T> responseType) throws IOException {
        HttpGet httpGet = new HttpGet(url);

        HttpResponse httpResponse = httpClient.execute(httpGet);
        String responseBody = EntityUtils.toString(httpResponse.getEntity());

        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            T response = objectMapper.readValue(responseBody, responseType);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
