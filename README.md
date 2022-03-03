# Calculator

   * Take a moment to familiarize yourself with the (non-)functional requirements below
   * The test cases are in [examples.tsv](src/test/resources/examples.tsv)
   * Fork the repo
   * Push your changes to the new repo (you may keep this private)
   * Send us the repo address, granting access when requested if you made it private
   * If you don't generally use Java or Gradle, take a look at the Development section

## Requirements

### Functional requirements

´´´

    Feature: Evaluate expression

      The code evaluates expressions, returning a value or an exception depending on the input.
      The evaluation of correctly formatted expressions — exactly what a correctly formatted expression 
      is is defined by the test data set — generates a calculated value.

      Scenario Outline: A valid expression is provided

        When the <expression> is provided
        Then a <value> is returned

      Examples:

        This is not an exhaustive list, this may be found in examples.tsv.

        | expression | value                   |
        | 1 1 *      | 1                       |
        | 1 1 +      | 2                       |
        | 1 1 -      | 0                       |
        | 1 1 /      | 1                       |

      Scenario Outline: An invalid expression throws an exception

        When the <expression> is provided
        Then a exception is thrown

      Examples:

        Note that this set provides two examples, where the first is not a valid expression
        and the second is valid, but mathematically problematic. The expectation here is that
        the code can handle the valid expressions and throw exceptions when the expresssion does not 
        match known patterns.

        | expression  |
        | hello world |
        | 1 0 /       |

´´´

### Non-functional requirements

- The code must be written in Java using the Gradle build automation system
- The code should not depend on non-Java Platform libraries for the solution code
- Write the code as a simple module that may be imported used by other software
- Ensure that the configured test and codestyle verification pass for every commit
- The JUnit 5 API (and extensions) must be used

## Development

### Java 

If you don't write Java, there is no reason not to attempt this task; a lot of the software we use/create at Sikt uses Java or the JVM, and becoming familiar with it is a necessary part of our work. 

This task uses minimal features of the Java language, and the concepts should be familiar to anyone. The initial test and code are set up for you.

### Gradle

If you use an IDE, it likely supports Gradle out-of-the-box, but may require a plugin. IntelliJ IDE (community or paid edition) is good choice, if you don't have a Java IDE.

To build the project on the commandline, use:

#### Unix/Linux

``` $ ./gradlew build ```

### Windows

``` $ gradlew.bat build ```
