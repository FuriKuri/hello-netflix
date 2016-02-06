FROM finntech/java8minimal
ADD build/libs/netflix-eureka-0.0.1-SNAPSHOT.jar .
CMD java -Djava.security.egd=file:/dev/./urandom -jar netflix-eureka-0.0.1-SNAPSHOT.jar
EXPOSE 8761
