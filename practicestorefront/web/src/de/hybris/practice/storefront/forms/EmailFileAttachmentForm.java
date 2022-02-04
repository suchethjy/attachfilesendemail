package de.hybris.practice.storefront.forms;

import org.springframework.web.multipart.MultipartFile;


/**
 *
 */

/**
 * @author Dell
 *
 */
public class EmailFileAttachmentForm
{
	private MultipartFile file;

	private String name;

	/**
	 * @return the file
	 */
	public MultipartFile getFile()
	{
		return file;
	}

	/**
	 * @param file
	 *           the file to set
	 */
	public void setFile(final MultipartFile file)
	{
		this.file = file;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}



}
