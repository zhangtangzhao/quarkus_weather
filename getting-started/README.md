启动命令：mvn clean compile quarkus:dev

## api接口：
### 获取配置的城市
http://127.0.0.1:8081/api/currentcity  

### 获取配置的城市的天气
http://127.0.0.1:8081/api/weather  

### 获取配置的自定义城市的天气 {city}为城市
http://127.0.0.1:8081/api/weather/{city}  

## 配置文件 application.properties
### 设置是否获取配置的城市的接口 
weather.enable 

## 表示设置默认的城市
weather.city