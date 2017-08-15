package model.dao.jdbc;

import factory.EntityFactory;
import model.dao.ContactDAO;
import model.data.Contact;
import model.data.User;
import model.services.AbstractContactService;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcContactDAO implements ContactDAO {

    private String url = "jdbc:postgresql://localhost:5433/postgres";
    private String name = "postgres";
    private String password = "postgres";


    @Override
    public void save(Contact contact, int user_id) throws Exception {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);

            PreparedStatement preparedStatement = null;

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO contacts(firstname, lastname, number, user_id) values(?,?,?,?)");
            preparedStatement.setString(1, contact.getFirstName());
            preparedStatement.setString(2, contact.getLastName());
            preparedStatement.setString(3, contact.getNumber());
            preparedStatement.setInt(4, user_id);

            preparedStatement.executeUpdate();


        } catch (Exception ex) {

            Logger.getLogger(JdbcContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JdbcContactDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void removeById(int id) throws Exception {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);

            PreparedStatement preparedStatement = null;

            preparedStatement = connection.prepareStatement(
                    "DELETE FROM contacts WHERE id = ?");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();


        } catch (Exception ex) {

            Logger.getLogger(JdbcContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JdbcContactDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void update(Contact contact, int id, int user_id) throws Exception {
        removeById(id);
        save(contact, user_id);
    }

    @Override
    public Set<Contact> getAll(int user_id) throws Exception {
        Connection connection = null;
        Set<Contact> contactSet = new HashSet<>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);

            PreparedStatement preparedStatement = null;

            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM contacts WHERE user_id = ?");
            preparedStatement.setInt(1, user_id);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {

                PreparedStatement preparedStatement1 = connection.prepareStatement(
                        "SELECT * FROM references_table WHERE contact_id = ?");
                preparedStatement1.setInt(1,result.getInt("id"));
                ResultSet result1 = preparedStatement1.executeQuery();

                Set<Integer> groupSet = new HashSet<>();

                while (result1.next()){
                    groupSet.add(result1.getInt("group_id"));
                }

                contactSet.add((Contact)EntityFactory.getEntity(result.getInt("id"),
                        result.getString("firstName"),result.getString("lastName"),
                        result.getString("number"),groupSet));
            }


        } catch (Exception ex) {

            Logger.getLogger(JdbcContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JdbcContactDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contactSet;
    }

    @Override
    public Contact getById(int id) throws Exception {
        Connection connection = null;
        Contact contact = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);

            PreparedStatement preparedStatement = null;

            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM contacts WHERE id = ?");
            preparedStatement.setInt(1,id);

            ResultSet result = preparedStatement.executeQuery();

            PreparedStatement preparedStatement1 = connection.prepareStatement(
                    "SELECT * FROM references_table WHERE contact_id = ?");
            preparedStatement1.setInt(1,result.getInt("id"));
            ResultSet result1 = preparedStatement1.executeQuery();

            Set<Integer> groupSet = new HashSet<>();

            while (result1.next()){
                groupSet.add(result1.getInt("group_id"));
            }

            contact = (Contact)EntityFactory.getEntity(result.getInt("id"),
                    result.getString("firstName"),result.getString("lastName"),
                    result.getString("number"),groupSet);


        } catch (Exception ex) {

            Logger.getLogger(JdbcContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JdbcContactDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return contact;
    }

    @Override
    public void addContactGroup(int idC, int idG) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);

            PreparedStatement preparedStatement = null;


            preparedStatement = connection.prepareStatement(
                    "INSERT INTO references_table(contact_id, group_id) values(?,?)");
            preparedStatement.setInt(1, idC);
            preparedStatement.setInt(2, idG);

            preparedStatement.executeUpdate();


        } catch (Exception ex) {

            Logger.getLogger(JdbcContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JdbcContactDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void removeContactGroup(int idC, int idG) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);

            PreparedStatement preparedStatement = null;


            preparedStatement = connection.prepareStatement(
                    "DELETE FROM references_table WHERE contact_id = ? AND group_id = ?");
            preparedStatement.setInt(1, idC);
            preparedStatement.setInt(2, idG);

            preparedStatement.executeUpdate();


        } catch (Exception ex) {

            Logger.getLogger(JdbcContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JdbcContactDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public int login(String login, String password) {
        Connection connection = null;
        boolean out = false;
        int id = 0;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);

            PreparedStatement preparedStatement = null;

            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE login = ? AND password = ?");
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,password);

            ResultSet result = preparedStatement.executeQuery();


            if(result!=null) {
                result.next();
                id = result.getInt("id");
            }
            //User.setUser_id(id);


        } catch (Exception ex) {

            //Logger.getLogger(JdbcContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JdbcContactDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (id!=0){
            out = true;
        }
        return id;
    }
}
