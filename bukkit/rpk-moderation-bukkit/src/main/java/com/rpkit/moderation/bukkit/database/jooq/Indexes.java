/*
 * This file is generated by jOOQ.
 */
package com.rpkit.moderation.bukkit.database.jooq;


import com.rpkit.moderation.bukkit.database.jooq.tables.FlywaySchemaHistoryPlayers;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables in rpkit_moderation.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index FLYWAY_SCHEMA_HISTORY_PLAYERS_FLYWAY_SCHEMA_HISTORY_PLAYERS_S_IDX = Internal.createIndex(DSL.name("flyway_schema_history_players_s_idx"), FlywaySchemaHistoryPlayers.FLYWAY_SCHEMA_HISTORY_PLAYERS, new OrderField[] { FlywaySchemaHistoryPlayers.FLYWAY_SCHEMA_HISTORY_PLAYERS.SUCCESS }, false);
}
