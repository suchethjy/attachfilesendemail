/**
 *
 */
package de.hybris.practice.core.event;


import de.hybris.platform.acceleratorservices.email.EmailService;
import de.hybris.platform.acceleratorservices.model.email.EmailAttachmentModel;
import de.hybris.platform.commerceservices.model.process.StoreFrontProcessModel;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.practice.facades.events.LastEmailTaskEvent;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LastEmailTaskEventListener extends AbstractEventListener<LastEmailTaskEvent>
{

	private ModelService modelService;
	private BusinessProcessService businessProcessService;
	private EmailService emailService;

	@Override
	protected void onEvent(final LastEmailTaskEvent event)
	{
		final StoreFrontProcessModel storeFrontProcessModel = (StoreFrontProcessModel) getBusinessProcessService().createProcess(
				"lastEmailTaskProcess" + event.getCustomer().getUid() + "-" + System.currentTimeMillis(), "lastEmailTaskProcess");

		storeFrontProcessModel.setSite(event.getSite());
		storeFrontProcessModel.setUser(event.getCustomer());


		DataInputStream inputStream = null;
		try
		{
			inputStream = new DataInputStream(event.getFile().getInputStream());
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}


		final EmailAttachmentModel attachment = getEmailService().createEmailAttachment(inputStream,
				event.getFile().getOriginalFilename(), event.getFile().getContentType());
		final List<EmailAttachmentModel> attachments = new ArrayList();
		attachments.add(attachment);

		storeFrontProcessModel.setAttachments(attachments);
		getModelService().save(storeFrontProcessModel);
		getBusinessProcessService().startProcess(storeFrontProcessModel);
	}




	public EmailService getEmailService()
	{
		return emailService;
	}

	public void setEmailService(final EmailService emailService)
	{
		this.emailService = emailService;
	}

	public ModelService getModelService()
	{
		return modelService;
	}

	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	public BusinessProcessService getBusinessProcessService()
	{
		return businessProcessService;
	}

	public void setBusinessProcessService(final BusinessProcessService businessProcessService)
	{
		this.businessProcessService = businessProcessService;
	}




}
