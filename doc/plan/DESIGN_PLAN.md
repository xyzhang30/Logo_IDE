# SLogo Design Plan
### NAMES: Kevin Deng (kd254@duke.edu), Spencer Katz (sek49@duke.edu), Doga Ozmen (odo4@duke.edu), Alisha Zhang (xz352@duke.edu)
### TEAM 4


#### Examples

Here is a graphical look at my design:

![This is cool, too bad you can't see it](online-shopping-uml-example.png "An initial UI")

made from [a tool that generates UML from existing code](http://staruml.io/).


Here is our amazing UI:

![This is cool, too bad you can't see it](29-sketched-ui-wireframe.jpg "An alternate design")

taken from [Brilliant Examples of Sketched UI Wireframes and Mock-Ups](https://onextrapixel.com/40-brilliant-examples-of-sketched-ui-wireframes-and-mock-ups/).


## Introduction


## Configuration File Format
<commands>
    <command>
        <canonical_name>forward</canonical_name>
        <description>Move the turtle forward by a specified distance.</description>
        <example>forward 50</example>
        <help_documentation>
            <parameters>
                <parameter>distance: The distance to move forward (in pixels).</parameter>
            </parameters>
            <return_value>None</return_value>
            <category>Movement</category>
        </help_documentation>
        <number_of_expected_parameters>1</number_of_expected_parameters>
        <implementing_class_or_method_name>Turtle.moveForward()</implementing_class_or_method_name>
    </command>
    <command>
        <canonical_name>rotate</canonical_name>
        <description>Rotate the turtle by a specified angle.</description>
        <example>rotate 90</example>
        <help_documentation>
            <parameters>
                <parameter>angle: The angle to rotate (in degrees).</parameter>
            </parameters>
            <return_value>None</return_value>
            <category>Rotation</category>
        </help_documentation>
        <number_of_expected_parameters>1</number_of_expected_parameters>
        <implementing_class_or_method_name>Turtle.rotate()</implementing_class_or_method_name>
    </command>
    <!-- Additional commands can be added here -->
</commands>

Note: additional XML file for IDE (initial) config that includes background color etc.



## Design Overview:
* Model
  * XMLParser
    * readFile(String filepath)
    * getters and setters for parameters
  * Command Interface
    * MultipleLineAbstractClass
      * SpecificCommandClass
    * SingleLineAbstractClass - or methods instead of subclasses - determine in implementation
      * SpecificCommandClass
  * CommandParser(String string) -----probably will be split (by different type lines, flow control vs single action) 
    * parseCommand() 
    * getters for instructions
  * TurtleModel

* View (use panes/nodes for UI elements)
  * Controller
    * HandleButton
    * HandleViewHistory
      * display whatever is in config file
      * clear everytime user starts a new session/loads a new file
    * ReadCommand
    * SaveFile
  * SplashScreen
  * TurtleView
  * Animation
    * LineAnimation
    * ShapeAnimation- later
  * CodeEditor
  * SceneManager
    * gets the node/pane from different scenes
  * StageManager
    * creates the stage
  * Graphics: housed in a pane and returned to class that is handling the UI (scene switching)
  * Start Screen



## Design Details
* Model:
  * XMLParser:
    * Functionality: This class is responsible for parsing XML configuration files containing command metadata. 
    * Collaboration: It collaborates with the CommandParser and potentially other model classes to provide information about available commands. 
    * Resources: Requires access to XML parsing libraries and the configuration files. 
    * Method Signatures: The method signatures should abstract away the specific implementation details of XML parsing and configuration file structure. For instance, the readFile method might take a filepath as input and return a structured representation of the XML data without revealing any details about XML parsing.

  * CommandParser:
    * Functionality: Parses user input commands and extracts relevant information. 
    * Collaboration: Works closely with the XMLParser to understand the structure of commands and their parameters. 
    * Resources: Needs access to user input and potentially the XMLParser for retrieving command metadata. 
    * Method Signatures: Method signatures should abstract away the parsing logic. For instance, parseCommand() might take a string as input and return a structured representation of the command.

* View:
  * Controller:
    * Functionality: Handles user interactions and manages the flow of data between the model and the view. 
    * Collaboration: Interacts with various UI components such as SplashScreen, CodeEditor, Graphics, etc., and communicates with the model to fetch data or execute commands. 
    * Resources: Needs access to UI components and the model. 
    * Method Signatures: Method signatures should be designed to handle user interactions and delegate tasks to appropriate components without revealing internal implementations.

  * SplashScreen, CodeEditor, Graphics, Drawing, Start Screen:
    * These are various UI components responsible for displaying information to the user and capturing user input. 
    * Each component should have well-defined interfaces and methods to interact with the controller and other components as needed. 
    * Method signatures should abstract away UI implementation details.


## Design Considerations
* Design Issue 1: 3 APIs
  * How to ensure that there are 3 separate APIs: internal Model, internal View, and external communication between model and view

* Design Issue 2: Abstraction/Interfaces
  * How to choose what classes to implement as abstractions or interfaces
  * Maybe Command should be an interface: take a command as an object, the class that uses this interface has the execute method (override/change this method)

* Design Issue 3: Commands
  * How to split the commands: classes or methods


## Test Plan
* Happy command input
  * Create a method that returns a boolean of whether the command is valid
* Sad command input
  * Throw error + display error message

* Happy file input
  * the program works
* Sad file input
  * error message detailing that the file is not XML or does not have correct parameters


## Team Responsibilities

 * Kevin: Model (Command)

 * Spencer: View (Controller)

 * Alisha: Model (XML + Command)

 * Doga: View (Graphics/UI)
