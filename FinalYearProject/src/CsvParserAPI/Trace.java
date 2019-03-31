package CsvParserAPI;

/* This is a class created to represent each trace from a dataset.
 * Used to create data structures accordingly to the user requirements
 * Contains all attributes of a trace from dataset
 * 
 */

public class Trace {
	
	private String fileExt;
	private int jobID;
	private int workflowPhase;
	private double pastErrorOfPhase;
	private double futureErrorOfPhase;
	private int job1Runtime;
	private int job2Runtime;
	private int job3Runtime;
	private int job4Runtime;
	private int job5Runtime;
	private int job6Runtime;
	private int job7Runtime;
	private int job8Runtime;
	private int job9Runtime;
	private int job10Runtime;
	private int job11Runtime;
	private int job12Runtime;
	private int job13Runtime;
	private int job14Runtime;
	private int job15Runtime;
	private int job16Runtime;
	private int job17Runtime;
	private int job18Runtime;
	private int job19Runtime;
	private int job20Runtime;

	
	public Trace(String fileExt, int JobID, int workflowPhase, double pastErrorOfPhase, double futureErrorOfPhase, int job1Runtime, int job2Runtime, int job3Runtime, int job4Runtime, int job5Runtime, int job6Runtime, int job7Runtime, int job8Runtime, int job9Runtime, int job10Runtime, int job11Runtime, int job12Runtime, int job13Runtime, int job14Runtime, int job15Runtime, int job16Runtime, int job17Runtime, int job18Runtime, int job19Runtime, int job20Runtime) {
		this.fileExt = fileExt;
		this.jobID = JobID;
		this.workflowPhase = workflowPhase;
		this.pastErrorOfPhase = pastErrorOfPhase;
		this.futureErrorOfPhase = futureErrorOfPhase;
		this.job1Runtime = job1Runtime;
		this.job2Runtime = job2Runtime;
		this.job3Runtime = job3Runtime;
		this.job4Runtime = job4Runtime;
		this.job5Runtime = job5Runtime;
		this.job6Runtime = job6Runtime;
		this.job7Runtime = job7Runtime;
		this.job8Runtime = job8Runtime;
		this.job9Runtime = job9Runtime;
		this.job10Runtime = job10Runtime;
		this.job11Runtime = job11Runtime;
		this.job12Runtime = job12Runtime;
		this.job13Runtime = job13Runtime;
		this.job14Runtime = job14Runtime;
		this.job15Runtime = job15Runtime;
		this.job16Runtime = job16Runtime;
		this.job17Runtime = job17Runtime;
		this.job18Runtime = job18Runtime;
		this.job19Runtime = job19Runtime;
		this.job20Runtime = job20Runtime;
	}
	
	public String getTraceExtension() {
		return fileExt;
	}

	public int getJobID() {
		return jobID;
	}
	
	public int getWorkFlowPhase() {
		return workflowPhase;
	}
	
	public double getPastErrorOfPhase() {
		return pastErrorOfPhase;
	}
	
	public double getfutureErrorOfPhase() {
		return futureErrorOfPhase;
	}
	
	public int getJob1Runtime() {
		return job1Runtime;
	}
	
	public int getJob2Runtime() {
		return job2Runtime;
	}
	
	public int getJob3Runtime() {
		return job3Runtime;
	}
	
	public int getJob4Runtime() {
		return job4Runtime;
	}
	
	public int getJob5Runtime() {
		return job5Runtime;
	}
	
	public int getJob6Runtime() {
		return job6Runtime;
	}
	
	public int getJob7Runtime() {
		return job7Runtime;
	}
	
	public int getJob8Runtime() {
		return job8Runtime;
	}
	
	public int getJob9Runtime() {
		return job9Runtime;
	}
	
	public int getJob10Runtime() {
		return job10Runtime;
	}
	
	public int getJob11Runtime() {
		return job11Runtime;
	}
	
	public int getJob12Runtime() {
		return job12Runtime;
	}
	
	public int getJob13Runtime() {
		return job13Runtime;
	}
	
	public int getJob14Runtime() {
		return job14Runtime;
	}
	
	public int getJob15Runtime() {
		return job15Runtime;
	}
	
	public int getJob16Runtime() {
		return job16Runtime;
	}
	
	public int getJob17Runtime() {
		return job17Runtime;
	}
	
	public int getJob18Runtime() {
		return job18Runtime;
	}
	
	public int getJob19Runtime() {
		return job19Runtime;
	}
	
	public int getJob20Runtime() {
		return job20Runtime;
	}
}
