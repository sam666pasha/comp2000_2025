# Welcome to COMP2000 - Object Oriented Programming Practices
## Session 2, 2025

Please ensure that you follow the weekly updates in this repository

You are free to clone this repository into your own hosted git environment, such as Github, Bitbucket, or Gitlab.

*However*, please be aware that any repository containing your assignment code **must** be made private. Any repository with assignment code that is public available, or found to be shared with other students, will be considered a violation of the academic integrity policy.



## Assignment 1 (week 5) – Solution
This project extends the Week 5 Grid starter code into a small grid-based game to demonstrate Java and OOP practices. The player can choose between a Dog, Cat, or Bird, move across the grid with keyboard controls, and collect items such as a Bone, Fish, Seed, and Boat. Collected items are stored in a generic Inventory, which is displayed in the HUD.

The grid also supports different terrain types (e.g., Grass, Water, Sand), where movement rules vary by player type. For example, Birds can fly over water, Dogs require a Boat to cross water, and Cats cannot cross water at all. This showcases inheritance and polymorphism in practice.


### OOP Concepts Demonstrated

1. #### Inheritance:
     Actor (Dog, Cat, Bird, Player), Item (Bone, Fish, Seed, Boat), Cell → extended into terrain types.

2. #### Interfaces: 
     Movable with polymorphic canEnter(...) rules across terrains.

3. #### Generics:
    Inventory<T> ensures type-safe item storage.

4. #### Exceptions: 
    Invalid or blocked moves can be handled using a custom exception.

### How to Run
1. ####  Compile sources:
 ```
javac -d bin src/*.java
 ```

 2. ####  Compile sources:
 ```
java -cp bin Main
 ```