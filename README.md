# citiesconnect


About the project : 

        This project is to create an API which can be used to find if two cities are connected through a series of roads.
        Data, thats provided as a text file helps to find if cities are connected.

Built with : 

        JDK 1.8, Spring Boot, Maven, Git, Eclipse, ReST, Junit, Mockito, sl4j, jacoco

About the API : 

          URL

          http://localhost:9009/connected?origin=city1h&destination=city2

          Method:

          GET 

          URL Params

      
          Required:

          origin=[String]
          
          destination=[String]


          Success Response:

          A String either saying 'yes' or 'no'
          Code: 200
          

Building,  running tests and test coverage :

    Build with Maven. Use command 'mvn clean install'
    
    Jacoco, a test coverage  test coverage is set to 90 % in pom.xml. If the test covearge is  less than 90%, build fails.

     Tests run with command 'mvn  test'.
