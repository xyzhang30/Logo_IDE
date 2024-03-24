# Design

#### Author: Kevin, Doga, Alisha

## Name + Role:
* Kevin - (backend) parser + tokenizer 
* Alisha - (backend) commands + history
* Doga - (frontend) graphics + ui elements
* Spencer - (frontend) turtle animation 

## Design Goals:
* Make enough abstraction on the executables to make adding new commands easy
* Make game visuals/properties easy to add/change
* Not restricting the type of information passed from view to model 

## High-level Design
* Controller - coordinates the action (tells model and view to update when necessary), communicates information collected from the frontend to the model
* IdeWindow - contains and organizes all the graphics/elements of the frontend, called by controller
* Executioner - controls and organizes the backend events, receives information from the frontend from the controller
* TreeParser - parses the tokens in the user input into executables to be executed, called by executioner
* TurtleModel - contains all information and status of the turtle, updated by command executables and communicates updates on the turtle properties to the view turtle through the record

## Assumption 
* Canvas is 2D
* Turtle goes off canvas when it reaches the border

## Changes from original plan
* root executable to executioner - The interface between model and view side was somewhat ambiguous to start. At first, the plan was to have View side receive a single root executable with functionality baked in; this was changed for separation purposes. Now, the executioner class processes the commands from the Abstract syntax tree and is the only point of contact with the controller.
* environment -  The addition of the environment to the executable interface was a major overhaul of the basic AST structure. It essentially allowed us to pass data through the syntax tree without having to lock it in during initialization. By moving data access to execution time rather than initialization time, we gained flexibility. Commands can interact with the environment as a sort of "shared" object.

## Adding new features
### Executing commands from user-defined variables/commands
* This would be implemented in a similar manner to the Command History Pane and executing commands from it. Once the user defines a variable, it would pop up on the User Defined Variables Pane on the side of the user's screen as a hyperlink. Once the user presses on the link, a text editor would pop up to let the user either execute that command again (by hitting run), or edit the command in the mini text editor and then run it.
### Save user preference
* Add a panel on the frontend that lets user specify preference settings.
* Add a save preference class, and make a new method that calls it in executioner, taking in all the preference info as a record parameter.
* Inside the save preference class the preference settings will be written into a new xml file in a separate folder under data. The code history will be saved into another text file with the same name as the preference file.
* Add a button on the splash screen for the option to load a workspace.

