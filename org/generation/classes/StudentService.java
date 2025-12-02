package org.generation.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.generation.exceptions.CourseNotFoundException;
import org.generation.exceptions.StudentNotFoundException;

public class StudentService
{
    private HashMap<String, Course> courseList = new HashMap<>();

    private HashMap<String, Student> students = new HashMap<>();

    private HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();


    private StudentService()
    {
        courseList.put( "Math", new Course( "Math", 10, "Aurelio Baldor" ) );
        courseList.put( "Physics", new Course( "Physics", 10, "Albert Einstein" ) );
        courseList.put( "Art", new Course( "Art", 10, "Pablo Picasso" ) );
        courseList.put( "History", new Course( "History", 10, "Sima Qian" ) );
        courseList.put( "Biology", new Course( "Biology", 10, "Charles Darwin" ) );
    } // constructor

    private void enrollStudents( String courseName, String studentID ) throws CourseNotFoundException, 
    StudentNotFoundException
    {
    	if (! courseList.containsKey(courseName)) {
    		throw new CourseNotFoundException("El curso [" + courseName + "] no existe");
    	} // ! contains key
    	if (! students.containsKey(studentID)) {
    		throw new StudentNotFoundException("El estudiante [" + courseName + "] no existe");
    	} // contains key
        Course course = courseList.get( courseName );

        if ( !coursesEnrolledByStudents.containsKey( studentID ) )
        {
            coursesEnrolledByStudents.put( studentID, new ArrayList<>() );
        } // if !
        coursesEnrolledByStudents.get( studentID ).add( course );
    } // enroll students

    private void unEnrollStudents( String courseName, String studentID )
    {
        Course course = courseList.get( courseName );

        if ( coursesEnrolledByStudents.containsKey( studentID ) )
        {
            coursesEnrolledByStudents.get( studentID ).remove( course );
        } // if
    } // unenroll students

    private void showEnrolledStudents(String courseId){
    	Course course = courseList.get(courseId);
    	System.out.println(courseId + " estan inscritos: ");
    	for (String studentId : coursesEnrolledByStudents.keySet()) {
    		List<Course> allCourses = coursesEnrolledByStudents.get(studentId);
    		if (allCourses.contains(course)) {
    			Student student = students.get(studentId);
    			System.out.println(student);
    		} // if
    	} // foreach
    	System.out.println("=========================================================================");
	} // show enroll students

    public void addStudents (Student student) {
    	if (! students.containsKey(student.getId())) {
        	students.put(student.getId(), student);
    	}
    
    } // add student(s)
    
	    private void showAllCourses(){
		for (Course coure : courseList.values()); {
			System.out.println(course.toString());
		}
	} // show all courses
	    
}