package com.victorine.victorine.controllers;

import com.google.gson.Gson;
import com.victorine.victorine.DAO.*;
import com.victorine.victorine.models.askJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Api {
    @Autowired
    gameDAO dao;
    public Api() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
    }

    @RequestMapping(value = "/qList", method = RequestMethod.GET)
    public List getqList() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return dao.getQuestion();
    }
    @RequestMapping(value = "/aList", method = RequestMethod.GET)
    public List getAlist() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return dao.getAnswers();

    }
    @PostMapping("ask")
    public String ask(@RequestBody String JSONParam) throws SQLException {
        Gson gson = new Gson();
        askJSON value = gson.fromJson(JSONParam, askJSON.class);
        return dao.ask(value.answer);
    }

    @RequestMapping(value = "/getDate", method = RequestMethod.GET)
    public String getdate() throws SQLException {
        return dao.getStreamTime();
    }

    @RequestMapping(value = "/getEndDate", method = RequestMethod.GET)
    public String getenddate() throws SQLException {
        return dao.getEndTime();
    }
}