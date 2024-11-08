# Sets and Bits Manipulation

This repository contains the solution for **Lab 1: Sets and Bits Manipulation**, assigned for the (CSE214) Discrete Structures course. The assignment involves implementing bit manipulation functions and a custom set data structure using bitwise operations.

## Project Structure

- `src/` - Contains Java source files for the lab.

## Assignment Overview

### Part 1: Basic Bit Operations

Implements functions to manipulate individual bits of an integer:
1. **getBit(int number, int position)**: Returns the bit (0 or 1) at a given position in the binary representation of the number.
2. **setBit(int number, int position)**: Sets the bit at a specific position to 1 and returns the modified number.
3. **clearBit(int number, int position)**: Clears the bit (sets it to 0) at a specified position and returns the modified number.
4. **updateBit(int number, int position, boolean value)**: Updates the bit at a given position to 0 or 1, depending on the boolean `value`, and returns the modified number.

### Part 2: Sets Operations Using Bits Manipulation

Implements a Set data structure using bit manipulation, which supports:
- Adding elements to the set
- Union, Intersection, Complement, and Difference operations
- Cardinality (count of elements) and retrieval of set elements

### Part 3: Applications for Bits Manipulation

1. **Unique Element Finder**: Identifies the unique integer in an array where every other integer appears twice. The solution uses bitwise operations to achieve linear runtime complexity.
   - **Bonus**: A function that identifies two unique integers in the array.

2. **Counting '1' Bits**: Takes an unsigned integer and returns the number of '1' bits in its binary representation.

## Usage

1. Clone the repository:
   ```bash
   git clone https://github.com/mosheriif/discrete-sets-and-bit-manipulation.git
   ```

2. Compile the Java files:
   ```bash
   javac src/*.java
   ```

## Assumptions

- It is assumed that the format for the set is [1,2,3,4..], with commas between each element and bounded by square brackets.
- For the set operations, it is assumed that if the user wants only one subset of the universe, then the only menu options available would be “cardinality”, “set print” and “complement”, but if at least two sets, then the “union”, “difference” and “intersection” options would be available.
- Sets do not allow for repetition, as they are not tuples, so they are checked for any repetition, and any repeated digits are removed, so all set elements are of singular multiplicity.
- For the unique element finder, it is assumed that the maximum number of times an element can be repeated in the list is two, except for the unique element, so if the length of the list is even, then there cannot be a unique element, as one element will be repeated twice, but if the length of the list is odd, then it looks for the unique element.
- For counting the '1' bits, the user can only enter positive numbers, and the maximum number the user can enter is 2147483647, which is the largest number the int data type can hold.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
