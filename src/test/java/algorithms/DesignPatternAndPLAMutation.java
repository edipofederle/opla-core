package algorithms;

import java.util.HashMap;

import jmetal.operators.mutation.Mutation;
import jmetal.operators.mutation.PLAFeatureMutation;
import jmetal.util.PseudoRandom;
import br.ufpr.inf.opla.patterns.operator.impl.DesignPatternMutationOperator;

public class DesignPatternAndPLAMutation extends Mutation {
    
    /**
     * 
     */
    private static final long serialVersionUID = 3896434361251147825L;
    private DesignPatternMutationOperator dpm;
    private PLAFeatureMutation pf;
    
    public DesignPatternAndPLAMutation(HashMap<String, Object> parameter, DesignPatternMutationOperator dpm, PLAFeatureMutation pf) {
	super(parameter);
	this.dpm = dpm;
	this.pf = pf;
    }

    @Override
    public Object execute(Object object) throws Exception {
	int mutationQuantity = this.pf.getMutationOperators().size();
	int r = PseudoRandom.randInt(0, mutationQuantity);
	System.out.println(r);
	if(r == 0){
	    return this.dpm.execute(object);
	}else{
	    return this.pf.execute(object);
	}
	
    }

}
