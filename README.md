PROJECT: Hello World Microservices Application
OVERVIEW:
This project demonstrates the basic concepts of microservices architecture by creating a simple "Hello World" application. The application consists of two microservices developed using Java Spring Boot.
Hello Service: Returns a greeting message "Hello".
World Service: Returns the message "World".
These services are containerized using Docker and deployed on a Kubernetes cluster. The output message "Hello World" is obtained by integrating the responses from both services.

STEPS FOLLOWED TO FULFILL THE ABOVE REQUIREMENT:
1. Setting up the Development Environment
->Install latest java JDK 
->Install maven
->Install Docker Desktop
->Setup the local minikube cluster using Minikube
2. Creating MicroServices
The services are springboot applications and returns "hello" and "world" strings from the respective controllers.
-> HELLO SERVICE
It has "hello" as endpoint.
It gives "hello" as response.
-> WORLD SERVICE
It has "world" as endpoint.
It gives "world" as response.
3. Containerizing the microservices using Docker
->Create the dockerfiles for each services (hello and world) in its root directory.
->Navigate to the helloservice directory and build the docker image for helloservice using command:
        docker build -t hello-service:latest .
->Run the helloservice docker image using:
        docker run hello-service:latest
-> To run the container :
   docker run -d -p 8080:8080 --name hello-service-container hello-service:latest
After running the container springboot application is accessible http://localhost:8080/hello
->Navigate to the worldservice directory and build the docker image for worldservice using command:
   docker build -t world-service:latest .
->Run the worldservice docker image using:
   docker run world-service:latest
-> To run the container : 
    docker run -d -p 8081:8080 --name world-service-container world-service:latest
After running the container springboot application is accessible http://localhost:8081/world
4. Push the docker images to docker hub
-> login to docker hub
    docker login
->Tag and push the images
    docker tag hello-service:latest vinutapatil/hello-service:latest
    docker push vinutapatil/hello-service:latest
   docker tag world-service:latest vinutapatil/world-service:latest
   docker push vinutapatil/world-service:latest
5. Deploy to kubernetes
->Update the kubernetes manifests to use the docker images from docker hub
->created hello-service.yaml and world-service.yaml
-> To apply manifests to kubernetes cluster run:
   kubectl apply -f hello-service.yaml
   kubectl apply -f world-service.yaml
-> To check the deployment and services status:
   kubectl get deployments
   kubectl get services 
-> Get the urls for the services hello and world:
   minikube service hello-service -n default --url
   minikube service world-service -n default --url 
The above commands gives the new url for each run.
6. Integration testing
 written a simple integration test script to call both the services and to combine their responses.
 file name: helloworld.ps1
7. Update the hello_url and world_url in helloworld.ps1 each time we run the hello-service and world-service.
    Then run helloworld.ps1 using ./helloworld.ps1 command to get the combined result "Hello World"
8. url for docker hub hello-service repository:
   https://hub.docker.com/repository/docker/vinutapatil/hello-service/general
9. url for docker hub world-service repository:
   https://hub.docker.com/repository/docker/vinutapatil/world-service/general