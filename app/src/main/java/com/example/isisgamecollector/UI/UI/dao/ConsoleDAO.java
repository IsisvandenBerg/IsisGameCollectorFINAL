package com.example.isisgamecollector.UI.UI.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.isisgamecollector.UI.UI.entities.Console;

import java.util.List;

@Dao
public interface ConsoleDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Console console);

    @Update
    void update(Console console);

    @Delete
    void delete(Console console);

    @Query("SELECT * FROM CONSOLES WHERE userID = :userID ORDER BY consoleID ASC")
    List<Console> getConsolesByUserID(int userID);

    @Query("SELECT * FROM CONSOLES ORDER BY consoleID ASC")
    List<Console> getAllConsoles();

    @Query("SELECT * FROM CONSOLES WHERE consoleID = :id")
    Console getConsoleByID(int id);

    @Query("DELETE FROM CONSOLES")
    void deleteAllConsoles();
}
