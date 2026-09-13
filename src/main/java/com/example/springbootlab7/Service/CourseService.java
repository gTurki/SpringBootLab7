package com.example.springbootlab7.Service;

import com.example.springbootlab7.Model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {

    private final ArrayList<Course> courses = new ArrayList<>();

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public boolean updateCourse(String id, Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId().equalsIgnoreCase(id)) {
                courses.set(i, course);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(String id) {
        for (Course c : courses) {
            if (c.getId().equalsIgnoreCase(id)) {
                courses.remove(c);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Course> getCoursesHasXCreditsOrMore(double credits) {
        ArrayList<Course> temp = new ArrayList<>();

        for (Course c : courses) {
            if (c.getCredits() >= credits) {
                temp.add(c);
            }
        }
        return temp;
    }

    public boolean changeCourseInstructor(String id, String instructor) {
        for (Course c : courses) {
            if (c.getId().equalsIgnoreCase(id)) {
                c.setAssociatedInstructor(instructor);
                return true;
            }
        }
        return false;
    }
}
