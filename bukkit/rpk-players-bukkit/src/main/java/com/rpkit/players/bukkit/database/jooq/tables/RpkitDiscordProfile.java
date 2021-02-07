/*
 * This file is generated by jOOQ.
 */
package com.rpkit.players.bukkit.database.jooq.tables;


import com.rpkit.players.bukkit.database.jooq.Keys;
import com.rpkit.players.bukkit.database.jooq.RpkitPlayers;
import com.rpkit.players.bukkit.database.jooq.tables.records.RpkitDiscordProfileRecord;

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
public class RpkitDiscordProfile extends TableImpl<RpkitDiscordProfileRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_players.rpkit_discord_profile</code>
     */
    public static final RpkitDiscordProfile RPKIT_DISCORD_PROFILE = new RpkitDiscordProfile();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitDiscordProfileRecord> getRecordType() {
        return RpkitDiscordProfileRecord.class;
    }

    /**
     * The column <code>rpkit_players.rpkit_discord_profile.id</code>.
     */
    public final TableField<RpkitDiscordProfileRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit_players.rpkit_discord_profile.profile_id</code>.
     */
    public final TableField<RpkitDiscordProfileRecord, Integer> PROFILE_ID = createField(DSL.name("profile_id"), SQLDataType.INTEGER.defaultValue(DSL.inline("NULL", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>rpkit_players.rpkit_discord_profile.discord_id</code>.
     */
    public final TableField<RpkitDiscordProfileRecord, Long> DISCORD_ID = createField(DSL.name("discord_id"), SQLDataType.BIGINT.nullable(false), this, "");

    private RpkitDiscordProfile(Name alias, Table<RpkitDiscordProfileRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitDiscordProfile(Name alias, Table<RpkitDiscordProfileRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>rpkit_players.rpkit_discord_profile</code> table reference
     */
    public RpkitDiscordProfile(String alias) {
        this(DSL.name(alias), RPKIT_DISCORD_PROFILE);
    }

    /**
     * Create an aliased <code>rpkit_players.rpkit_discord_profile</code> table reference
     */
    public RpkitDiscordProfile(Name alias) {
        this(alias, RPKIT_DISCORD_PROFILE);
    }

    /**
     * Create a <code>rpkit_players.rpkit_discord_profile</code> table reference
     */
    public RpkitDiscordProfile() {
        this(DSL.name("rpkit_discord_profile"), null);
    }

    public <O extends Record> RpkitDiscordProfile(Table<O> child, ForeignKey<O, RpkitDiscordProfileRecord> key) {
        super(child, key, RPKIT_DISCORD_PROFILE);
    }

    @Override
    public Schema getSchema() {
        return RpkitPlayers.RPKIT_PLAYERS;
    }

    @Override
    public Identity<RpkitDiscordProfileRecord, Integer> getIdentity() {
        return (Identity<RpkitDiscordProfileRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<RpkitDiscordProfileRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_DISCORD_PROFILE_PRIMARY;
    }

    @Override
    public List<UniqueKey<RpkitDiscordProfileRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitDiscordProfileRecord>>asList(Keys.KEY_RPKIT_DISCORD_PROFILE_PRIMARY);
    }

    @Override
    public RpkitDiscordProfile as(String alias) {
        return new RpkitDiscordProfile(DSL.name(alias), this);
    }

    @Override
    public RpkitDiscordProfile as(Name alias) {
        return new RpkitDiscordProfile(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitDiscordProfile rename(String name) {
        return new RpkitDiscordProfile(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitDiscordProfile rename(Name name) {
        return new RpkitDiscordProfile(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, Integer, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
