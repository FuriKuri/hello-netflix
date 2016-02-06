FROM anapsix/alpine-java:jdk8
ADD build/libs/netflix-eureka-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","netflix-eureka-0.0.1-SNAPSHOT.jar"]
EXPOSE 8761
