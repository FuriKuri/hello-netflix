FROM anapsix/alpine-java:jdk8
ADD build/libs/netflix-account-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","netflix-account-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
