package us.bitcash.apps.waybitweb.data;

public class WaybitDAOFactory {
    private WaybitDAOFactory(){}

    private static WaybitDAO waybitDAO;

    public static WaybitDAO getWaybitDAO() {
        return waybitDAO != null ? waybitDAO : new WaybitDAO();
    }
}
