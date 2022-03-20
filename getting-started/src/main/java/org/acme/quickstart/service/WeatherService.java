package org.acme.quickstart.service;

import io.smallrye.mutiny.Uni;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherService {

    private WeatherProperties properties;

    public WeatherService() {
    }

    public WeatherService(WeatherProperties properties) {
        this.properties = properties;
    }

    public Uni<String> printCity() {
        return Uni.createFrom().item(() -> {return "当前城市： " + properties.getCity();});
    }

    public Uni<String> getCityWeather(String city)  {

        return Uni.createFrom().item(()->{
            String url = "http://wthrcdn.etouch.cn/weather_mini?city=" + city;
            OkHttpClient okHttpClient = new OkHttpClient();
            final Request request = new Request.Builder()
                    .url(url)
                    .build();
            final Call call = okHttpClient.newCall(request);
            Response response = null;
            String ret = null;
            try {
                response = call.execute();
                ret = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("查询天气数据：" + ret);
            return ret;
        }).onFailure().recoverWithItem("");


    }

    public Uni<String> getCityWeather() {
        return getCityWeather(properties.getCity());
    }

}
