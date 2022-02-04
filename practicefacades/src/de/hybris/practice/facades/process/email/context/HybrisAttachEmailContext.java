/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.practice.facades.process.email.context;

import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.practice.core.model.process.HybrisAttachEmailProcessModel;


/**
 * Velocity context for a customer email.
 */
public class HybrisAttachEmailContext extends AbstractEmailContext<HybrisAttachEmailProcessModel>
{

	@Override
	public void init(final HybrisAttachEmailProcessModel hybrisAttachEmailProcessModel, final EmailPageModel emailPageModel)
	{
		super.init(hybrisAttachEmailProcessModel, emailPageModel);
		put(EMAIL, getCustomerEmailResolutionService().getEmailForCustomer(getCustomer(hybrisAttachEmailProcessModel)));
		put(DISPLAY_NAME, getCustomer(hybrisAttachEmailProcessModel).getDisplayName());

	}

	@Override
	protected BaseSiteModel getSite(final HybrisAttachEmailProcessModel hybrisAttachEmailProcessModel)
	{
		// XXX Auto-generated method stub
		return hybrisAttachEmailProcessModel.getCart().getSite();
	}

	@Override
	protected CustomerModel getCustomer(final HybrisAttachEmailProcessModel hybrisAttachEmailProcessModel)
	{
		// XXX Auto-generated method stub
		return (CustomerModel) hybrisAttachEmailProcessModel.getCart().getUser();
	}

	@Override
	protected LanguageModel getEmailLanguage(final HybrisAttachEmailProcessModel hybrisAttachEmailProcessModel)
	{
		// XXX Auto-generated method stub
		return hybrisAttachEmailProcessModel.getCart().getUser().getSessionLanguage();
	}

}
