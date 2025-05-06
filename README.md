Prerequisites :
* Java JDK 17
* Eclipse IDE
* Maven 3.0
* Chrome browser and compatible ChromeDriver(Ensure ChromeDriver version matches your installed Chrome browser)
* VPN should be connected to USA - Dallas otherwise actions will not work in script.
Setup Instructions : Steps to Pull Project from Git into Eclipse . Clone a Git Project Using Eclipse Git Integration (EGit)
1. Open Eclipse
2. Go to File → Import
3. Choose: Git → Projects from Git . Click Next.
4. Select Clone URI. Click Next.
5. Enter Repository URI Paste your Git repository URL : https://github.com/Axonista/Texas-Ranger-automation
6. Enter credentials if it's a private repo. Click Next.
7. Select branche to clone( master). Click Next.
8. Choose a local directory to clone the repo into. Click Finish
9. After cloning, Eclipse will ask: Import Existing Projects
10. Select your project folder.
11. Click Finish.
Choose a local directory to clone the repo into Click Finish
Post-import Steps Java Build Path: Right-click → Properties → Java Build Path → Verify JDK version is Java 17. Maven Update: Right-click → Maven → Update Project.
Run Tests: If testng.xml is present, right-click → Run As → TestNG Suite
Test Report :
1. Click on test_output - > index.html.
2. Right click to see options and click Open With -> Web Browser.
3. Test Report will open in browser.
