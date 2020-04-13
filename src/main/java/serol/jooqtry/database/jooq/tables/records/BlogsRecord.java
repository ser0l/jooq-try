/*
 * This file is generated by jOOQ.
 */
package serol.jooqtry.database.jooq.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;
import serol.jooqtry.database.jooq.tables.Blogs;

import javax.annotation.processing.Generated;
import java.sql.Timestamp;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BlogsRecord extends UpdatableRecordImpl<BlogsRecord> implements Record5<Integer, String, Timestamp, Timestamp, String> {

    private static final long serialVersionUID = -961687770;

    /**
     * Setter for <code>jooqtry.blogs.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>jooqtry.blogs.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>jooqtry.blogs.author</code>.
     */
    public void setAuthor(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>jooqtry.blogs.author</code>.
     */
    public String getAuthor() {
        return (String) get(1);
    }

    /**
     * Setter for <code>jooqtry.blogs.date_published</code>.
     */
    public void setDatePublished(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>jooqtry.blogs.date_published</code>.
     */
    public Timestamp getDatePublished() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>jooqtry.blogs.date_edited</code>.
     */
    public void setDateEdited(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>jooqtry.blogs.date_edited</code>.
     */
    public Timestamp getDateEdited() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>jooqtry.blogs.text</code>.
     */
    public void setText(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>jooqtry.blogs.text</code>.
     */
    public String getText() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, Timestamp, Timestamp, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, String, Timestamp, Timestamp, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Blogs.BLOGS.ID;
    }

    @Override
    public Field<String> field2() {
        return Blogs.BLOGS.AUTHOR;
    }

    @Override
    public Field<Timestamp> field3() {
        return Blogs.BLOGS.DATE_PUBLISHED;
    }

    @Override
    public Field<Timestamp> field4() {
        return Blogs.BLOGS.DATE_EDITED;
    }

    @Override
    public Field<String> field5() {
        return Blogs.BLOGS.TEXT;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getAuthor();
    }

    @Override
    public Timestamp component3() {
        return getDatePublished();
    }

    @Override
    public Timestamp component4() {
        return getDateEdited();
    }

    @Override
    public String component5() {
        return getText();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getAuthor();
    }

    @Override
    public Timestamp value3() {
        return getDatePublished();
    }

    @Override
    public Timestamp value4() {
        return getDateEdited();
    }

    @Override
    public String value5() {
        return getText();
    }

    @Override
    public BlogsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public BlogsRecord value2(String value) {
        setAuthor(value);
        return this;
    }

    @Override
    public BlogsRecord value3(Timestamp value) {
        setDatePublished(value);
        return this;
    }

    @Override
    public BlogsRecord value4(Timestamp value) {
        setDateEdited(value);
        return this;
    }

    @Override
    public BlogsRecord value5(String value) {
        setText(value);
        return this;
    }

    @Override
    public BlogsRecord values(Integer value1, String value2, Timestamp value3, Timestamp value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BlogsRecord
     */
    public BlogsRecord() {
        super(Blogs.BLOGS);
    }

    /**
     * Create a detached, initialised BlogsRecord
     */
    public BlogsRecord(Integer id, String author, Timestamp datePublished, Timestamp dateEdited, String text) {
        super(Blogs.BLOGS);

        set(0, id);
        set(1, author);
        set(2, datePublished);
        set(3, dateEdited);
        set(4, text);
    }
}
