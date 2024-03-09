## SLogo API Changes
### 4
### Spencer Katz, Alisha, Kevin, Doga


### Changes Made

#### External Model API

* Method changed:

    * Why was the change made?

    * Major or Minor (how much they affected your team mate's code)

    * Better or Worse (and why)


* Method changed:

    * Why was the change made?

    * Major or Minor (how much they affected your team mate's code)

    * Better or Worse (and why)


#### Internal Model API

* Method changed:

    * Why was the change made?

    * Major or Minor (how much they affected your team mate's code)

    * Better or Worse (and why)


* Method changed:

    * Why was the change made?

    * Major or Minor (how much they affected your team mate's code)

    * Better or Worse (and why)


#### Internal View API

* Method changed:
Node getRoot() added in TextInput.java
    * Why was the change made?
        This should have been originally added before change but we forgot to update our API's originally. This was 
    necessary as it expected that implementing classes would have to return their node.

    * Major or Minor (how much they affected your team mate's code)
      * This was a minor necessary change that should have originally added. 

    * Better or Worse (and why)
      * This was definitely better as I don't believe the view was actually using this API 
      and it couldn't until this change was made. It was absolutely necessary to add this method.


* Method changed:
ClearText() in TextInput.java
    * Why was the change made?
      * We decided it was a better design decision for the text area to get cleared when the user pressed
      run. 
    * Major or Minor (how much they affected your team mate's code)
      * This was not a major change as it simply meant that we called this method when somebody ran the code.
    * Better or Worse (and why)
      * I believe that this is better as it allows the text to be cleared automatically upon commands being run.
      This prevents prevents the user from having to manually do it. This also makes a lot of sense as a 
      public method.

* Method changed:
  GraphicsContext getGraphicsContext();
    * Why was the change made?
      * This was changed to Node getNode(). It was unnecessary for us
      to pass the graphics context and it was necessary to make the node available. This 
      really should have been implemented before change.
    * Major or Minor (how much they affected your team mate's code)
        * This was a very minor change
    * Better or Worse (and why)
      * This was definitely better as it allowed the node to be accessed through the API 
      and deleted an unnecessary method.

* Method Changed:
  * setSpeed(int speed)
  * Why was the change made?
    To allow dynamic adjustment of the turtle animation speed.
  * Major or Minor?
    * Minor, as it introduces a new setting without fundamentally altering existing functionalities.
  * Better or Worse (and why)?
    * Better, as it provides more control over the animation speed, allowing adaptability to different scenarios.
  
* Method Changed:
  * clear()
    * Why was the change made?
      * To facilitate clearing the turtle's drawings on the pane.
    * Major or Minor?
      * Minor, as it introduces a new method for a specific operation (clearing) but doesn't drastically change the overall structure.
    * Better or Worse (and why)?
      * Better, as it adds a useful feature for managing the visual representation of the turtle's movements.

* Method Changed: 
  * startTimeline()
  * Why was the change made?
    * To initiate the animation timeline for the turtle.
  * Major or Minor?
    * Major, as it introduces a fundamental behavior related to animation control. by allowing the user to resume/start
    the Animation. However, this did not change too much of teammates code.
  * Better or Worse (and why)?
    * Better, as it allows explicit control over when the turtle animation begins.

* Method Changed: 
  * stopTimeline()
    * Why was the change made?
      * To halt the animation timeline for the turtle.
    * Major or Minor?
      * Major, as it introduces a fundamental behavior related to animation control, allowing the user to stop the animation. However, this do not h
      a large effect on other's code.
    * Better or Worse (and why)?
      * Better, as it enables explicit control over when the turtle animation stops.

* Method Changed
  * updateColor(Color color)
    * Why was the change made?
      * To allow dynamic updating of the turtle pen color.
    * Major or Minor?
      * Minor, as it introduces a new setting without fundamentally altering existing functionalities.
    * Better or Worse (and why)?
      * Better, as it provides more flexibility in customizing the turtle's appearance during drawing.

* Method Changed:
  * updateBackground(Color backgroundColor)
    * Why was the change made?
      * To enable dynamic updating of the turtle pane background color.
    * Major or Minor?
      * Minor, as it introduces a new setting without fundamentally altering existing functionalities.
    * Better or Worse (and why)?
      * Better, as it allows for more dynamic and customizable visualization options.

* Method Changed: 
  * updateImage(String selectedFilePath)
    * Why was the change made?
      * To update the turtle image based on a selected file path.
    * Major or Minor?
      * Minor, as it introduces a new setting without fundamentally altering existing functionalities.
    * Better or Worse (and why)?
      * Better, as it provides the ability to change the visual representation of the turtle dynamically.
* Method Changed: 
  * getPaused()
    * Why was the change made?
      * To check if the animation timeline is currently paused.
    * Major or Minor?
      * Minor, as it introduces a new method for obtaining information about the animation state.
    * Better or Worse (and why)?
      * Better, as it allows for programmatically determining the pause state of the animation.
* Method Changed: 
  * getRoot()
    * Why was the change made?
      * To retrieve the root node associated with the implementing class.
    * Major or Minor?
      * Minor, as it introduces a new method for obtaining information about the root node.
    * Better or Worse (and why)?
      * Better, as it provides a convenient way to access the root node, potentially aiding in graphical representation or manipulation.
* Method Changed: 
  * updateImage(String selectedFilePath)
    * Why was the change made?
      * To update the turtle's image based on the selected file path. Initially, it was updated based on 
      an image that was passed in. However, I believed that the implementing class should be the one that
      creates its one image.
    * Major or Minor?
      * Minor, as it introduces a new setting without fundamentally altering existing functionalities.
    * Better or Worse (and why)?
        * Better, as it allows dynamic updating of the turtle's visual representation, providing flexibility in adapting to different scenarios.
  
* Method Changed: 
  * getX()
    * Why was the change made?
      * To obtain the x-coordinate of the turtle. This became a much cleaner way to store information when 
      there became multiple turtles.
      * Major or Minor?
        * Minor, as it introduces a new method for obtaining information about the turtle's state.
      * Better or Worse (and why)?
        * Better, as it provides a convenient way to programmatically retrieve the x-coordinate of the turtle.
* Method Changed:
  * getY()
    * Why was the change made?
      * To obtain the y-coordinate of the turtle.This became a much cleaner way to store information when
        there became multiple turtles.
    * Major or Minor?
      * Minor, as it introduces a new method for obtaining information about the turtle's state.
    * Better or Worse (and why)?
      * Better, as it provides a convenient way to programmatically retrieve the y-coordinate of the turtle.
* Method Changed:
  * getDirection()
    * Why was the change made?
      * To obtain the direction of the turtle. This became a much cleaner way to store information when
        there became multiple turtles.
    * Major or Minor?
      * Minor, as it introduces a new method for obtaining information about the turtle's state.
    * Better or Worse (and why)?
      * Better, as it provides a convenient way to programmatically retrieve the direction of the turtle.
