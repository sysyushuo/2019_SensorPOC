package frc.robot.commands.auton.adaptivePaths;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.commands.auton.Auton_ParallelStarter;
import frc.robot.commands.auton.adaptivePaths.planPath;

public class CG_FollowVisionPath extends CommandGroup {

    double timeOut = 10;
    
    public CG_FollowVisionPath(double a1, double a2, double l){
        addParallel(new Auton_ParallelStarter());
        addSequential(new planPath(a1, a2, l));
        addSequential(new followVisionProfile(timeOut));
    }
}