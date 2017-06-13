

## spring boot actuator追加（监控运行状况）

pom.xml 下面jar依赖添加

```java
<!-- monitor -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

http://localhost:8080/organic/health

{"status":"UP"}
```

## 系统构建图
### OrganicAgriculture-LoadBalanced
Zuul和Feign实现sample做成。

### OrganicAgriculture-EurekaServer
Eureka服务注册实现sample做成。

### OrganicAgriculture-EurekaClient
服务客户端(世界的服务)实现sample做成。

* Eureka：实际上在整个过程中维护者每个服务的生命周期。每一个服务都要被注册到Eureka服务器上，这里被注册到Eureka的服务又称为Client。Eureka通过心跳来确定服务是否正常。Eureka只做请求转发。同时Eureka是支持集群。
* Zuul：类似于网关，反向代理。为外部请求提供统一入口。 
* Ribbon/Feign：可以理解为调用服务的客户端。 
* Hystrix：断路器，服务调用通常是深层的，一个底层服务通常为多个上层服务提供服务，那么如果底层服务失败则会造成大面积失败，Hystrix就是就调用失败后触发定义好的处理方法，从而更友好的解决出错。也是微服务的容错机制。

![image](https://github.com/yueheng-li/OrganicAgriculture/blob/devlop/source/springcloud.PNG)

