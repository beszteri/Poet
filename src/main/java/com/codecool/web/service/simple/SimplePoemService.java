package com.codecool.web.service.simple;

import com.codecool.web.dao.PoemDao;
import com.codecool.web.model.Poem;
import com.codecool.web.service.PoemService;

import java.sql.SQLException;
import java.util.List;

public class SimplePoemService implements PoemService {

    private final PoemDao poemDao;

    @Override
    public List<Poem> findAllByUserId(String id) throws SQLException {
        return poemDao.findAllByUserId(Integer.parseInt(id));
    }

    @Override
    public Poem findPoemByTitle(String title) throws SQLException {
        return poemDao.findPoemByTitle(title);
    }

    public SimplePoemService(PoemDao poemDao) {
        this.poemDao = poemDao;
    }
}
