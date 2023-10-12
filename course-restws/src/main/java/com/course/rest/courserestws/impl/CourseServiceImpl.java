package com.course.rest.courserestws.impl;

import com.course.rest.courserestws.model.Course;
import com.course.rest.courserestws.service.CourseService;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.*;


@Service
public class CourseServiceImpl implements CourseService {

    Map<Integer, Course> courseMap = new HashMap<>();
    int currentId = 123;

    public CourseServiceImpl(){
        initData();
    }

    private void initData() {
        Course course = new Course();
        course.setCourseId(currentId);
        course.setCourseName("Java Soap Ws");
        course.setCoursePrice(150.50);
        course.setRating("Very Good");
        course.setInstructorName("Hussein Nasser");

        courseMap.put(course.getCourseId(),course);

    }

    @Override
    public List<Course> getAllCourses() {
        Collection<Course> courses = courseMap.values();
        ArrayList<Course> response = new ArrayList<>(courses);
        return response;
    }

    @Override
    public Course getCoursesById(long id) {
        return null;
    }

    @Override
    public Response createCourse(Course course) {
        return null;
    }

    @Override
    public Response updateCourse(Course course) {
        return null;
    }

    @Override
    public Response deleteCourse(long id) {
        return null;
    }
}
