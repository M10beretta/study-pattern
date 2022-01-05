package lesson275_object_pool;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var objectPool = new ObjectPool();

        var pooledObject = objectPool.getPooledObject();
        System.out.println(pooledObject);

        objectPool.releasePooledObject(pooledObject);
        System.out.println(objectPool.getPooledObject());
    }
}

class PooledObject {
}

class ObjectPool {
    List<PooledObject> free = new LinkedList<>();
    List<PooledObject> used = new LinkedList<>();

    public PooledObject getPooledObject() {
        PooledObject pooledObject;
        if (free.isEmpty()) {
            pooledObject = new PooledObject();
            free.add(pooledObject);
        } else {
            pooledObject = free.get(0);
            used.add(pooledObject);
            free.remove(pooledObject);
        }
        return pooledObject;
    }

    public void releasePooledObject(PooledObject pooledObject) {
        used.remove(pooledObject);
        free.add(pooledObject);
    }
}