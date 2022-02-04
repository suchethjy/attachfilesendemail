/**
 *
 */
package de.hybris.practice.facades.customer;

import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.core.model.user.CustomerModel;

import org.springframework.web.multipart.MultipartFile;


/**
 * @author Dell
 *
 */
public interface TaskCustomerFacade extends CustomerFacade
{

	void sendEmailBusiness(CustomerModel customerModel);

	void sendEmailWithAttachment(final MultipartFile file);

}
