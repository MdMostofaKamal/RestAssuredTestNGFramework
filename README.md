# RestAssuredTestNGFramework
## An API is tested by using REST Assured framework integrated with TestNG as testing framework for validation purpose. Here, the status codes, validation messages and the flow of API is tested using a Spotify API where there is Authentication,Get Token,Renew Access Token,creating,Geting and Updating features
### The tools and technology are used:
- Rest Assured
- TestNG 
- Java
- Allure Reports
- Hamcrest
- jackson Api
- Lombok
### Prerequisites
- Install jdk 11 or any LTS versio
- Configure JAVA_HOME and MAVEN_HOME
- Download Allure and configure environment path
- Download Jenkins and configure it with cmd commannd 
### Project Run
- Clone the repository
- Open cmd in the root folder
#### Run the Automation Script by the following command:
 ```
 mvn test -DBASE_URI="https://api.spotify.com" -DACCOUNT_BASE_URI="https://accounts.spotify.com"
  ```
 ### After automation to view allure report , give the following commands:
  ```
 allure serve target/allure-results
  ```
 ### Allure report overview:
![AllureReport1](https://user-images.githubusercontent.com/47362218/211996851-641931e6-4df5-4b78-bf63-cab53e1362c0.PNG)
![AllureReport2](https://user-images.githubusercontent.com/47362218/211996881-a5b728d1-ae36-4f14-9684-b46875c48caf.PNG)
![AllureReport3](https://user-images.githubusercontent.com/47362218/211996909-3b2fa9f3-0b51-4b9a-822d-1f98830854c0.PNG)

