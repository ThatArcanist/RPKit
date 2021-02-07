/*
 * This file is generated by jOOQ.
 */
package com.rpkit.essentials.bukkit.database.jooq;


import com.rpkit.essentials.bukkit.database.jooq.tables.FlywaySchemaHistoryPlayers;
import com.rpkit.essentials.bukkit.database.jooq.tables.RpkitLogMessagesEnabled;
import com.rpkit.essentials.bukkit.database.jooq.tables.RpkitPreviousLocation;
import com.rpkit.essentials.bukkit.database.jooq.tables.RpkitTrackingDisabled;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitEssentials extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_essentials</code>
     */
    public static final RpkitEssentials RPKIT_ESSENTIALS = new RpkitEssentials();

    /**
     * The table <code>rpkit_essentials.flyway_schema_history_players</code>.
     */
    public final FlywaySchemaHistoryPlayers FLYWAY_SCHEMA_HISTORY_PLAYERS = FlywaySchemaHistoryPlayers.FLYWAY_SCHEMA_HISTORY_PLAYERS;

    /**
     * The table <code>rpkit_essentials.rpkit_log_messages_enabled</code>.
     */
    public final RpkitLogMessagesEnabled RPKIT_LOG_MESSAGES_ENABLED = RpkitLogMessagesEnabled.RPKIT_LOG_MESSAGES_ENABLED;

    /**
     * The table <code>rpkit_essentials.rpkit_previous_location</code>.
     */
    public final RpkitPreviousLocation RPKIT_PREVIOUS_LOCATION = RpkitPreviousLocation.RPKIT_PREVIOUS_LOCATION;

    /**
     * The table <code>rpkit_essentials.rpkit_tracking_disabled</code>.
     */
    public final RpkitTrackingDisabled RPKIT_TRACKING_DISABLED = RpkitTrackingDisabled.RPKIT_TRACKING_DISABLED;

    /**
     * No further instances allowed
     */
    private RpkitEssentials() {
        super("rpkit_essentials", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            FlywaySchemaHistoryPlayers.FLYWAY_SCHEMA_HISTORY_PLAYERS,
            RpkitLogMessagesEnabled.RPKIT_LOG_MESSAGES_ENABLED,
            RpkitPreviousLocation.RPKIT_PREVIOUS_LOCATION,
            RpkitTrackingDisabled.RPKIT_TRACKING_DISABLED);
    }
}
