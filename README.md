# Movie Booking
Project uses microservices approach to cover different aspects of Movie Booking Application. Microservices are as following
  - Movie Service : For Adding New Movies, Cast, Categories
  - Theatre Service : Add New Theatre, Add Screens to Theatre, Add New Shows, Pricing Per show
  - Booking Service : Book seats for a show in a Theatre

## Components
   - NamingServer : default port `8761`
   - API Gateway : default port `8010`
   - Movie Service : default port `8020`
   - Theatre Service : default port `8030`
   - Booking Service : default port `8040`
   
   API configuration for Movie, Theatre, Booking Services can be accessed via `http://localhost:`{PORT}`/swagger-ui.html/`
