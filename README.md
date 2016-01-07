# cucumber-for-java-maven
This repo is based on my work when reading the 'Cucumber for Java Book'.

I created a Maven project for the work I'd done after page 49 of the book.

# mvn clean test + RunCukesTest class

Before there was a RunCukesTest class, when I executed mvn clean test, no tests were run.

Of course Maven looks for a class ending in Test. There is then some Cucumber magic in the RunCukesTest class that tells
Cucumber where to look for feature files.