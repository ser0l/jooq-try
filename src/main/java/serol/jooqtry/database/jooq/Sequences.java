/*
 * This file is generated by jOOQ.
 */
package serol.jooqtry.database.jooq;


import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;

import javax.annotation.processing.Generated;


/**
 * Convenience access to all sequences in jooqtry
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>jooqtry.blogs_id_seq</code>
     */
    public static final Sequence<Long> BLOGS_ID_SEQ = new SequenceImpl<Long>("blogs_id_seq", Jooqtry.JOOQTRY, org.jooq.impl.SQLDataType.BIGINT.nullable(false));
}
