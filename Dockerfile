FROM openjdk:11
ADD target/parking_system_rest_api_application.jar parking_system_rest_api_application.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","parking_system_rest_api_application.jar"]