FROM java:8
ADD build/libs/netflix-turbine-0.0.1-SNAPSHOT.jar .
RUN apt-get update && apt-get install haveged -y
CMD java -jar netflix-turbine-0.0.1-SNAPSHOT.jar
EXPOSE 8989
