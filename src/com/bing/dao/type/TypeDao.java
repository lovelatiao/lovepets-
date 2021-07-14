package com.bing.dao.type;

import java.sql.Connection;
import java.util.ArrayList;

public interface TypeDao {
    public abstract ArrayList getType(Connection  connection);
}
