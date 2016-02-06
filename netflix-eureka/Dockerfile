FROM java:8
ADD build/libs/netflix-eureka-0.0.1-SNAPSHOT.jar .
RUN apt-get update && apt-get install haveged -y
CMD java -jar netflix-eureka-0.0.1-SNAPSHOT.jar
EXPOSE 8761
