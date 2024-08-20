// Receiver class that performs the actual operations
class HomeAutomationSystem {
    public void turnOnLights() {
        System.out.println("Lights are turned ON.");
    }

    public void turnOffLights() {
        System.out.println("Lights are turned OFF.");
    }

    public void turnOnAC() {
        System.out.println("Air Conditioner is turned ON.");
    }

    public void turnOffAC() {
        System.out.println("Air Conditioner is turned OFF.");
    }

    public void playMusic() {
        System.out.println("Music is playing.");
    }

    public void stopMusic() {
        System.out.println("Music is stopped.");
    }
}

// Command interface declares a method for executing commands
interface Command {
    void execute();
}

// Concrete command classes for turning lights on and off
class LightOnCommand implements Command {
    private HomeAutomationSystem receiver;

    public LightOnCommand(HomeAutomationSystem receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnOnLights(); // Executes the turn on lights operation
    }
}

class LightOffCommand implements Command {
    private HomeAutomationSystem receiver;

    public LightOffCommand(HomeAutomationSystem receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnOffLights(); // Executes the turn off lights operation
    }
}

// Concrete command classes for turning AC on and off
class ACOnCommand implements Command {
    private HomeAutomationSystem receiver;

    public ACOnCommand(HomeAutomationSystem receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnOnAC(); // Executes the turn on AC operation
    }
}

class ACOffCommand implements Command {
    private HomeAutomationSystem receiver;

    public ACOffCommand(HomeAutomationSystem receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnOffAC(); // Executes the turn off AC operation
    }
}

// Concrete command classes for playing and stopping music
class MusicOnCommand implements Command {
    private HomeAutomationSystem receiver;

    public MusicOnCommand(HomeAutomationSystem receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.playMusic(); // Executes the play music operation
    }
}

class MusicOffCommand implements Command {
    private HomeAutomationSystem receiver;

    public MusicOffCommand(HomeAutomationSystem receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.stopMusic(); // Executes the stop music operation
    }
}

// Invoker class that triggers command execution
class RemoteControl {
    public void pressButton(Command command) {
        command.execute(); // Executes the command
    }
}

// Client code that sets up and triggers commands
public class HomeAutomationApp {
    public static void main(String[] args){
        HomeAutomationSystem homeSystem = new HomeAutomationSystem(); // Create the receiver
        RemoteControl remote = new RemoteControl(); // Create the invoker

        // Create command objects with the receiver
        Command lightOn = new LightOnCommand(homeSystem);
        Command lightOff = new LightOffCommand(homeSystem);
        Command acOn = new ACOnCommand(homeSystem);
        Command acOff = new ACOffCommand(homeSystem);
        Command musicOn = new MusicOnCommand(homeSystem);
        Command musicOff = new MusicOffCommand(homeSystem);

        // Process commands using the invoker
        remote.pressButton(lightOn); // Turn on the lights
        remote.pressButton(acOn);    // Turn on the air conditioner
        remote.pressButton(musicOn); // Start playing music
        remote.pressButton(lightOff); // Turn off the lights
        remote.pressButton(acOff);   // Turn off the air conditioner
        remote.pressButton(musicOff); // Stop the music
    }
}
