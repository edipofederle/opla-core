package persistence;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import metrics.Elegance;

public class ElegancePersistence {
	
	private Statement statement;
	
	public ElegancePersistence(Statement statement){
		this.statement = statement;
	}
	
    /**
     * Save to database
     */
    public void save(Elegance eleganceMetric) {
    	
    	String executionID = "''";
    	if(eleganceMetric.getExecution() != null)
    		executionID = eleganceMetric.getExecution().getId();
    	
    	StringBuilder query = new StringBuilder();
    	query.append("insert into EleganceMetrics (nac,atmr,ec,elegance,execution_id, experiement_id, is_all) values (");
    	query.append(eleganceMetric.getNac());
    	query.append(",");
    	query.append(eleganceMetric.getAtmr());
    	query.append(",");
    	query.append(eleganceMetric.getEc());
    	query.append(",");
    	query.append(eleganceMetric.total());
    	query.append(",");
		query.append(executionID);
		query.append(",");
		query.append(eleganceMetric.getExperiment().getId());
		query.append(",");
		if(eleganceMetric.getExecution() == null)
			query.append("1");
		else
			query.append("0");
    	query.append(")");
    	
        try {
            this.statement.executeUpdate(query.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Elegance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
