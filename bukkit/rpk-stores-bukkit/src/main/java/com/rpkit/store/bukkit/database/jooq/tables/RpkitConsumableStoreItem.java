/*
 * This file is generated by jOOQ.
 */
package com.rpkit.store.bukkit.database.jooq.tables;


import com.rpkit.store.bukkit.database.jooq.Keys;
import com.rpkit.store.bukkit.database.jooq.RpkitStores;
import com.rpkit.store.bukkit.database.jooq.tables.records.RpkitConsumableStoreItemRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitConsumableStoreItem extends TableImpl<RpkitConsumableStoreItemRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_stores.rpkit_consumable_store_item</code>
     */
    public static final RpkitConsumableStoreItem RPKIT_CONSUMABLE_STORE_ITEM = new RpkitConsumableStoreItem();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitConsumableStoreItemRecord> getRecordType() {
        return RpkitConsumableStoreItemRecord.class;
    }

    /**
     * The column <code>rpkit_stores.rpkit_consumable_store_item.id</code>.
     */
    public final TableField<RpkitConsumableStoreItemRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit_stores.rpkit_consumable_store_item.store_item_id</code>.
     */
    public final TableField<RpkitConsumableStoreItemRecord, Integer> STORE_ITEM_ID = createField(DSL.name("store_item_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit_stores.rpkit_consumable_store_item.uses</code>.
     */
    public final TableField<RpkitConsumableStoreItemRecord, Integer> USES = createField(DSL.name("uses"), SQLDataType.INTEGER.nullable(false), this, "");

    private RpkitConsumableStoreItem(Name alias, Table<RpkitConsumableStoreItemRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitConsumableStoreItem(Name alias, Table<RpkitConsumableStoreItemRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>rpkit_stores.rpkit_consumable_store_item</code> table reference
     */
    public RpkitConsumableStoreItem(String alias) {
        this(DSL.name(alias), RPKIT_CONSUMABLE_STORE_ITEM);
    }

    /**
     * Create an aliased <code>rpkit_stores.rpkit_consumable_store_item</code> table reference
     */
    public RpkitConsumableStoreItem(Name alias) {
        this(alias, RPKIT_CONSUMABLE_STORE_ITEM);
    }

    /**
     * Create a <code>rpkit_stores.rpkit_consumable_store_item</code> table reference
     */
    public RpkitConsumableStoreItem() {
        this(DSL.name("rpkit_consumable_store_item"), null);
    }

    public <O extends Record> RpkitConsumableStoreItem(Table<O> child, ForeignKey<O, RpkitConsumableStoreItemRecord> key) {
        super(child, key, RPKIT_CONSUMABLE_STORE_ITEM);
    }

    @Override
    public Schema getSchema() {
        return RpkitStores.RPKIT_STORES;
    }

    @Override
    public Identity<RpkitConsumableStoreItemRecord, Integer> getIdentity() {
        return (Identity<RpkitConsumableStoreItemRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<RpkitConsumableStoreItemRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_CONSUMABLE_STORE_ITEM_PRIMARY;
    }

    @Override
    public List<UniqueKey<RpkitConsumableStoreItemRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitConsumableStoreItemRecord>>asList(Keys.KEY_RPKIT_CONSUMABLE_STORE_ITEM_PRIMARY);
    }

    @Override
    public RpkitConsumableStoreItem as(String alias) {
        return new RpkitConsumableStoreItem(DSL.name(alias), this);
    }

    @Override
    public RpkitConsumableStoreItem as(Name alias) {
        return new RpkitConsumableStoreItem(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitConsumableStoreItem rename(String name) {
        return new RpkitConsumableStoreItem(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitConsumableStoreItem rename(Name name) {
        return new RpkitConsumableStoreItem(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, Integer, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
