//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Giovani Zuniga

import java.util.*;
import static java.lang.System.*;

public class HistoList {
    private HistoNode front;
    /**
     * Constructs an empty HistoList
     */
    public HistoList() {
        front = null;
    }

    /**
     * Adds a letter to the histogram. If the letter already exists,
     * its count is incremented otherwise a new node is added at the front
     * @param let the character to be added
     */
    public void addLetter(char let) {
        if (front == null) {
            front = new HistoNode(let, 1, null);
            return;
        }

        HistoNode current = front;
        HistoNode prev = null;
        
        while (current != null) {
            if (current.getLetter() == let) {
                current.setLetterCount(current.getLetterCount() + 1);
                return;
            }
            prev = current;
            current = current.getNext();
        }
        
        // Letter not found, add new node to the front
        front = new HistoNode(let, 1, front);
    }

   /**
     * Returns the index position of a given letter in the list
     * @param let the character to search for
     * @return the index position of the character or -1 if not found
     */
    public int indexOf(char let) {
        HistoNode current = front;
        int index = 0;
        
        while (current != null) {
            if (current.getLetter() == let) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    /**
     * Returns a reference to the node at the given position
     * @param spot the index position of the node
     * @return the HistoNode at the given index or null if out of bounds
     */
    private HistoNode nodeAt(int spot) {
        HistoNode current = front;
        int index = 0;
        
        while (current != null) {
            if (index == spot) {
                return current;
            }
            current = current.getNext();
            index++;
        }
        return null;
    }

   /**
     * Returns a string representation of the histogram list
     * @return a formatted string of characters and their counts
     */
    public String toString() {
        StringBuilder output = new StringBuilder();
        HistoNode current = front;
        
        while (current != null) {
            output.append(current.getLetter()).append(" - ").append(current.getLetterCount()).append("     ");
            current = current.getNext();
        }
        return output.toString();
    }
}
