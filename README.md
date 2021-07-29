# Knights-Tour
Implementation of knight’s tour problem using Warnsdorff's rule with JavaFX

Given an 8x8 board with the knight placed on one of the empty blocks of the board. Moving according to the rules of chess, the knight must visit each square exactly once.

## Warnsdorff's rule
The rule of Warnsdorff is a heuristic for finding a single knight's tour. The knight is always moved to the square from which the knight will have the fewest further moves. We don't count steps that return to a square that has previously been visited when calculating the number of onward moves for each candidate square. It is possible to have two or more choices for which the number of onward moves is equal.

![example](https://user-images.githubusercontent.com/85555218/127534752-3b88960a-8eb3-4c92-a773-0787a0c35928.png)

## the following animation shows Warnsdorff's rule in knight’s tour problem
![knights_tour](https://user-images.githubusercontent.com/85555218/127538553-5de3f56c-72cb-4f5b-bcf6-8ef2d46d5f53.gif)
