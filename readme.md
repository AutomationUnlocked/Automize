A complete test framework for Web , mobile and api automation.

### Components Used
Test Runner: TestNG

#### Way of Executing Tests
* Run as a testng class
* Run from the testng.xml
* Run from maven
  * open Terminal at respective module
  * WebModule % mvn test -DsuiteXml=src/test/resources/testng.xml


To see the report under Coreproject/testreports/ , please add the listener in suite file(testng.xml)

Execute the tests from xml file to generate the report.
Report will be found in CoreProject/testReports/index.html

Run the test from the testng.xml file


## Performance Test
* Using Jmeter to do performance test
* Create/update the jmx file using GUI mode

### Executing Performance test in local
* download the jmx file from PerformanceTestModule/src/test/jmeter/FlaskAPITestPlan.jmx
* open terminal and execute the below command
```shell 
jmeter -n -t FlaskAPITestPlan.jmx -l jmeterresults/results.jtl -e -o jmeterWebReport -Jusers=100 -Jrampup=10 -Jloops=10 -Jjmeter.reportgenerator.overall_granularity=1000
```
* Results could be seen in the jmeterWebReport folder

### Executing Performance test using Jenkins 
#### in the build step, add execute shell command
```shell 
/usr/local/Cellar/jmeter/5.6.3/bin/jmeter -n -t PerformanceTestModule/src/test/jmeter/FlaskAPITestPlan.jmx -l PerformanceTestModule/results.jtl -e -o PerformanceTestModule/jmeterWebReport -Jusers=100 -Jrampup=10 -Jloops=10 -Jjmeter.reportgenerator.overall_granularity=1000
```
#### in the Post Build Actions
* add HTML report 
* add Performance Test Report




