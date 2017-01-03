package com.github.mgramin.sqlboot.model;

import com.github.mgramin.sqlboot.actions.generator.IActionGenerator;
import com.github.mgramin.sqlboot.readers.IDBObjectReader;

import java.util.List;

import static java.util.Collections.*;

/**
 * Object type of DB schema
 * e.g. "table", "index", "pk", "stored procedure" etc
 */
public class DBSchemaObjectType {

    public String name;
    public String description;
    public List<DBSchemaObjectType> child;
    public List<IDBObjectReader> readers;
    public List<IActionGenerator> commands;

    /*Map<String, DBSchemaObject> read(ObjURI objURI) throws SqlBootException {
        return null;
    }*/

    public DBSchemaObjectType() {
    }

    public DBSchemaObjectType(String name, List<DBSchemaObjectType> child, List<IDBObjectReader> readers) {
        this.name = name;
        this.child = child;
        this.readers = readers;
    }

    public DBSchemaObjectType(String name, List<IDBObjectReader> reader) {
        this.name = name;
        this.readers = reader;
    }

    public DBSchemaObjectType(String name, IDBObjectReader reader) {
        this.name = name;
        this.readers = singletonList(reader);
    }

    public DBSchemaObjectType(String name, List<DBSchemaObjectType> child, IDBObjectReader reader) {
        this.name = name;
        this.child = child;
        this.readers = singletonList(reader);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setChild(List<DBSchemaObjectType> child) {
        this.child = child;
    }

    public void setCommands(List<IActionGenerator> commands) {
        this.commands = commands;
    }

    public void setReaders(List<IDBObjectReader> readers) {
        this.readers = readers;
    }

    @Override
    public String toString() {
        return "DBSchemaObjectType{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}