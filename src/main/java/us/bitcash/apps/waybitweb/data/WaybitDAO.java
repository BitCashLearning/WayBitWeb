package us.bitcash.apps.waybitweb.data;

import us.bitcash.apps.waybitweb.domain.Waybitmoji;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class WaybitDAO {

    protected WaybitDAO() {}

    /*
    Operates on the retrieved ResultSet to assemble a List of waybitmoji objects.
     */
    public List <Waybitmoji> buildCollection(ResultSet results) throws SQLException {
        List <Waybitmoji> collection = new ArrayList <> ();

        while (results.next()) {
            Waybitmoji emoji = new Waybitmoji();
            try {
                emoji.setUuid(results.getString("wbm_id"));
                emoji.setName(results.getString("name"));
                emoji.setPrice(results.getDouble("price"));
                collection.add(emoji);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return collection;
    }

    /*
    connects to and queries the database, stores the results in a ResultSet, calls buildCollection
    for it to operate on the passed in container and then returns the resulting built collection as its output.
     */
    public List <Waybitmoji> getFullCollection() {

        List <Waybitmoji> collection;

        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/waybit?useSSL=false", "root", "password"); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM waybitmojis");
        ) {
            collection = buildCollection(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return collection;
    }

    /*
    Streams the results of querying the entire database and then filters it using the provided predicate function
     */
    public List <Waybitmoji> filterBy(Predicate <Waybitmoji> filter) {
        return getFullCollection().stream().filter(filter).toList();
    }

    /*
    Directly queries the database for a waybitmoji record that has the passed in id.
     */
    public Optional <Waybitmoji> findById(String id) {

        List <Waybitmoji> res;

        try ( Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/waybit?useSSL=false", "root", "password");
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM waybitmojis WHERE wbm_id = ?");
             ResultSet rs = stmt.executeQuery(); ) {

            res = buildCollection(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return res.isEmpty() ? Optional.empty() : Optional.of(res.get(0));
    }
}