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
package com.rpkit.chat.bukkit.database.jooq.tables;


import com.rpkit.chat.bukkit.database.jooq.RpkitChat;
import com.rpkit.chat.bukkit.database.jooq.tables.records.RpkitLastUsedChatGroupRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitLastUsedChatGroup extends TableImpl<RpkitLastUsedChatGroupRecord> {

    private static final long serialVersionUID = 425106507;

    /**
     * The reference instance of <code>rpkit_chat.rpkit_last_used_chat_group</code>
     */
    public static final RpkitLastUsedChatGroup RPKIT_LAST_USED_CHAT_GROUP = new RpkitLastUsedChatGroup();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitLastUsedChatGroupRecord> getRecordType() {
        return RpkitLastUsedChatGroupRecord.class;
    }

    /**
     * The column <code>rpkit_chat.rpkit_last_used_chat_group.minecraft_profile_id</code>.
     */
    public final TableField<RpkitLastUsedChatGroupRecord, Integer> MINECRAFT_PROFILE_ID = createField(DSL.name("minecraft_profile_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit_chat.rpkit_last_used_chat_group.chat_group_id</code>.
     */
    public final TableField<RpkitLastUsedChatGroupRecord, Integer> CHAT_GROUP_ID = createField(DSL.name("chat_group_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>rpkit_chat.rpkit_last_used_chat_group</code> table reference
     */
    public RpkitLastUsedChatGroup() {
        this(DSL.name("rpkit_last_used_chat_group"), null);
    }

    /**
     * Create an aliased <code>rpkit_chat.rpkit_last_used_chat_group</code> table reference
     */
    public RpkitLastUsedChatGroup(String alias) {
        this(DSL.name(alias), RPKIT_LAST_USED_CHAT_GROUP);
    }

    /**
     * Create an aliased <code>rpkit_chat.rpkit_last_used_chat_group</code> table reference
     */
    public RpkitLastUsedChatGroup(Name alias) {
        this(alias, RPKIT_LAST_USED_CHAT_GROUP);
    }

    private RpkitLastUsedChatGroup(Name alias, Table<RpkitLastUsedChatGroupRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitLastUsedChatGroup(Name alias, Table<RpkitLastUsedChatGroupRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> RpkitLastUsedChatGroup(Table<O> child, ForeignKey<O, RpkitLastUsedChatGroupRecord> key) {
        super(child, key, RPKIT_LAST_USED_CHAT_GROUP);
    }

    @Override
    public Schema getSchema() {
        return RpkitChat.RPKIT_CHAT;
    }

    @Override
    public RpkitLastUsedChatGroup as(String alias) {
        return new RpkitLastUsedChatGroup(DSL.name(alias), this);
    }

    @Override
    public RpkitLastUsedChatGroup as(Name alias) {
        return new RpkitLastUsedChatGroup(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitLastUsedChatGroup rename(String name) {
        return new RpkitLastUsedChatGroup(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitLastUsedChatGroup rename(Name name) {
        return new RpkitLastUsedChatGroup(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
