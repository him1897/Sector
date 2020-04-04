package sjob.model.vo;

import java.io.Serializable;

public class Sjob implements Serializable {

	
	private static final long SerialUID = 1400L;
	
	public String jobId;
	public String jobName;
	
	public Sjob() {}

	/*public Sjob(String jobId, String jobName) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
	}*/

/*	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		return "Sjob [jobId=" + jobId + ", jobName=" + jobName + "]";
	}
	*/
}
