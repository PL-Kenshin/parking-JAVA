package org.parking;

import org.sat4j.core.VecInt;
import org.sat4j.maxsat.WeightedMaxSatDecorator;
import org.sat4j.pb.PseudoOptDecorator;
import org.sat4j.tools.ModelIterator;
import org.sat4j.tools.OptToSatAdapter;

import java.util.ArrayList;
import java.util.List;

public class Solver {

    private ArrayList<Integer> result = new ArrayList<Integer>();

    public Solver(List<Zone> zones, String[] usersChoices) throws Exception {
        final int MAX_VAR = 11;
        final int NB_CLAUSES = zones.size()+9;
        WeightedMaxSatDecorator maxSatSolver = new WeightedMaxSatDecorator(
                org.sat4j.maxsat.SolverFactory.newDefault());

        ModelIterator solver = new ModelIterator( new OptToSatAdapter( new PseudoOptDecorator(maxSatSolver)));

        solver.newVar(MAX_VAR);
        solver.setExpectedNumberOfClauses(NB_CLAUSES);

        //U8 handicapped
        if (usersChoices[0].equals("Tak")){
            /*maxSatSolver.addSoftClause(30,new VecInt(new int[]{8}));
            maxSatSolver.addSoftClause(25,new VecInt(new int[]{11}));*/
        }else{
            /*maxSatSolver.addSoftClause(25,new VecInt(new int[]{-8}));
            maxSatSolver.addSoftClause(20,new VecInt(new int[]{9,-11}));*/
        }
        try {
            if (solver.isSatisfiable()){
                int [] temp =solver.model();

                for (int t : temp) result.add(t);
                System.out.println(result);
            }else{
                throw new Exception("Unsatisfiable formula");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public int test(ParkingLot parking) {

        int score = 0;
        int zone = parking.getZoneId();
        // is in selected zone
        if (zone >(-1) && result.get(zone)>0)
            score+=10;
        //S8 - for disabled
        if (result.contains(8) && parking.isForHandicapped()){
            score++;
        }
        else if (result.contains(-8) && !parking.isForHandicapped()) {
            score++;
        }
        return score;
    }
}