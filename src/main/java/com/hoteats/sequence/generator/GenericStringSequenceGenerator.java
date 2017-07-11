package com.hoteats.sequence.generator;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class GenericStringSequenceGenerator implements IdentifierGenerator {

	@Id
	@GeneratedValue(generator = "generic_string_seq_gen", strategy = GenerationType.SEQUENCE)
	@GenericGenerator(name = "generic_string_seq_gen", strategy = "com.hoteats.sequence.generator.GenericStringSequenceGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "hibernate_sequence"),
			@Parameter(name = "sequence_prefix", value = "ORD") })
	String testID;

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		final String claz = object.getClass().getSimpleName().toUpperCase();
		final String seqSQL = String.format("CALL NEXT VALUE FOR %s_SEQUENCE", claz);
		final String seqPrefix = StringSequenceHelper.getSequence(claz);
		long seq = ((Number) Session.class.cast(session).createSQLQuery(seqSQL).uniqueResult()).longValue();
		return seqPrefix + String.format("%07d", seq);
	}

}