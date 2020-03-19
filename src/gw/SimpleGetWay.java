package gw;

import exceptions.EntityNotFound;
import models.EntityClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleGetWay<T extends EntityClass> implements GetWay<T> {
    private int id = 0;

    protected Map<Integer, T> db = new HashMap<>();

    @Override
    public List<T> all() {
        return new ArrayList<T>(db.values());
    }

    @Override
    public T find(int id) throws EntityNotFound {
        T obj = db.get(id);
        if(obj == null){
            throw new EntityNotFound(String.format("Entity with %id not found", id));
        }
        return obj;
    }

    @Override
    public void insert(T object) {
        int your_id = ++id;
        db.put(your_id,object);
        object.setId(your_id);
    }

    @Override
    public void update(T object) throws EntityNotFound {
        if (db.containsKey(object.getId())){
            db.put(object.getId(),object);
        }
        else
            throw new EntityNotFound(String.format("Entity with %id not found", object.getId()));
    }

    @Override
    public void delete(int id) {
        db.remove(id);
    }
}
