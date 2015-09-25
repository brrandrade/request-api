# Request API

 The purpose of this project is to show how a simple request API can be developed using the most used java libraries in the market as:

 - Spring Framework ( without XML)
 - Jersey 
 - Jackson
 - Maven 
 - Mockito 
 - Junit4
 - Commons lang 
 - Log4j

The API used in this project 
http://api.goeuro.com/api/v2/position/suggest/en/

After receiving "Berlin" via command line, the API will be
http://api.goeuro.com/api/v2/position/suggest/en/Berlin

The return of this API will be around below

```javascript
[

 {

 _id: 377078,
 key: null,
 name: "Potsdam",
 fullName: "Potsdam, Germany",
 iata_airport_code: null,
 type: "location",
 country: "Germany",

 geo_position: {
 latitude: 52.39886,
 longitude: 13.06566
 },
 location_id: 377078,
 inEurope: true,
 countryCode: "DE",
 coreCountry: true,
 distance: null
 },

 {
 _id: 410978,
 key: null,
 name: "Potsdam",
 fullName: "Potsdam, USA",
 iata_airport_code: null,
 type: "location",
 country: "USA",

 geo_position: {
 latitude: 44.66978,
 longitude: -74.98131
 },

 location_id: 410978,
 inEurope: false,
 countryCode: "US",
 coreCountry: false,
 distance: null
 }
 ]
```

Then, after parse the result, a csv file will be created with the columns
_id, name, type, latitude,longitude

## Usage

Note, this project was created with Spring Tool suite (STS) and it doesn't mean you can't use others IDEs as (InteliJ, Eclipse....)

Running the project

The package will be in target folder, you can execute using the command below

	java -jar request-api-x.x.x-SNAPSHOT.jar "Berlin"

On the same folder, a csv file will be created with name

    System.currentTimeMillis() + ".csv" 

as example it could be

    1443193089202.csv

## STS Dev Details

Image********

Main class 
`com.engyes.request.api.Application` defined as

```java
@Configuration
@ComponentScan( basePackages = "com.engyes.request" )
@PropertySource( { "classpath:application.properties" } )
public class Application {

	public static void main( String[] args ) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext( Application.class );
		ctx.getBean( RequestApi.class ).run( args );
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
```

As you can see the project is clean, it doesn't use xml to configure beans.

You can also change the main properties direct on properties file which is inject in the project by spring.

### Build

	mvn package
      
then check `target` directory for update project archive `request-api-x.x.x-SNAPSHOT.jar`.

There is also a original jar wihout dependencies in the folder `target` with name `original-request-api-x.x.x-SNAPSHOT.jar` 

### Test

	mvn test
      
It will run the full test on project, the API is mocked, so, it will not make a real connection, instead, it will provide a fake return.

The csv will be created and deleted after each test.


### History

- 1.0 Initial version
