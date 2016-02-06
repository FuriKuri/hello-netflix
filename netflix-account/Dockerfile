FROM finntech/java8minimal
ADD build/libs/netflix-account-0.0.1-SNAPSHOT.jar .
CMD java -Djava.security.egd=file:/dev/./urandom -jar netflix-account-0.0.1-SNAPSHOT.jar
EXPOSE 8080
