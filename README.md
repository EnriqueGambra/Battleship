# Battleship
How the game works:
- User enters in 3 names of battleships. Enters in corresponding coordinates for each of them.
- Coordinates must be between digits 0-9 and must be in the format '#,#'
- After ships entered, user must choose a point as to where they believe the CPU's battleship is. Format must be in '#,#'
- After user's turn, CPU guesses where the user's battleship is
- Continues to go back and forth until either the user's ships have been destroyed, or the CPU's ships have been destroyed

Added Implementation:
- CPU now has an arraylist of guesses that it will check before making an official guess. Makes the CPU tougher.

Future Implementation:
- Make it a GUI version
- Also, make it more aware of hits. If it gets a hit -- store the coordinate in an array and have CPU shoot around that area
