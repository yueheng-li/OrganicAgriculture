spring boot actuator追加（监控运行状况）
pom.xml 下面jar依赖添加
<!-- monitor -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

http://localhost:8080/organic/health
{"status":"UP"}