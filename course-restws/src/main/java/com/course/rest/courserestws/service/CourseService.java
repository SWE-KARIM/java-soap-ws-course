package com.course.rest.courserestws.service;

import com.course.rest.courserestws.model.Course;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")

@Path("/course-service")
public interface CourseService {

    @Path("/courses")
    @GET
    List<Course> getAllCourses();

    @Path("/courses/{id}")
    @GET
    Course getCoursesById(@PathParam(value = "id") long id);

    @Path("/courses")
    @POST
    Response createCourse(Course course);

    @Path("/courses")
    @PUT
    Response updateCourse(Course course);

    @Path("/courses/{id}")
    @DELETE
    Response deleteCourse(@PathParam(value = "id") long id);
}
