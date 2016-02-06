FROM java:8
ADD build/libs/netflix-zuul-0.0.1-SNAPSHOT.jar .
CMD java -jar netflix-zuul-0.0.1-SNAPSHOT.jar -Djava.security.egd=file:/dev/./urandom
EXPOSE 8080
