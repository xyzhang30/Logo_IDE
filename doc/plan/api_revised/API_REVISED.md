See interfaces in slogo/model/api for external APIs

See other interfaces in their respective packages for internal APIs

### View Internal
* ```SceneManagerExternal``` and ```TurtleViewInternal``` were removed
* ```ControlPane``` implements the ```Control``` API interface that initializes the buttons at the top of the screen
* ```TurtlePane``` implements the ```TurtleBase``` API interface for the turtle
* ```TextInputPane``` implements the ```TextInput``` API interface for the text-editor
* ```Animations``` class implements the ```Graphics``` API interface for the animations in the codebase

### Model Internal
* ```commandLineInternal``` was changed to ```Executable```, a more generalized one for all executable nodes in the syntax tree, and with a name that makes more sense intuitively
* ```TokenizerApi```: implemented by the tokenizer, ```tokenize()``` is called by parser to cast each element in a line of code into tokens, ```setLanguage()``` sets the language used, provides a way to switch languages. 

### Model External
* ```commandParserExternal``` was changed to ```ParserApi``` with the parse method taking in a record instead of a string to allow more abstraction and flexibility
* ```ExecutionerApi```: implemented by executioner, responsible for executing/calling the commands to execute their logic
* ```HistoryApi```: 
* ```TurtleModelApi```: implemented by the turtle model, used by the turtle view to get the turtle model data from a record