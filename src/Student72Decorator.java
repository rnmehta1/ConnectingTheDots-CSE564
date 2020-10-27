/*
Author: Anurag Mishra
File Version: 1.0
Time required: 3 hours
*/
public class Student72Decorator extends Student71 {
	
	protected Student71 student;
	
	public void add(Student71 student) {
		this.student = student;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.student.getId();
	}

	@Override
	public String getFirst_name() {
		// TODO Auto-generated method stub
		return this.student.getFirst_name();
	}

	@Override
	public String getLast_name() {
		// TODO Auto-generated method stub
		return this.student.getLast_name();
	}

	@Override
	public String getProgramPlan() {
		// TODO Auto-generated method stub
		return this.student.getProgramPlan();
	}

	@Override
	public String getAcademic_level() {
		// TODO Auto-generated method stub
		return this.student.getAcademic_level();
	}

	@Override
	public String getAsurite() {
		// TODO Auto-generated method stub
		return this.student.getAsurite();
	}
	
	@Override
    public void printValue(){
		if (student != null) {
			this.student.printValue();
		}       
    }

}
