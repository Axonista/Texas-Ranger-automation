Prerequisites :
#Java JDK 17
#Eclipse IDE
#Maven 3.0
#Using WebDriverManager for testing.
#When running "Test1_regionwarningTest" if test fails after clicking on continue button or after clicking Sign in page does not appear, its because VPN is not connected.
VPN should be connected to USA - Dallas otherwise actions will not work in script.
#Framework : TestNG
#Environment variables are stored in .env file

  
#Setup Instructions : Steps to Pull Project from Git into any IDE and run tests.
• Clone the Repository
   Open a terminal or command prompt and run:
   git clone https://github.com/Axonista/Texas-Ranger-automation.git
   cd /Users/sailydhande/git/repository/sailyassignment
   This downloads the project into a folder named repository (or whatever your repo is called).

• Check for Build Tool (Maven)
   Look for one of these files in the root of the project : pom.xml(These files tell the IDE or CLI how to build and run the project.)

• Open in Any IDE
   IntelliJ IDEA / Eclipse / VS Code
   You don’t need to import manually — most modern IDEs auto-detect Maven.

   Maven Project :
   Open the project folder.
   IDE will detect the pom.xml and prompt you to import it.
   If not prompted, use:
   -IntelliJ: File > Open → select pom.xml
   -Eclipse: File > Import > Existing Maven Projects
   -VS Code: Install Java Extension Pack → open the folder.

• Build the Project : mvn clean install
• Run the App or Tests : mvn test

 
#Test Reporting:
Post-import Steps Java Build Path: Right-click → Properties → Java Build Path → Verify JDK version is Java 17. Maven Update: Right-click → Maven → Update Project.
Run Tests: If testng.xml is present, right-click → Run As → TestNG Suite
Test Report :
• Click on sailyassignment -> test_output -> index.html.
• Right click to see options and click Open With -> Web Browser.
• Test Report will open in browser.
