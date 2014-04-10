package jmetal.experiments;

import java.io.IOException;

import jmetal.util.JMException;

 
public class NSGAII_OPLA_FeatMutInitializer implements AlgorithmBase{

    	private ExperimentCommomConfigs config;
    	
	public NSGAII_OPLA_FeatMutInitializer(ExperimentCommomConfigs config){
    	    this.config = config;
    	}
    
	@Override
	public void run() {
		NSGAII_OPLA_FeatMut nsgaiiFeatMut = new NSGAII_OPLA_FeatMut(this.config);
		try {
			nsgaiiFeatMut.execute();
		} catch (ClassNotFoundException | IOException| JMException e) {
			e.printStackTrace();
		}
	}

	
}