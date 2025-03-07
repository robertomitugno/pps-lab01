package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {

    /**
     * Checks if the circularQueue is empty.
     *
     * @return true if the circularQueue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Add an integer onto the circularQueue.
     *
     * @param value The integer to add.
     */
    void add(int value);

    /**
     * Gets the number of elements in the circularQueue.
     *
     * @return The size of the circularQueue.
     */
    int size();

    /**
     * Gets the maximum number of elements that can be contained in the circularQueue.
     *
     * @return The max capacity of the circularQueue.
     */
    int getCapacity();

    /**
     * Remove an integer onto the circularQueue.
     */
    void remove();

    /**
     * Get the value at the specified index in the circularQueue.
     *
     * @param i The index of the value to retrieve.
     * @return The value at the specified index in the circularQueue.
     */
    int get(int i);
}