package org.usfirst.frc.team1751.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_jiggle_intake_shooter_release extends CommandGroup {

    public Auto_jiggle_intake_shooter_release() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addParallel (new IntakeIn(10));
    	addParallel (new Jiggle());
    	addParallel (new AutoShooter(11, -.87));
    	addParallel (new auto_releaseBalls());
    }
}
