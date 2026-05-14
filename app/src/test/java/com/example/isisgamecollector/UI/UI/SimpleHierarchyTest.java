package com.example.isisgamecollector.UI.UI;

import static org.junit.Assert.*;
import org.junit.Test;
import com.example.isisgamecollector.UI.UI.entities.Game;

/**
 * Unit test to ensure games are correctly assigned to consoles
 */
public class SimpleHierarchyTest {

    @Test
    public void testGameToConsoleAssignment() {
        // Arrange: Define IDs for a console and a game
        int consoleID = 10;
        int gameID = 500;
        
        // Act: Create a game object linked to that console
        Game game = new Game(gameID, "Sonic the Hedgehog", "06/23/91", "12/25/91", consoleID, 1);
        
        // Assert: Verify the game holds the correct console reference
        assertEquals("The game should be linked to console ID 10", consoleID, game.getConsoleID());
        
        System.out.println("testGameToConsoleAssignment: PASSED");
    }
    /**
     * Unit test to ensure game correctly stores and retrieves its own ID
     */
    @Test
    public void testGameIdentity() {
        // Arrange: Define a unique ID for a game
        int expectedGameID = 777;

        // Act: Create a game object with that ID
        Game game = new Game(expectedGameID, "Super Mario World", "08/13/91", "12/25/91", 20, 1);

        // Assert: Verify the game correctly returns its own ID
        assertEquals("The game should correctly store its unique ID", expectedGameID, game.getGameID());

        System.out.println("testGameIdentity: PASSED");
    }
}
