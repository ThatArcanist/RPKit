/*
 * This file is generated by jOOQ.
 */
package com.rpkit.professions.bukkit.database.jooq;


import com.rpkit.professions.bukkit.database.jooq.tables.RpkitCharacterProfession;
import com.rpkit.professions.bukkit.database.jooq.tables.RpkitCharacterProfessionChangeCooldown;
import com.rpkit.professions.bukkit.database.jooq.tables.RpkitCharacterProfessionExperience;
import com.rpkit.professions.bukkit.database.jooq.tables.RpkitProfessionHidden;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitProfessions extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_professions</code>
     */
    public static final RpkitProfessions RPKIT_PROFESSIONS = new RpkitProfessions();

    /**
     * The table <code>rpkit_professions.rpkit_character_profession</code>.
     */
    public final RpkitCharacterProfession RPKIT_CHARACTER_PROFESSION = RpkitCharacterProfession.RPKIT_CHARACTER_PROFESSION;

    /**
     * The table <code>rpkit_professions.rpkit_character_profession_change_cooldown</code>.
     */
    public final RpkitCharacterProfessionChangeCooldown RPKIT_CHARACTER_PROFESSION_CHANGE_COOLDOWN = RpkitCharacterProfessionChangeCooldown.RPKIT_CHARACTER_PROFESSION_CHANGE_COOLDOWN;

    /**
     * The table <code>rpkit_professions.rpkit_character_profession_experience</code>.
     */
    public final RpkitCharacterProfessionExperience RPKIT_CHARACTER_PROFESSION_EXPERIENCE = RpkitCharacterProfessionExperience.RPKIT_CHARACTER_PROFESSION_EXPERIENCE;

    /**
     * The table <code>rpkit_professions.rpkit_profession_hidden</code>.
     */
    public final RpkitProfessionHidden RPKIT_PROFESSION_HIDDEN = RpkitProfessionHidden.RPKIT_PROFESSION_HIDDEN;

    /**
     * No further instances allowed
     */
    private RpkitProfessions() {
        super("rpkit_professions", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            RpkitCharacterProfession.RPKIT_CHARACTER_PROFESSION,
            RpkitCharacterProfessionChangeCooldown.RPKIT_CHARACTER_PROFESSION_CHANGE_COOLDOWN,
            RpkitCharacterProfessionExperience.RPKIT_CHARACTER_PROFESSION_EXPERIENCE,
            RpkitProfessionHidden.RPKIT_PROFESSION_HIDDEN);
    }
}
