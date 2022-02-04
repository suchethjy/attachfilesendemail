/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.practice.core.event;

import de.hybris.platform.acceleratorservices.site.AbstractAcceleratorSiteEventListener;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.enums.SiteChannel;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.util.ServicesUtil;
import de.hybris.practice.core.model.process.HybrisAttachEmailProcessModel;

import org.springframework.beans.factory.annotation.Required;


/**
 * Listener for "forgotten password" functionality event.
 */
public class HybrisAttachEmailEventListener extends AbstractAcceleratorSiteEventListener<HybrisAttachEmailEvent>
{

	private ModelService modelService;
	private BusinessProcessService businessProcessService;


	@Override
	protected void onSiteEvent(final HybrisAttachEmailEvent event)
	{
		final HybrisAttachEmailProcessModel hybrisAttachEmailProcessModel = (HybrisAttachEmailProcessModel) getBusinessProcessService()
				.createProcess("hybrisAttachEmail" + event.getCart().getCode() + "-" + System.currentTimeMillis(),
						"hybrisAttachEmailProcess");
		hybrisAttachEmailProcessModel.setCart(event.getCart());
		hybrisAttachEmailProcessModel.setCurrency(event.getCurrency());
		hybrisAttachEmailProcessModel.setStore(event.getBaseStore());
		hybrisAttachEmailProcessModel.setSite(event.getSite());
		hybrisAttachEmailProcessModel.setLanguage(event.getLanguage());

		getModelService().save(hybrisAttachEmailProcessModel);
		getBusinessProcessService().startProcess(hybrisAttachEmailProcessModel);
	}

	@Override
	protected SiteChannel getSiteChannelForEvent(final HybrisAttachEmailEvent event)
	{
		final BaseSiteModel site = event.getSite();
		ServicesUtil.validateParameterNotNullStandardMessage("event.site", site);
		return site.getChannel();
	}


	protected BusinessProcessService getBusinessProcessService()
	{
		return businessProcessService;
	}

	@Required
	public void setBusinessProcessService(final BusinessProcessService businessProcessService)
	{
		this.businessProcessService = businessProcessService;
	}

	/**
	 * @return the modelService
	 */
	protected ModelService getModelService()
	{
		return modelService;
	}

	/**
	 * @param modelService
	 *           the modelService to set
	 */
	@Required
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}
}
