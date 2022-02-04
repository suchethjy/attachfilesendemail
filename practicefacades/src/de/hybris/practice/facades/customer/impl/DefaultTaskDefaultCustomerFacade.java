/**
 *
 */
package de.hybris.practice.facades.customer.impl;

import de.hybris.platform.commercefacades.customer.impl.DefaultCustomerFacade;

/**
*
*/


import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.practice.core.service.TaskCustomerAccountService;
import de.hybris.practice.facades.customer.TaskCustomerFacade;
import de.hybris.practice.facades.events.LastEmailTaskEvent;

import org.springframework.web.multipart.MultipartFile;


/**
 * @author Dell
 *
 */
public class DefaultTaskDefaultCustomerFacade extends DefaultCustomerFacade implements TaskCustomerFacade
{
	private TaskCustomerAccountService taskCustomerAccountService;

	@Override
	public void sendEmailBusiness(final CustomerModel customerModel)
	{
		//taskCustomerAccountService.sendEmail(customerModel);
	}




	/**
	 * @return the taskCustomerAccountService
	 */
	public TaskCustomerAccountService getTaskCustomerAccountService()
	{
		return taskCustomerAccountService;
	}

	/**
	 * @param taskCustomerAccountService
	 *           the taskCustomerAccountService to set
	 */
	public void setTaskCustomerAccountService(final TaskCustomerAccountService taskCustomerAccountService)
	{
		this.taskCustomerAccountService = taskCustomerAccountService;
	}




	@Override
	public void sendEmailWithAttachment(final MultipartFile file)
	{

		final CustomerModel currentCustomer = (CustomerModel) getUserService().getCurrentUser();
		final LastEmailTaskEvent lastEmail = new LastEmailTaskEvent();
		lastEmail.setCustomer(currentCustomer);
		lastEmail.setSite(getBaseSiteService().getCurrentBaseSite());
		lastEmail.setFile(file);
		getEventService().publishEvent(lastEmail);

	}

	/**
	 * @return the customerAccountService
	 */

}