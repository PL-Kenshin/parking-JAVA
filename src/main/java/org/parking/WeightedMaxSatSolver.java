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
    WeightedMaxSatSolver(int varRange, int ExpectedNumberOfClauses){
        weightedMaxSatDecorator = new WeightedMaxSatDecorator(
                SolverFactory.newDefault());
        solver = new ModelIterator(
                new OptToSatAdapter( new PseudoOptDecorator(weightedMaxSatDecorator)));
        solver.newVar(varRange);
        solver.setExpectedNumberOfClauses(ExpectedNumberOfClauses);
    }

    public void addClause(int weight,int[] clause) throws ContradictionException {
        weightedMaxSatDecorator.addSoftClause(weight,new VecInt(clause));
    }

    public Optional<List> model() throws TimeoutException {
        if (solver.isSatisfiable()){
            return Optional.of(Arrays.stream(solver.model()).mapToObj(x->x>0).collect(Collectors.toList()));
        } else {
            return Optional.empty();
        }
    }

}