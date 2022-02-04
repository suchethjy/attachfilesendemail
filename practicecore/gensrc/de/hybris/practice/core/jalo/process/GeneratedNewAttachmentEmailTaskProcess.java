/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jan 28, 2022, 12:37:42 PM                   ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.practice.core.jalo.process;

import de.hybris.platform.commerceservices.jalo.process.StoreFrontCustomerProcess;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.practice.core.constants.PracticeCoreConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.practice.core.jalo.process.NewAttachmentEmailTaskProcess NewAttachmentEmailTaskProcess}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedNewAttachmentEmailTaskProcess extends StoreFrontCustomerProcess
{
	/** Qualifier of the <code>NewAttachmentEmailTaskProcess.newemail</code> attribute **/
	public static final String NEWEMAIL = "newemail";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(StoreFrontCustomerProcess.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(NEWEMAIL, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewAttachmentEmailTaskProcess.newemail</code> attribute.
	 * @return the newemail - Attribute contains token that is used in this process.
	 */
	public String getNewemail(final SessionContext ctx)
	{
		return (String)getProperty( ctx, NEWEMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewAttachmentEmailTaskProcess.newemail</code> attribute.
	 * @return the newemail - Attribute contains token that is used in this process.
	 */
	public String getNewemail()
	{
		return getNewemail( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewAttachmentEmailTaskProcess.newemail</code> attribute. 
	 * @param value the newemail - Attribute contains token that is used in this process.
	 */
	public void setNewemail(final SessionContext ctx, final String value)
	{
		setProperty(ctx, NEWEMAIL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewAttachmentEmailTaskProcess.newemail</code> attribute. 
	 * @param value the newemail - Attribute contains token that is used in this process.
	 */
	public void setNewemail(final String value)
	{
		setNewemail( getSession().getSessionContext(), value );
	}
	
}
