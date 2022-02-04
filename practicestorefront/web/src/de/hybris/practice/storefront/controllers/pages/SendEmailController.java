/**
 *
 */
package de.hybris.practice.storefront.controllers.pages;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.practice.facades.customer.TaskCustomerFacade;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dell
 *
 */
@Controller

public class SendEmailController
{
	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "customerFacade")
	private TaskCustomerFacade customerFacade;


	@RequestMapping(value = "/generateEmail")
	public String sendEmailBusiness()
	{

		System.out.println("email is being generated at this stage of this process.............................");

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		customerFacade.sendEmailBusiness(customerModel);
		return "redirect:/";

	}


}
