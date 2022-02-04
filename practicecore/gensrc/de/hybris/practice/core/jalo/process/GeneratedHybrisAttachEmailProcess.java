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
import de.hybris.platform.jalo.order.AbstractOrder;
import de.hybris.practice.core.constants.PracticeCoreConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.practice.core.jalo.process.HybrisAttachEmailProcess HybrisAttachEmailProcess}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedHybrisAttachEmailProcess extends StoreFrontCustomerProcess
{
	/** Qualifier of the <code>HybrisAttachEmailProcess.cart</code> attribute **/
	public static final String CART = "cart";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(StoreFrontCustomerProcess.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(CART, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>HybrisAttachEmailProcess.cart</code> attribute.
	 * @return the cart - Attribute contains token that is used in this process.
	 */
	public AbstractOrder getCart(final SessionContext ctx)
	{
		return (AbstractOrder)getProperty( ctx, CART);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>HybrisAttachEmailProcess.cart</code> attribute.
	 * @return the cart - Attribute contains token that is used in this process.
	 */
	public AbstractOrder getCart()
	{
		return getCart( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>HybrisAttachEmailProcess.cart</code> attribute. 
	 * @param value the cart - Attribute contains token that is used in this process.
	 */
	public void setCart(final SessionContext ctx, final AbstractOrder value)
	{
		setProperty(ctx, CART,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>HybrisAttachEmailProcess.cart</code> attribute. 
	 * @param value the cart - Attribute contains token that is used in this process.
	 */
	public void setCart(final AbstractOrder value)
	{
		setCart( getSession().getSessionContext(), value );
	}
	
}
