package us.bitcash.apps.waybitweb.data;

import us.bitcash.apps.waybitweb.domain.Waybitmoji;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class WaybitDAO {

    private List<Waybitmoji> list;

    public WaybitDAO() {
        list = new ArrayList<>();

        list.add(new Waybitmoji(this,"Wumpus",57.23));
        list.add(new Waybitmoji(this,"Ceraye",231.17));
        list.add(new Waybitmoji(this,"Morris",64.88));
        list.add(new Waybitmoji(this,"Philip",27.62));
        list.add(new Waybitmoji(this,"Jay",11.24));
        list.add(new Waybitmoji(this,"Stormus",357.33));
        list.add(new Waybitmoji(this,"Alcatraz",120.12));
        list.add(new Waybitmoji(this,"WarNet",15.57));
        list.add(new Waybitmoji(this,"ChatGPT",677.54));
        list.add(new Waybitmoji(this,"Gemini",852.67));
        list.add(new Waybitmoji(this,"Copilot",552.47));
        list.add(new Waybitmoji(this,"Tara",37.23));
        list.add(new Waybitmoji(this,"Ethereum",537.23));
        list.add(new Waybitmoji(this,"Bubble",36.81));
        list.add(new Waybitmoji(this,"Walkman",82.32));
        list.add(new Waybitmoji(this,"Lockheed",75.23));
        list.add(new Waybitmoji(this,"Mackeral",12.21));
        list.add(new Waybitmoji(this,"BoomBot",121.32));
        list.add(new Waybitmoji(this,"SpotifyAPI",1.52));

    }

    public List<Waybitmoji> getAll() {
        return this.list;
    }

    public List<Waybitmoji> findBy(Predicate<Waybitmoji> filter) {
        return this.list.stream()
                .filter(filter)
                .collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
    }




}
