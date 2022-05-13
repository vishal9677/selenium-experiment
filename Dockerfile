FROM maven:3.8.5-jdk-11
WORKDIR /usr/projects/selenium-experiment
ADD pom.xml pom.xml
RUN mvn clean package
ADD . .
ENV HOST_URL $HOST_URL
ENV TEST_EXEC_ENV $TEST_EXEC_ENV
ENTRYPOINT mvn test
