package org.parking;

import org.sat4j.core.VecInt;
import org.sat4j.maxsat.SolverFactory;
import org.sat4j.maxsat.WeightedMaxSatDecorator;
import org.sat4j.pb.PseudoOptDecorator;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.TimeoutException;
import org.sat4j.tools.ModelIterator;
import org.sat4j.tools.OptToSatAdapter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WeightedMaxSatSolver {
    private WeightedMaxSatDecorator weightedMaxSatDecorator;
    private ModelIterator solver;
    private int varRange;
    WeightedMaxSatSolver(int varRange, int ExpectedNumberOfClauses){
        this.varRange = varRange;
        weightedMaxSatDecorator = new WeightedMaxSatDecorator(
                SolverFactory.newDefault());
        solver = new ModelIterator(
                new OptToSatAdapter( new PseudoOptDecorator(weightedMaxSatDecorator)));
        solver.newVar(varRange);
        solver.setExpectedNumberOfClauses(ExpectedNumberOfClauses);
    }

    public void addClause(long weight,int id) throws ContradictionException {
        var clause = generateClausule(id);
        weightedMaxSatDecorator.addSoftClause((int)weight,new VecInt(clause));
    }

    public Optional<List> model() throws TimeoutException {
        if (solver.isSatisfiable()){
            return Optional.of(Arrays.stream(solver.model()).mapToObj(x->x>0).collect(Collectors.toList()));
        } else {
            return Optional.empty();
        }
    }

    private int[] generateClausule(int id){
            int[] vars = new int[varRange];
            for(int i=0;i<varRange;i++){
                if(i==id){
                    vars[i]=i+1;
                }
                else{
                    vars[i]=-(i+1);
                }
            }
            return vars;
    }

}