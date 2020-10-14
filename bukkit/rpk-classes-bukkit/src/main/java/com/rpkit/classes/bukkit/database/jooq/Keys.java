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
package com.rpkit.classes.bukkit.database.jooq;


import com.rpkit.classes.bukkit.database.jooq.tables.RpkitCharacterClass;
import com.rpkit.classes.bukkit.database.jooq.tables.records.RpkitCharacterClassRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>rpkit_classes</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<RpkitCharacterClassRecord> KEY_RPKIT_CHARACTER_CLASS_PRIMARY = UniqueKeys0.KEY_RPKIT_CHARACTER_CLASS_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<RpkitCharacterClassRecord> KEY_RPKIT_CHARACTER_CLASS_PRIMARY = Internal.createUniqueKey(RpkitCharacterClass.RPKIT_CHARACTER_CLASS, "KEY_rpkit_character_class_PRIMARY", new TableField[] { RpkitCharacterClass.RPKIT_CHARACTER_CLASS.CHARACTER_ID }, true);
    }
}
