FROM java:8
ADD build/libs/netflix-catalog-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","netflix-catalog-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
