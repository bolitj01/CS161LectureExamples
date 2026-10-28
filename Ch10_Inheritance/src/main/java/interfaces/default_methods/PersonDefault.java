package interfaces.default_methods;
/**
   This class implements the Displayable
   interface, but does not override the
   default display method.
 */

public class PersonDefault implements Displayable
{
	@SuppressWarnings("unused")
	private String name;

	// Constructor
	public PersonDefault(String n)
	{
		name = n;
	}
}
