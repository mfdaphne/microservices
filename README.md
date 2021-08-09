# Microservices

Microservices are small self-contained ready to run group of applications. Read more about it here - https://spring.io/microservices

![](https://spring.io/images/diagram-microservices-88e01c7d34c688cb49556435c130d352.svg)

Below microservices are implemented in the respective projects:

- user-app - contains endpoints to create user, and get user by ID. This also gets the corresponding Subscription details of the user by direct call to subscription-app through our gateway
- subscription-app - contains endpoints to create subscription and get subscription by ID.
- shopping-gateway - all microservices will be accessed through this gateway. This contains route mapping and Circuit breaker configuration to redirect URL to another endpoint when something goes wrong in the service. Its also configured to send data to Hystrix Server.
- service-registry - This acts as Eureka Server. Gets information of all applications configured as Eureka client. http://localhost:8761/
- hystrix-dashboard - Read more about the usage here https://github.com/Netflix-Skunkworks/hystrix-dashboard/wiki
- cloud-config-server - All common configurations are extracted to a common application.yml(in Github) and used over all spring boot applications. In order to activate this feature bootstrap.yml is created in the client apps with the cloud-config property.
