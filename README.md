# Battleship
How the game works:
- User enters in 3 names of battleships. Enters in corresponding coordinates for each of them.
- Coordinates must be between digits 0-9 and must be in the format '#,#'
- After ships entered, user must choose a point as to where they believe the CPU's battleship is. Format must be in '#,#'
- After user's turn, CPU guesses where the user's battleship is
- Continues to go back and forth until either the user's ships have been destroyed, or the CPU's ships have been destroyed

Future Implementation:
- Make it a GUI version
- Make CPU harder, maybe create an array of guesses and then check that array before making another guess so it doesn't repeat itself
- Also, make it more aware of hits. If it gets a hit -- store the coordinate in an array and have CPU shoot around that area
