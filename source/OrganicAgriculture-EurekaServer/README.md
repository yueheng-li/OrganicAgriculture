

# MAVEN JAR
* mvn package -Dmaven.test.skip=true
* eurekaServer-1.0.0.jar 生成
# Docker
* mkdir /opt/docker-file/mirco-service
* cp eurekaServer-1.0.0.jar and Dockerfile to /opt/docker-file/mirco-service
* cd /opt/docker-file/mirco-service
* docker build -t lichunhui:v1 .
### 
Digest: sha256:34959eed5df6bfe74a17fbf459ed29505d51a48d5cb4a39f215b613c65b8023b
Status: Downloaded newer image for java:8
 ---> d11c3799fa6a
Step 1 : VOLUME /tmp
 ---> Running in dc4a7c8fa9b7
 ---> a98c01067534
Removing intermediate container dc4a7c8fa9b7
Step 2 : ADD eurekaServer-1.0.0.jar app.jar
 ---> 2ff85c66a60c
Removing intermediate container b956546b3f84
Step 3 : RUN bash -c 'touch /app.jar'
 ---> Running in 62a756bd51b6
 ---> e92ad9ce8b9b
Removing intermediate container 62a756bd51b6
Step 4 : ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
 ---> Running in 9d36eabd2e5e
 ---> c9a3ee7e48bb
Removing intermediate container 9d36eabd2e5e
Successfully built c9a3ee7e48bb
### 

* docker run -d -p 8761:8761 lichunhui:v1
* docker ps

# 確認
http://ip:8761/
启动后
![image](https://github.com/yueheng-li/OrganicAgriculture/blob/devlop/source/OrganicAgriculture-EurekaServer/eureka-server.PNG)
