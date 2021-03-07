# Movie Booking
Project uses microservices approach to cover different aspects of Movie Booking Application. Microservices are as following
  - Metadata Service : For Adding Movie Resources(i.e Images, Videos, Cast Details) on AWS S3 (for resources) & MongoDB
  - Core Service : Adding New Movies, New Theatre, Add Screens to Theatre, Add New Shows, Pricing Per show
  - Booking Service : Book seats for a show in a Theatre
  - Auth Server : OAuth Implementation for keeping microservices Secured
  - Eureka Naming Server : Microservice Registry & Discovery
  - API Gateway : Gateway to connect to resource microservices 

## Components
   - NamingServer : default port `8761`
   - API Gateway : default port `8010`
   - Metadata Service : default port `8020`
   - Core Service : default port `8030`
   - Booking Service : default port `8040`
   - Auth Server : default port `8050`
   
   API configuration for Movie, Theatre, Booking Services can be accessed via `http://localhost:{PORT}/swagger-ui.html/`
