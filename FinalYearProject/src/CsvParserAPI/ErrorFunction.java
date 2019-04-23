package CsvParserAPI;

/*
 * Implementation of error functions
 * 
 * Average Distance Error Function = ESQD(W,t,k) where
 * W = workflows
 * t = time
 * k = first k jobs
 * Sqrt of (SUM first k jobs(Projected execution time of Job i - Observed execution time of Job i, observed time)) ^ 2 / k
 * 
 * 
 * Mean Absolute Percentage Error = EMAPE(W,t,k) 
 * 100 / k jobs 
 * SUM first k jobs(Projected execution time of Job i - Observed execution time of Job i, observed time)) / (Projected execution time of Job i)
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class ErrorFunction {

	
	public ErrorFunction() {
		
		
		
		
	}
	
	
	
	
	public float averageDistance(Trace[] data) {
		return 0;
		
	}
	
	
	
	public float meanAbsolutePercentageError(Trace[] data) {
		return 0;
	}
	
	
	
	public float timeAdjustedDistance(Trace[] data) {
		return 0;
	}
	
}


