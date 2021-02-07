/*
 * This file is generated by jOOQ.
 */
package com.rpkit.professions.bukkit.database.jooq.tables;


import com.rpkit.professions.bukkit.database.jooq.RpkitProfessions;
import com.rpkit.professions.bukkit.database.jooq.tables.records.RpkitCharacterProfessionExperienceRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitCharacterProfessionExperience extends TableImpl<RpkitCharacterProfessionExperienceRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_professions.rpkit_character_profession_experience</code>
     */
    public static final RpkitCharacterProfessionExperience RPKIT_CHARACTER_PROFESSION_EXPERIENCE = new RpkitCharacterProfessionExperience();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitCharacterProfessionExperienceRecord> getRecordType() {
        return RpkitCharacterProfessionExperienceRecord.class;
    }

    /**
     * The column <code>rpkit_professions.rpkit_character_profession_experience.character_id</code>.
     */
    public final TableField<RpkitCharacterProfessionExperienceRecord, Integer> CHARACTER_ID = createField(DSL.name("character_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rpkit_professions.rpkit_character_profession_experience.profession</code>.
     */
    public final TableField<RpkitCharacterProfessionExperienceRecord, String> PROFESSION = createField(DSL.name("profession"), SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>rpkit_professions.rpkit_character_profession_experience.experience</code>.
     */
    public final TableField<RpkitCharacterProfessionExperienceRecord, Integer> EXPERIENCE = createField(DSL.name("experience"), SQLDataType.INTEGER.nullable(false), this, "");

    private RpkitCharacterProfessionExperience(Name alias, Table<RpkitCharacterProfessionExperienceRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitCharacterProfessionExperience(Name alias, Table<RpkitCharacterProfessionExperienceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>rpkit_professions.rpkit_character_profession_experience</code> table reference
     */
    public RpkitCharacterProfessionExperience(String alias) {
        this(DSL.name(alias), RPKIT_CHARACTER_PROFESSION_EXPERIENCE);
    }

    /**
     * Create an aliased <code>rpkit_professions.rpkit_character_profession_experience</code> table reference
     */
    public RpkitCharacterProfessionExperience(Name alias) {
        this(alias, RPKIT_CHARACTER_PROFESSION_EXPERIENCE);
    }

    /**
     * Create a <code>rpkit_professions.rpkit_character_profession_experience</code> table reference
     */
    public RpkitCharacterProfessionExperience() {
        this(DSL.name("rpkit_character_profession_experience"), null);
    }

    public <O extends Record> RpkitCharacterProfessionExperience(Table<O> child, ForeignKey<O, RpkitCharacterProfessionExperienceRecord> key) {
        super(child, key, RPKIT_CHARACTER_PROFESSION_EXPERIENCE);
    }

    @Override
    public Schema getSchema() {
        return RpkitProfessions.RPKIT_PROFESSIONS;
    }

    @Override
    public RpkitCharacterProfessionExperience as(String alias) {
        return new RpkitCharacterProfessionExperience(DSL.name(alias), this);
    }

    @Override
    public RpkitCharacterProfessionExperience as(Name alias) {
        return new RpkitCharacterProfessionExperience(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitCharacterProfessionExperience rename(String name) {
        return new RpkitCharacterProfessionExperience(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitCharacterProfessionExperience rename(Name name) {
        return new RpkitCharacterProfessionExperience(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
