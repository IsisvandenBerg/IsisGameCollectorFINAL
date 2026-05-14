package com.example.isisgamecollector.UI.UI.database;

import android.app.Application;

import com.example.isisgamecollector.UI.UI.dao.ConsoleDAO;
import com.example.isisgamecollector.UI.UI.dao.GameDAO;
import com.example.isisgamecollector.UI.UI.dao.UserDAO;
import com.example.isisgamecollector.UI.UI.entities.Console;
import com.example.isisgamecollector.UI.UI.entities.Game;
import com.example.isisgamecollector.UI.UI.entities.User;

import java.util.List;

public class Repository {
    private final GameDAO mGameDAO;
    private final ConsoleDAO mConsoleDAO;
    private final UserDAO mUserDAO;

    public Repository(Application application){
        ConsoleDatabaseBuilder db = ConsoleDatabaseBuilder.getDatabase(application);
        mGameDAO = db.gameDAO();
        mConsoleDAO = db.consoleDAO();
        mUserDAO = db.userDAO();
    }

    public List<Console> getmAllConsoles(){
        return mConsoleDAO.getAllConsoles();
    }

    public List<Console> getConsolesByUserID(int userID){
        return mConsoleDAO.getConsolesByUserID(userID);
    }

    public Console getConsoleByID(int id) {
        return mConsoleDAO.getConsoleByID(id);
    }

    public void insert(Console console){
        mConsoleDAO.insert(console);
    }

    public void update(Console console){
        mConsoleDAO.update(console);
    }

    public void delete(Console console){
        mConsoleDAO.delete(console);
    }

    public List<Game> getAllGames(){
        return mGameDAO.getAllGames();
    }

    public List<Game> getGamesByUserID(int userID){
        return mGameDAO.getGamesByUserID(userID);
    }

    public void insert(Game game){
        mGameDAO.insert(game);
    }

    public void update(Game game){
        mGameDAO.update(game);
    }

    public void delete(Game game){
        mGameDAO.delete(game);
    }

    public void deleteAllConsoles() {
        mConsoleDAO.deleteAllConsoles();
    }

    public void deleteAllGames() {
        mGameDAO.deleteAllGames();
    }

    // User operations
    public void insert(User user){
        mUserDAO.insert(user);
    }

    public User login(String username, String password) {
        return mUserDAO.login(username, password);
    }

    public User getUserByUsername(String username) {
        return mUserDAO.getUserByUsername(username);
    }

    public User getUserByEmail(String email) {
        return mUserDAO.getUserByEmail(email);
    }
}
