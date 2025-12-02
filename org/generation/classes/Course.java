package org.generation.classes;

public class Course 
{
	
    public String name;

    public int credits;

    public String professorName;

    public Course( String name, int credits, String professorName )
    {
        this.name = name;
        this.credits = credits;
        this.professorName = professorName;
    } // bob el constructor

	public String getName() {
		return name;
	} // get name

	public void setName(String name) {
		this.name = name;
	} // set name

	public int getCredits() {
		return credits;
	} // get credits

	public void setCredits(int credits) {
		this.credits = credits;
	} // set credits

	public String getProfessorName() {
		return professorName;
	} // get prof name

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	} // set prof name

	@Override
	public String toString() {
		return "Course [name=" + name + ", credits=" + credits + ", professorName=" + professorName + "]";
	}
    
    
    
}
