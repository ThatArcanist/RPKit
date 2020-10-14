/*
 * Copyright 2020 Ren Binden
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * This file is generated by jOOQ.
 */
package com.rpkit.moderation.bukkit.database.jooq.tables;


import com.rpkit.moderation.bukkit.database.jooq.Keys;
import com.rpkit.moderation.bukkit.database.jooq.RpkitModeration;
import com.rpkit.moderation.bukkit.database.jooq.tables.records.RpkitWarningRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitWarning extends TableImpl<RpkitWarningRecord> {

    private static final long serialVersionUID = 468848253;

    /**
     * The reference instance of <code>rpkit_moderation.rpkit_warning</code>
     */
    public static final RpkitWarning RPKIT_WARNING = new RpkitWarning();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitWarningRecord> getRecordType() {
        return RpkitWarningRecord.class;
    }

    /**
     * The column <code>rpkit_moderation.rpkit_warning.id</code>.
     */
    public final TableField<RpkitWarningRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit_moderation.rpkit_warning.reason</code>.
     */
    public final TableField<RpkitWarningRecord, String> REASON = createField(DSL.name("reason"), org.jooq.impl.SQLDataType.VARCHAR(1024).nullable(false), this, "");

    /**
     * The column <code>rpkit_moderation.rpkit_warning.profile_id</code>.
     */
    public final TableField<RpkitWarningRecord, Integer> PROFILE_ID = createField(DSL.name("profile_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit_moderation.rpkit_warning.issuer_id</code>.
     */
    public final TableField<RpkitWarningRecord, Integer> ISSUER_ID = createField(DSL.name("issuer_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit_moderation.rpkit_warning.time</code>.
     */
    public final TableField<RpkitWarningRecord, LocalDateTime> TIME = createField(DSL.name("time"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "");

    /**
     * Create a <code>rpkit_moderation.rpkit_warning</code> table reference
     */
    public RpkitWarning() {
        this(DSL.name("rpkit_warning"), null);
    }

    /**
     * Create an aliased <code>rpkit_moderation.rpkit_warning</code> table reference
     */
    public RpkitWarning(String alias) {
        this(DSL.name(alias), RPKIT_WARNING);
    }

    /**
     * Create an aliased <code>rpkit_moderation.rpkit_warning</code> table reference
     */
    public RpkitWarning(Name alias) {
        this(alias, RPKIT_WARNING);
    }

    private RpkitWarning(Name alias, Table<RpkitWarningRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitWarning(Name alias, Table<RpkitWarningRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> RpkitWarning(Table<O> child, ForeignKey<O, RpkitWarningRecord> key) {
        super(child, key, RPKIT_WARNING);
    }

    @Override
    public Schema getSchema() {
        return RpkitModeration.RPKIT_MODERATION;
    }

    @Override
    public Identity<RpkitWarningRecord, Integer> getIdentity() {
        return Keys.IDENTITY_RPKIT_WARNING;
    }

    @Override
    public UniqueKey<RpkitWarningRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_WARNING_PRIMARY;
    }

    @Override
    public List<UniqueKey<RpkitWarningRecord>> getKeys() {
        return Arrays.<UniqueKey<RpkitWarningRecord>>asList(Keys.KEY_RPKIT_WARNING_PRIMARY);
    }

    @Override
    public RpkitWarning as(String alias) {
        return new RpkitWarning(DSL.name(alias), this);
    }

    @Override
    public RpkitWarning as(Name alias) {
        return new RpkitWarning(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitWarning rename(String name) {
        return new RpkitWarning(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitWarning rename(Name name) {
        return new RpkitWarning(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, Integer, Integer, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
