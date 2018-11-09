package com.victorine.victorine.DAO;

import java.sql.SQLException;
import java.util.List;

public interface gameDAO {
    public List getQuestion() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;
    public List getAnswers() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;
    public String ask(String answer) throws SQLException;
    public String getStreamTime() throws SQLException;
    public String getEndTime() throws SQLException;
}
