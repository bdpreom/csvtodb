 # gradle bootRun
 -port 9191
 

- REQUEST
POST http://localhost:9191/api/csv/upload

   #reponse : {
  "message": "Uploaded the file successfully: subscriber.csv"
  }
- REQUEST GET  http://localhost:9191/api/csv/subscribers
   
   #response {
  {
  "id": 1,
  "username": "bhaia",
  "subscriber_name": "x"
  },
  {
  "id": 2,
  "username": "bhaib",
  "subscriber_name": "y"
  },
  {
  "id": 3,
  "username": "bhaic",
  "subscriber_name": "z"
  } }





– CSVHelper provides functions to read/write to CSV file.

– Subscriber data model class corresponds to entity and table subsriber.
– SubscriberRepository is an interface that extends JpaRepository for persisting data.

– CSVService uses CSVHelper and TutorialRepository methods to save CSV data to MySQL, load data to export CSV file, or get all Subscriber from MySQL table.

– CSVController calls CSVService methods and export Rest APIs: upload CSV file, get data from MySQL database.

– FileUploadExceptionAdvice handles exception when the controller processes file upload.

– @CrossOrigin is for configuring allowed origins.
– @Controller annotation indicates that this is a controller.
– @GetMapping and @PostMapping annotation is for mapping HTTP GET & POST requests onto specific handler methods:

    POST /upload: uploadFile()
    GET /subscribers: getAllSubscriebrs()

– application.properties contains configuration for Spring Data and Servlet Multipart file.

        spring.servlet.multipart.max-file-size: max file size for each request.
        spring.servlet.multipart.max-request-size: max request size for a multipart/form-data.


