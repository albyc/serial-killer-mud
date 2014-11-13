package MOBs;

import java.util.List;

import Items.Item;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public abstract class MOB 
{
	private String name;
	private String description;
	private List<Item> items;
	private int health; // ??
	
	/**
	 * 
	 * @param name
	 * @param description
	 */
	public MOB(String name, String description)
	{
		this.name = name;
	}
	
	/**
	 * 
	 * @param anItem
	 */
	public void addItem(Item anItem)
	{
		
	}
}
