### **Task**

1. Install Gradle.
2. Assemble custom jar utils-1.3.5.jar. It should be compatible with java 8.  
   The manifest file should contain the name and version of your jar.  
   The jar should contain class StringUtils with method boolean isPositiveNumber(String str).  
   Use Apache Commons Lang 3.10 library to implement this method. Write one any unit test for  
   your StringUtils.isPositiveNumber(String str) using JUnit 5.+.
3. Create a project multi-project with two subprojects core and api.  
   The core subproject should contain class Utils with method boolean isAllPositiveNumbers(String... str).  
   Use utils-1.3.5.jar from the previous task to implement this method.  
   The api subproject should contain class App with the main method.  
   Call Utils.isAllPositiveNumbers("12", "79") from the main method of api subproject.

### **In addition**

1. Make a Gradle plugin that also publish and connect to the project.
2. As an example of plugin functionality - testing and report generation.
3. Convert the test task to Gradle (if it used Maven or others).

### **You can find the library utils-1.3.5 in the following repository**

https://github.com/Alivit/gradle_util
