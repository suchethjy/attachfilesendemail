/**
 *
 */
package de.hybris.practice.core.event;

import de.hybris.platform.acceleratorservices.site.AbstractAcceleratorSiteEventListener;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.enums.SiteChannel;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.util.ServicesUtil;
import de.hybris.practice.core.model.process.NewAttachmentEmailTaskProcessModel;


/**
 * @author Dell
 *
 */
public class NewAttachmentEmailEventListener extends AbstractAcceleratorSiteEventListener<NewAttachmentEmailEvent>
{
	private ModelService modelService;
	private BusinessProcessService businessProcessService;


	@Override
	protected void onSiteEvent(final NewAttachmentEmailEvent event)
	{
		System.out.println("this is a event listener!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		final NewAttachmentEmailTaskProcessModel generatingEmailProcessModel = (NewAttachmentEmailTaskProcessModel) getBusinessProcessService()
				.createProcess("generateAttachmentEmail" + event.getCustomer().getUid() + "-" + System.currentTimeMillis(),
						"newAttachmentEmailTaskProcess");
		generatingEmailProcessModel.setSite(event.getSite());
		generatingEmailProcessModel.setCustomer(event.getCustomer());
		generatingEmailProcessModel.setNewemail(event.getNewemail());
		generatingEmailProcessModel.setLanguage(event.getLanguage());
		generatingEmailProcessModel.setCurrency(event.getCurrency());
		generatingEmailProcessModel.setStore(event.getBaseStore());
		System.out.println("Attachment getting started");
		generatingEmailProcessModel.setAttachments(event.getEmailAttachments());


		getModelService().save(generatingEmailProcessModel);

		getBusinessProcessService().startProcess(generatingEmailProcessModel);

	}

	@Override
	protected SiteChannel getSiteChannelForEvent(final NewAttachmentEmailEvent event)
	{
		final BaseSiteModel site = event.getSite();
		ServicesUtil.validateParameterNotNullStandardMessage("event.site", site);
		return site.getChannel();
	}



	/**
	 * @return the modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}

	/**
	 * @param modelService
	 *           the modelService to set
	 */
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	/**
	 * @return the businessProcessService
	 */
	public BusinessProcessService getBusinessProcessService()
	{
		return businessProcessService;
	}

	/**
	 * @param businessProcessService
	 *           the businessProcessService to set
	 */
	public void setBusinessProcessService(final BusinessProcessService businessProcessService)
	{
		this.businessProcessService = businessProcessService;
	}


}
