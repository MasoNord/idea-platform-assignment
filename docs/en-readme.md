# Idea Platform Assignment
Write a program in java language which will read the [tickets.json](https://disk.yandex.ru/d/oytpde1hp8DBRQ) file and
will calculate:
- Minimum flight time between cities
  Vladivostok and Tel Aviv for everyone
  air carrier
- The difference between the average price and the median for
  flights between the cities of Vladivostok and Tel Aviv

## Requirements
* Java 17
* Jackson
* Maven

## How To Install / Run
1. Clone repository from GitHub

   ~~~
   git clone https://github.com/MasoNord/idea-platform-assignment.git
   ~~~

2. Open it in Intellij IDE or any other ide of your choice
3. Open Terminal and type the following command:
    ~~~
    mvn clean compile assembly:single
    ~~~
   This will compile your program into executable jar file
4. To run the jar file type the following commands:
    ~~~
    cd target
    java -jar idea-platform-assignment-1.0-SNAPSHOT-jar-with-dependencies.jar
    ~~~
5. Check result.txt for the result in root folder

## Results
1. Minimum fight time between cities Владивосток and Тель-Авив:
    ~~~
    SU: 21600.0 seconds | 360.0 minutes | 6.00 hours
    S7: 23400.0 seconds | 390.0 minutes | 6.50 hours
    TK: 21000.0 seconds | 350.0 minutes | 5.83 hours
    BA: 29100.0 seconds | 485.0 minutes | 8.08 hours
    ~~~
2. Difference between average price and median for a flight from Владивосток to Тель-Авив:
    ~~~
    460.0
    ~~~