# Project 1: PacMan

## Table of Contents
- [Team members](#team-members)
- [How to Start Game](#how-to-start-game-from-bash-command-line)
- [API](#api-of-implemented-features)
   * [PacMan Class](#pacman-class) 
      + [get_valid_moves()](#get_valid_moves)
      + [move()](#move)
      + [is_ghost_in_range()](#is_ghost_in_range)
      + [consume()](#consume)
   * [Ghost Class](#ghost-class)
      + [get_valid_moves()](#get_valid_moves-1)
      + [move()](#move-1)
      + [is_pacman_in_range()](#is_pacman_in_range)
      + [attack()](#attack)
   * [Map Class](#map-class)
      + [move(String name, Location loc, Type type)](move(String name, Location loc, Type type))
      + [getLoc(Location loc)](getLoc(Location loc))
      + [attack(String name)](attack(String name))
      + [eatCookie(String Name)](eatCookie(String Name))

<!-- toc -->
## Team Members
* Daniel Kyung
* Lydia Hancock
* Ryan Shriver
* Shane Mehr

## Image/Video of Game Play

[insert image/video]

## How to Start Game from Bash Command Line

```bash
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```

## API of Implemented Features

### PacMan Class
#### get_valid_moves()
This function takes in no arguments and returns an arraylist of Locations that represent valid moves that Pacman is 
   able to make given his current location. If there are no valid moves an empty arraylist is returned.

     - JUnit TestPacManValidMoves:  
       Pacman's valid moves include - moving into a Location with a COOKIE or a Location that is EMPTY. Testing 
       included creating a map with different types (i.e. COOKIE, WALL, GHOST, EMPTY, PACMAN) and evaluating the 
       returned arraylist when a call to this function was made. 

#### move()
- **Type**: `() -> Bool`
- **Description**: This method uses the get_valid_moves method to find the possible locations that PacMan can move, given his current location. The method then  chooses to move in one of those directions. You are free to apply an algorithm here if you would like, but the only requirement is that you move in a valid direction. If PacMan is able to move, this function returns true otherwise it returns false.
- **Examples**:
  ```java
  //pacman at location (9,11)
  pacman.move() -> true
  pacman.myLoc ∈ {(9,12), (10,11), (10,12)}
  ```
  
#### is_ghost_in_range()


#### consume()
This function takes in no arguments and returns a Cookie component if pacman successfully eats a cookie. This method checks if cookie exists in pacman's             location, if true then returns a Map class method eatCookie(pacman name) which returns a component, otherwise returns null. 
   
   - JUnit TestConsume:
     This test checks if pacman is able to successfully able to consume a cookie in the pacman's location. After setting the cookie and pacman in the same location, the consume method should return the cookie component. 
   - JUnit TestNoCookie: 
      This test checks a return null if there is no cookie to consume for the pacman. 

### Ghost Class
#### get_valid_moves()
This function takes in no arguments and returns an arraylist of Locations that represent valid moves that a Ghost is
   able to make given their current location. If there are no valid moves an empty arraylist is returned.

    - JUnit TestGhostValidMoves:<sup>*</sup>  
      A Ghost's valid moves include - moving into a Location with a COOKIE or a Location that is EMPTY or a Location
      containing Pacman. Testing included creating a map with different types (i.e. COOKIE, WALL, GHOST, EMPTY, PACMAN) 
      and evaluating the returned arraylist when a call to this function was made.  

        <sup>*</sup>Note: Only one ghost can occupy any one Location at any given time. 

#### move()


#### is_pacman_in_range()


#### attack()
This function checks if a pacman is within the ghost's attack range using the is_pacman_in_range method that returns a boolean. If it returns true, then calls the attack method
from Map class, otherwise returns false. 

   - JUnit TestAttack: 
      This test sets up a pacman that is within a ghost's attack range,  which should return true for the method. 
   
   - JUnit TestUnsuccessfulAttack: 
      This test sets up a pacman outside of the ghost's attack range, which would return false for the method. 
      

### Map Class
#### move(String name, Location loc, Type type)  
This function takes in three arguments: a String, a Location, and a Type. This moves the object specified by name (String) 
   to the Location specified by loc. This returns true on success, and false on failure. This a helper method to Pacman's 
   and Ghost's move functions. 

    - JUnit TestMapMove:  
    Test cases were created with the assumption that valid arguments will be passed in from Pacman's and Ghost's call 
      to this function. Testing included creating a map with different types (i.e. COOKIE, WALL, GHOST, EMPTY, PACMAN)
      and checking the accuracy of the return value when a call to this function is made.   


#### getLoc(Location loc)


#### attack(String name)


#### eatCookie(String Name)
This method is called by the pacman object if a cookie is in pacman's location. If the pacman successfully consumes the cookie, it updates the map to show that the cookie has been consumed. 

   - JUnit TestMapEatCookie:
      This test sets up a cookie and pacman in same location and calls the eatCookie method which should return the cookie component. 
      
   - JUnit TestNoCookie: 
      This test sets up a cookie and pacman in different location and calls the eatCookie method which should return null. 
