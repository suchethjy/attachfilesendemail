/**
 *
 */
package de.hybris.practice.core.service.impl;

import de.hybris.platform.acceleratorservices.email.EmailService;
import de.hybris.platform.acceleratorservices.model.email.EmailAttachmentModel;
import de.hybris.platform.commerceservices.customer.impl.DefaultCustomerAccountService;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.practice.core.event.NewAttachmentEmailEvent;
import de.hybris.practice.core.service.TaskCustomerAccountService;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Dell
 *
 */
public class DefaultTaskDefaultCustomerAccountService extends DefaultCustomerAccountService implements TaskCustomerAccountService
{
	@Autowired
	private EmailService emailService;

	@Override
	public void sendEmail(final CustomerModel customerModel) throws FileNotFoundException
	{
		getEventService().publishEvent(initializeGenerateItEmailEvent(new NewAttachmentEmailEvent(), customerModel));

	}

	private NewAttachmentEmailEvent initializeGenerateItEmailEvent(final NewAttachmentEmailEvent emailEvent,
			final CustomerModel customerModel) throws FileNotFoundException
	{

		final List<EmailAttachmentModel> emailAttachments = new ArrayList<>();

		final FileInputStream fi = new FileInputStream("D:\\image.txt");
		final DataInputStream inputStream = new DataInputStream(fi);
		final String date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SS").format(new Date());

		System.out.println("Service is layer @@@$$$$$$$$********************************...........");
		emailEvent.setBaseStore(getBaseStoreService().getCurrentBaseStore());
		emailEvent.setSite(getBaseSiteService().getCurrentBaseSite());
		emailEvent.setCustomer(customerModel);
		emailEvent.setLanguage(getCommonI18NService().getCurrentLanguage());
		emailEvent.setCurrency(getCommonI18NService().getCurrentCurrency());
		emailEvent.setNewemail("this is new email");

		final EmailAttachmentModel attachment = emailService.createEmailAttachment(inputStream, "fileattach" + date, "text/txt");
		emailAttachments.add(attachment);
		emailEvent.setEmailAttachments(emailAttachments);

		return emailEvent;

	}


}
