/*
 * This file is generated by jOOQ.
 */
package com.rpkit.blocklog.bukkit.database.jooq;


import com.rpkit.blocklog.bukkit.database.jooq.tables.FlywaySchemaHistoryBlocklogging;
import com.rpkit.blocklog.bukkit.database.jooq.tables.RpkitBlockChange;
import com.rpkit.blocklog.bukkit.database.jooq.tables.RpkitBlockHistory;
import com.rpkit.blocklog.bukkit.database.jooq.tables.RpkitBlockInventoryChange;
import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitBlockLogging extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_block_logging</code>
     */
    public static final RpkitBlockLogging RPKIT_BLOCK_LOGGING = new RpkitBlockLogging();

    /**
     * The table <code>rpkit_block_logging.flyway_schema_history_blocklogging</code>.
     */
    public final FlywaySchemaHistoryBlocklogging FLYWAY_SCHEMA_HISTORY_BLOCKLOGGING = FlywaySchemaHistoryBlocklogging.FLYWAY_SCHEMA_HISTORY_BLOCKLOGGING;

    /**
     * The table <code>rpkit_block_logging.rpkit_block_change</code>.
     */
    public final RpkitBlockChange RPKIT_BLOCK_CHANGE = RpkitBlockChange.RPKIT_BLOCK_CHANGE;

    /**
     * The table <code>rpkit_block_logging.rpkit_block_history</code>.
     */
    public final RpkitBlockHistory RPKIT_BLOCK_HISTORY = RpkitBlockHistory.RPKIT_BLOCK_HISTORY;

    /**
     * The table <code>rpkit_block_logging.rpkit_block_inventory_change</code>.
     */
    public final RpkitBlockInventoryChange RPKIT_BLOCK_INVENTORY_CHANGE = RpkitBlockInventoryChange.RPKIT_BLOCK_INVENTORY_CHANGE;

    /**
     * No further instances allowed
     */
    private RpkitBlockLogging() {
        super("rpkit_block_logging", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            FlywaySchemaHistoryBlocklogging.FLYWAY_SCHEMA_HISTORY_BLOCKLOGGING,
            RpkitBlockChange.RPKIT_BLOCK_CHANGE,
            RpkitBlockHistory.RPKIT_BLOCK_HISTORY,
            RpkitBlockInventoryChange.RPKIT_BLOCK_INVENTORY_CHANGE);
    }
}
