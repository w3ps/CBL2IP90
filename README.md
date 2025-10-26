# CBL2IP90

[GitHub Repo](https://github.com/w3ps/CBL2IP90)

## Description:
The game Gravity Shift is a puzzle type game, in which the goal is to reach the goal tile.
The player moves until reaching a wall or object, similar to the movement of a 'ice sliding puzzle'.
Each level (maze) consists of the tiles: air, walls, goals and fire (restarting the level when touched).
The game contains 10 pre-made levels, but allows the user the construct and play their own self-made levels.

## Settings:
The changeable setting is volume, with a base value of 0.
The user can change the volume in the in-game settings.
When the volume is nonzero, music (Sweden - C418) will be played.

## Usage: Playing custom levels
When in the main menu, go to the level selection menu and press 'Custom Level'.
In this menu, enter the size of the axis of your maze, in tiles.
Note that a maze has to be a square, shapes with distinct sizes are not supported.
In the textfield 'File location' input the **complete** path of your custom maze file and press enter.
Note that if you do not press enter, the location will not update.
For instructions about formatting your maze, consult: 'src\main\resources\maze_templates\custom_level.txt'

## Running the game:
### Option 1. Run the .jar file (no external files needed):
Open any terminal in this directory (*/CBL2IP90) and run the following: 
```
java -jar target/GravityShift.jar
```
### Option 2. Run the main file:
Run the file
```
src\main\java\com\example\Main.java
```
in any sufficient text editor. 
Note that for this option, a **fully configured** installation of Apache Maven is required.

