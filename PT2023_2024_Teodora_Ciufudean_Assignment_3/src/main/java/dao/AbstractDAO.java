package dao;

import connection.ConnectionFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The AbstractDAO class provides generic data access operations for entities.
 *
 * @param <T> The type of the entity.
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    /**
     * Constructs an AbstractDAO object.
     * Retrieves the type of the entity.
     */

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * Creates a SELECT query to retrieve a specific record based on the provided field value.
     *
     * @param field The field to use in the WHERE clause of the query.
     * @return The SELECT query as a string.
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Creates a query to retrieve all records of the specified type.
     *
     * @return The query to retrieve all records as a string.
     */
    private String createViewAllQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM order_management.");
        sb.append(type.getSimpleName().toLowerCase());
        return sb.toString();
    }

    /**
     * Creates a DELETE query to delete a specific record based on the provided field value.
     *
     * @param field The field to use in the WHERE clause of the query.
     * @return The DELETE query as a string.
     */
    private String createDeleteQuery(String field){
        StringBuilder sb = new StringBuilder();
        //sb.append("DELETE FROM ");
        sb.append("DELETE ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " = " + " ?");
        return sb.toString();
    }

    /**
     * Creates an UPDATE query to update the specified record with the given values.
     *
     * @param t   The object representing the record to update.
     * @param id  The ID of the record to update.
     * @return The UPDATE query as a string.
     * @throws IllegalAccessException if there is an illegal access to a field during reflection.
     */
    private String createUpdateQuery (T t, int id) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE order_management.");
        sb.append(type.getSimpleName().toLowerCase());
        sb.append(" SET ");
        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.get(t) instanceof Integer) {
                sb.append(field.getName()+ " = " + field.get(t));
                sb.append(",");
            }else if (field.get(t) instanceof String){
                //sb.append("'");
                sb.append(field.getName()+ " = '" ) ;
                sb.append(field.get(t)+"'");
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(" WHERE id = " + id );
        return sb.toString();
    }

    /**
     * Creates an INSERT query to insert a new record with the given values.
     *
     * @param t The object representing the record to insert.
     * @return The INSERT query as a string.
     * @throws IllegalAccessException if there is an illegal access to a field during reflection.
     */
    private String createInsertQuery(T t) throws IllegalAccessException{
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT");
        sb.append(" INTO order_management.");
        sb.append(type.getSimpleName().toLowerCase());
        sb.append(" VALUES (");
        for(Field field : t.getClass().getDeclaredFields()){
            field.setAccessible(true);
            if(field.get(t) instanceof Integer){
                sb.append(field.get(t));
                sb.append(",");
            } else if (field.get(t) instanceof String){
                sb.append("'");
                sb.append(field.get(t));
                sb.append("'");
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        sb.append(";");
        return sb.toString();
    }

    /**
     * Retrieves all entities from the database.
     *
     * @return A list of entities.
     */

    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createViewAllQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param id    The ID of the entity.
     * @param field The field to search for the ID.
     * @return The found entity, or null if not found.
     */
    public T findById(int id, String field) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery(field);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Creates a list of objects of type T from the provided ResultSet.
     *
     * @param resultSet The ResultSet containing the data to create the objects from.
     * @return A list of objects of type T.
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Inserts an entity into the database.
     *
     * @param t The entity to be inserted.
     * @return The inserted entity.
     */
    public T insert(T t)  {
        Connection connection = null;
        PreparedStatement statement = null;
        //ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection();
            String query = createInsertQuery(t);
            statement = connection.prepareStatement(query);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(connection);
            ConnectionFactory.close(statement);
        }
        return t;
    }

    /**
     * Updates an entity in the database.
     *
     * @param t  The updated entity.
     * @param id The ID of the entity to update.
     * @return The updated entity.
     * @throws IllegalAccessException if the access to the entity's fields is illegal.
     */
    public T update(T t,int id) throws IllegalAccessException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            String query = createUpdateQuery(t,id);
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(connection);
            ConnectionFactory.close(statement);
        }
        return t;
    }
    /**
     * Deletes an entity from the database.
     *
     * @param field The field to search for the ID.
     * @param id    The ID of the entity to delete.
     */
    public void delete(String field,int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createDeleteQuery(field);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);

        }
    }

    /**
     * Creates a JTable representation of the provided data.
     *
     * @param data The data to be displayed in the JTable.
     * @return The created JTable.
     */
    public JTable jTable (ArrayList<T> data){
        Field[] fields = data.get(0).getClass().getDeclaredFields();
        ArrayList<String> columnsName = new ArrayList<>();
        for (Field field : fields){
            field.setAccessible(true);
            columnsName.add(field.getName());
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.setColumnIdentifiers(columnsName.toArray());
        for (T t : data){
            ArrayList<Object> objects = new ArrayList<>();
            Field[] objFields = t.getClass().getDeclaredFields();
            for (Field field : objFields){
                field.setAccessible(true);
                try {
                    objects.add(field.get(t));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            defaultTableModel.addRow(objects.toArray());
        }
        return new JTable(defaultTableModel);
    }
}

