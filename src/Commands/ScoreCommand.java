package Commands;

import Controller.*;

public class ScoreCommand extends Command<Client>
{
	private static final long serialVersionUID = 1L;

	public void execute(Client executeOn)
	{
		executeOn.listScore();
	}
} // end of class ScoreCommand
