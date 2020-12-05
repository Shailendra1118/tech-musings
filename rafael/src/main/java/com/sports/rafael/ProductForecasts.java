package com.sports.rafael;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class ProductForecasts{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //called from microservice
        int year = 2014;
        // Start the clock
        long start = System.currentTimeMillis();
        ProductForecasts app = new ProductForecasts();
        List<String> products = app.getProductsWithExceededOrders(year);
        System.out.println(products);
    }


    public List<String> getProductsWithExceededOrders(int year) throws InterruptedException, ExecutionException {
        List<String> res = null;
        CompletableFuture<ApiResult> forecast = this.getOrdersForecast(2020);
        CompletableFuture<ApiResult> actual = this.getActualOrders(2020);
        CompletableFuture.allOf(forecast, actual).join();
        System.out.println("Forecast: "+forecast.get());
        System.out.println("Actual: "+actual.get());

        return res;
    }




    @Async
    public CompletableFuture<ApiResult> getOrdersForecast(int year) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        RestTemplate client = new RestTemplate();
        String url = String.format("https://assessments.reliscore.com/api/forecast/%s/", year);
        ApiResult results = client.getForObject(url, ApiResult.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }

    @Async
    public CompletableFuture<ApiResult> getActualOrders(int year) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        RestTemplate client = new RestTemplate();
        String url = String.format("https://assessments.reliscore.com/api/orders/%s/", year);
        ApiResult results = client.getForObject(url, ApiResult.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }




    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("product-api-");
        executor.initialize();
        return executor;
    }

    @ToString
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class ApiResult {
        private String status;
        private Map<String, Integer> data;
    }



}
