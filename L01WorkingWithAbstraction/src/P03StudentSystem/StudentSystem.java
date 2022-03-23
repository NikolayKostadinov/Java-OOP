package P03StudentSystem;

import input.Reader;

public class StudentSystem {
    private final CommandHandler handler;
    private boolean isWorking;
    public StudentSystem(CommandHandler handler)
    {
        this.handler = handler;
    }

    public void start() {
        isWorking = true;

        while (isWorking)
        {
            String result = handler.handleCommand(Reader.readStringArray("\\s+"));

            if (result!= null && !"Exit".equals(result)){
                ConsolePrinter.printLine(result);
            }

            isWorking = !"Exit".equals(result);
        }
    }
}
