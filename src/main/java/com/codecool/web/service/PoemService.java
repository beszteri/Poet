package com.codecool.web.service;

import com.codecool.web.model.Poem;

import java.sql.SQLException;
import java.util.List;

public interface PoemService {
    List<Poem> findAllByUserId(String id) throws SQLException;
    Poem findPoemByTitle(String title) throws SQLException;
}
