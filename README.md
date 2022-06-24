# flatten-json
Simple java program which accepts a json input and converts it into a flattened json string.
Example:
//Input
{
    "a": 1,
    "b": true,
    "c": {
        "d": 3,
        "e": "test"
    }
}
//Flattened output
{
    "a": 1,
    "b": true,
    "c.d": 3,
    "c.e": "test"
}
Prerequisite:
1. Install Java 8 
2. Install maven 

Usage:
1. Clone the repo to your local machine
2. Move to the repo path.
3. build the project using command
    mvn clean install
4. This will create a jar file @  target/flatten-json-1.0-SNAPSHOT.jar 
5. Use the command to run 
    cat [json file path] | java -jar target/flatten-json-1.0-SNAPSHOT.jar
   e.g. cat test-case-1.json| java -jar target/flatten-json-1.0-SNAPSHOT.jar
   
Test Cases: 3 samples fiels are provided in the repo, run the program against them as:
1. cat test-case-1.json| java -jar target/flatten-json-1.0-SNAPSHOT.jar
2. cat test-case-2.json| java -jar target/flatten-json-1.0-SNAPSHOT.jar
3. cat test-case-3.json| java -jar target/flatten-json-1.0-SNAPSHOT.jar
    
