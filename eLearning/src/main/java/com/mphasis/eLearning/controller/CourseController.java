package com.mphasis.eLearning.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mphasis.eLearning.entity.Course;
import com.mphasis.eLearning.entity.Modules;
import com.mphasis.eLearning.entity.Vedio;
import com.mphasis.eLearning.service.CourseService;

@CrossOrigin("*")
@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseService courseService;
	@PostMapping(value ="addcourse",consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> addCourse(@RequestBody Course course) {
		  Course course1=courseService.addCourse(course);
		 return new ResponseEntity<>(course1,HttpStatus.OK);
	}
	@GetMapping("/getallcourses")
	public ResponseEntity<?> getAllCourses(){
		List<Course> courseList=courseService.getAllCourses();
		if(courseList!=null) {
			return new ResponseEntity<>(courseList,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No courses are present",HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/getcoursebyid/{courseid}")
	public ResponseEntity<?> getCourseById(@PathVariable("courseid") int courseId){
		Course course=courseService.getCourseById(courseId);
		if(course!=null) {
			return new ResponseEntity<>(course,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Course doesnot found with given courseId",HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/updatecourse")
	public ResponseEntity<?> updateCourse(@RequestBody Course course){
		Course course1=courseService.updateCourse(course);
		return new ResponseEntity<>(course1,HttpStatus.OK);
	}
	@DeleteMapping("/deletecourse/{courseid}")
	public ResponseEntity<?> deleteCourseById(@PathVariable("courseid") int courseid){
		Course course=courseService.deleteCourse(courseid);
		if(course!=null) {
			return new ResponseEntity<>(course,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("course doesnot found with given courseid ",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallcoursesbylevel/{levelName}")
	public ResponseEntity<?> getAllCoursesByLevel(@PathVariable String levelName){
		List<Course> courseList=courseService.getAllCoursedByLevel(levelName);
		if(courseList!=null) {
			return new ResponseEntity<>(courseList,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No courses are present",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallcoursesbycategory/{categoryName}")
	public ResponseEntity<?> getAllCoursesByCategory(@PathVariable String categoryName){
		List<Course> courseList=courseService.getAllCoursedByCategory(categoryName);
		if(courseList!=null) {
			return new ResponseEntity<>(courseList,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No courses are present",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallcoursesbyinstructor/{instructorName}")
	public ResponseEntity<?> getAllCoursesByInstructor(@PathVariable String instructorName){
		List<Course> courseList=courseService.getAllCoursedByInstructor(instructorName);
		if(courseList!=null) {
			return new ResponseEntity<>(courseList,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No courses are present",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallcoursesbycategoryandlevel/{categoryName}/{levelName}")
	public ResponseEntity<?> getAllCoursesByCategiryAndLevel(@PathVariable String categoryName,@PathVariable String levelName){
		List<Course> courseList=courseService.getCourseByLevelAndCategory(categoryName,levelName);
		if(courseList!=null) {
			return new ResponseEntity<>(courseList,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No courses are present",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("getassigned/{employeeId}")
	public ResponseEntity<?> getAssignedEmployees(@PathVariable("employeeId") int emloyeeId)
	{
		List<Course> Course=courseService.getAssignedEmployeeCourses(emloyeeId);
		if(!Course.isEmpty()) {
		return new ResponseEntity<>(Course,HttpStatusCode.valueOf(200));
		}
		else {
			return new ResponseEntity<>("No Courses Assigned",HttpStatusCode.valueOf(404));
		}
	}
	
	@GetMapping("getprogress/{courseId}/{employeeId}")
	public ResponseEntity<?> getProgress(@PathVariable("courseId") int courseId,@PathVariable("employeeId") int employeeId)
	{
		double progress=courseService.countOfQuizIdByReports(courseId,employeeId);
		return new ResponseEntity<>(progress,HttpStatusCode.valueOf(200));
		
		
	}
	
	@PostMapping(value = "/addCourse1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> addCourseWithFiles(
	    @RequestPart("course") String courseJson,
	    @RequestPart(value = "materialFiles", required = false) List<MultipartFile> materialFiles,
	    @RequestPart(value = "videoFiles", required = false) List<MultipartFile> videoFiles) {

	    try {
	        // Convert JSON string to Course object
	        ObjectMapper objectMapper = new ObjectMapper();
	        Course course = objectMapper.readValue(courseJson, Course.class);

	        // Print course details (for debugging)
	        System.out.println("Course Name: " + course.getCourseName());
	        System.out.println("Number of Modules: " + course.getModuleList().size());

	        // Ensure the course has modules before proceeding
	        if (course.getModuleList() == null || course.getModuleList().isEmpty()) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No modules found in the course.");
	        }

	        int moduleCount = course.getModuleList().size();

	        // Map material files to course modules
	        if (materialFiles != null && !materialFiles.isEmpty()) {
	            for (int i = 0; i < materialFiles.size(); i++) {
	                if (i >= moduleCount) {
	                    System.out.println("Skipping extra material file: " + materialFiles.get(i).getOriginalFilename());
	                    continue; // Prevents out-of-bounds error
	                }
	                MultipartFile materialFile = materialFiles.get(i);
	                if (!materialFile.isEmpty()) {
	                    Modules module = course.getModuleList().get(i);
	                    module.setMaterialName(materialFile.getOriginalFilename());
	                    module.setMaterialType(materialFile.getContentType());
	                    module.setFiledata(materialFile.getBytes());
	                    System.out.println("Uploaded Material: " + materialFile.getOriginalFilename());
	                }
	            }
	        }

	        // Map video files to course modules
	        if (videoFiles != null && !videoFiles.isEmpty()) {
	            for (int i = 0; i < videoFiles.size(); i++) {
	                if (i >= moduleCount) {
	                    System.out.println("Skipping extra video file: " + videoFiles.get(i).getOriginalFilename());
	                    continue; // Prevents out-of-bounds error
	                }
	                MultipartFile videoFile = videoFiles.get(i);
	                if (!videoFile.isEmpty()) {
	                    Modules module = course.getModuleList().get(i);

	                    // Ensure the video reference list is initialized
	                    if (module.getVedioRef() == null) {
	                        module.setVedioRef(new ArrayList<>());
	                    }

	                    Vedio video = new Vedio();
	                    video.setVedioName(videoFile.getOriginalFilename());
	                    video.setContentType(videoFile.getContentType());
	                    video.setVedioData(videoFile.getBytes());
	                    module.getVedioRef().add(video);

	                    System.out.println("Uploaded Video: " + videoFile.getOriginalFilename());
	                }
	            }
	        }

	        // Save the course object to the database
	        Course savedCourse = courseService.addCourse(course);
	        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);

	    } catch (IOException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add course: " + e.getMessage());
	    }
	}
	@GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById1(@PathVariable("id") int id) {
        Course course = courseService.findById(id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course);
    }

    @GetMapping("/{courseId}/modules/{moduleId}/material")
    public ResponseEntity<ByteArrayResource> getModuleMaterial(@PathVariable int courseId, @PathVariable int moduleId) {
        Modules module = courseService.findModuleById(courseId, moduleId);
        if (module == null || module.getFiledata() == null) {
            return ResponseEntity.notFound().build();
        }

        String materialType = module.getMaterialType();
        MediaType mediaType = MediaType.APPLICATION_OCTET_STREAM;
        if ("pdf".equalsIgnoreCase(materialType)) {
            mediaType = MediaType.APPLICATION_PDF;
        } else if ("mp4".equalsIgnoreCase(materialType)) {
            mediaType = MediaType.valueOf("video/mp4");
        }

        return ResponseEntity.ok()
                .contentType(mediaType)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + module.getMaterialName() + "\"")
                .body(new ByteArrayResource(module.getFiledata()));
    }



        @GetMapping("/{courseId}/videos/{videoId}")
        public ResponseEntity<Resource> streamVideo(
                @PathVariable int courseId,
                @PathVariable int videoId,
                @RequestHeader HttpHeaders headers) {
            // Retrieve the course by ID
            Course course = courseService.getCourseById(courseId);
            if (course == null) {
                return ResponseEntity.notFound().build();
            }

            // Find the specific video in the course's modules
            Vedio video = null;
            for (Modules module : course.getModuleList()) {
                for (Vedio v : module.getVedioRef()) {
                    if (v.getVedioId() == videoId) {
                        video = v;
                        break;
                    }
                }
                if (video != null) break;
            }

            if (video == null) {
                return ResponseEntity.notFound().build();
            }

            byte[] data = video.getVedioData();
            ByteArrayResource resource = new ByteArrayResource(data);
            long fileLength = data.length;
            String contentType = video.getContentType();

            // Handle range requests for streaming
            if (headers.containsKey(HttpHeaders.RANGE)) {
                HttpRange range = headers.getRange().get(0);
                long start = range.getRangeStart(fileLength);
                long end = range.getRangeEnd(fileLength);
                long rangeLength = Math.min(end - start + 1, fileLength - start);

                return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                        .header(HttpHeaders.CONTENT_TYPE, contentType)
                        .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(rangeLength))
                        .header(HttpHeaders.CONTENT_RANGE, "bytes " + start + "-" + end + "/" + fileLength)
                        .body(new ByteArrayResource(Arrays.copyOfRange(data, (int) start, (int) end + 1)));
            } else {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, contentType)
                        .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(fileLength))
                        .body(resource);
            }
        
    }

}
