package com.codecool.web.dao.database;

import com.codecool.web.dao.PoemDao;
import com.codecool.web.model.Poem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabasePoemDao extends AbstractDao implements PoemDao {

    public DatabasePoemDao(Connection connection) {
        super(connection);
    }

    private Poem fetchPoem(ResultSet resultSet) throws SQLException {
        // adott resultsetből kinyeri az adott adatokat és belőle egy uj objektumot hoz létre
        int id = resultSet.getInt("id");
        int userId = resultSet.getInt("user_id");
        String title = resultSet.getString("title");
        String content = resultSet.getString("content");
        return new Poem(id, userId, title, content);

    }

    @Override
    public List<Poem> findAllByUserId(int userId) throws SQLException {
        List<Poem> poems = new ArrayList<>();
        String sql = "SELECT * FROM poems WHERE user_id = ?;";
        //a createStatementtől eltérően itt külön mengy az sql és a lekérdezés paraméterek, biztonságosabb.
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            //a ? helyén megadjuk, hogy milyen típusú adatot szerepelhet
        preparedStatement.setInt(1, userId);
        //a resultset táblázatszerűen tárolja a lekért adatokat.
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                //amig van adat a resultsetben, addig új poemeket hozunk létre és adjuk azokat hozzá a listához.
                while (resultSet.next()){
                    poems.add(fetchPoem(resultSet));
                }
            }
        }
        return poems;
    }

    @Override
    public Poem findPoemByTitle(String title) throws SQLException {
        String sql = "SELECT id, user_id, title, content FROM poems WHERE title = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, title);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()){
                    return fetchPoem(resultSet);
                }
            }
        }
        return null;
    }
}
