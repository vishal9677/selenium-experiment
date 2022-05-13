# Selenium Experiment
A simple selenium grid setup in docker

## Prerequisites
- Docker (For running in grid)
- Maven (For local run)
- Java 11 (For local run)

## Test run
The test scripts can be executed using below commands

To execute the test scripts in local navigate to project directory and execute the below command
```
mvn clean test
```

To execute the test scripts in grid based setup navigate to project directory execute the below command
```
docker-compose up
```

To run the tests in IDE use the below configuration
<img width="1032" alt="Screenshot 2022-05-13 at 9 41 01 AM" src="https://user-images.githubusercontent.com/105441387/168209705-92765da8-7d75-491f-bbaa-6474e0e2b43a.png">

Test reports for grid run can be found under reports directory

<img width="422" alt="Screenshot 2022-05-13 at 10 13 55 AM" src="https://user-images.githubusercontent.com/105441387/168212704-306e2600-c206-472d-a1c9-67e575b9d8ba.png">

### Frameworks used
- Selenium 4 for UI automation
- Maven as build tool
- Junit 5 as test runner
- Spring-context for dependency injection
- Hamcrest for assertions

### Upcomming releases
- Need to add proper logging and reporting
- Support for other browsers
- Parallel execution
