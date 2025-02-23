package com.mphasis.eLearning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mphasis.eLearning.entity.Course;
import com.mphasis.eLearning.entity.Modules;
import com.mphasis.eLearning.entity.Vedio;
import com.mphasis.eLearning.repository.CourseRepository;
import com.mphasis.eLearning.repository.ReportsRepository;

@Service
public class CourseService implements ICourseService{
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	private ReportsRepository reportsRepository;

	@Override
	public Course addCourse(Course course) {
		courseRepository.save(course);
		return course;
	}

	@Override
	public Course deleteCourse(int courseId) {
		Course course=null;
		if(courseRepository.existsById(courseId)) {
			course=courseRepository.findById(courseId).get();
			courseRepository.deleteById(courseId);
		}
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		courseRepository.save(course);
		return course;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> courseList=new ArrayList<>();
		courseList=courseRepository.findAll();
		return courseList;
	}

	@Override
	public Course getCourseById(int courseId) {
		Course course=null;
		if(courseRepository.existsById(courseId)) {
			course=courseRepository.findById(courseId).get();
		}
		return course;
	}

	@Override
	public List<Course> getAllCoursedByCategory(String categoryName) {
		List<Course> listOfCourses=courseRepository.getAllCoursedByCategory(categoryName); 
		return listOfCourses;
	}

	@Override
	public List<Course> getAllCoursedByLevel(String levelName) {
		List<Course> listOfCourses=courseRepository.getAllCoursedByLevel(levelName); 
		return listOfCourses;
	}

	@Override
	public List<Course> getAllCoursedByInstructor(String instructorName) {
		List<Course> listOfCourses=courseRepository.getAllCoursedByInstructor(instructorName); 
		return listOfCourses;
	}

	@Override
	public List<Course> getCourseByLevelAndCategory(String CategoryName, String levelName) {
		List<Course> courseList=courseRepository.getCourseByLevelAndCategory(CategoryName, levelName);
		return courseList;
	}

	@Override
	public List<Course> getAssignedEmployeeCourses(int employeeId) {
		List<Course> courseList=courseRepository.getAssignedCourseForEmployees(employeeId);
			return courseList;
		
	}

	@Override
	public double countOfQuizIdByReports(int courseId,int employeeId) {
		int count=reportsRepository.countOfQuizIdByReports(courseId,employeeId);
		double progess=reportsRepository.getProgressByCourseId(courseId,employeeId);
		int getcountofModuleQuiz=reportsRepository.getCountOfmoduleQuizzes(courseId);
		double result=0;
		if(count==getcountofModuleQuiz) {
			
			if(progess>70.0) {
				result=progess;
				
			}
		}else {
			return result;
		}
		return result;
	}
	
	@Override
	public Course addCourseWithFiles(Course course, List<MultipartFile> materialFiles, List<MultipartFile> videoFiles) {
        try {
            int materialIndex = 0;
            int videoIndex = 0;

            for (Modules module : course.getModuleList()) {
                module.setCourseRef(course);

                // Handle material file
                if (materialFiles != null && materialIndex < materialFiles.size()) {
                    MultipartFile materialFile = materialFiles.get(materialIndex++);
                    module.setMaterialName(materialFile.getOriginalFilename());
                    module.setMaterialType(materialFile.getContentType());
                    module.setFiledata(materialFile.getBytes());
                }

                // Handle multiple videos
                List<Vedio> videoList = new ArrayList<>();
                while (videoIndex < videoFiles.size()) {
                    MultipartFile videoFile = videoFiles.get(videoIndex);

                    // Optional: Use naming convention to match video to module
                    if (videoFile.getOriginalFilename().startsWith(module.getModuleName())) {
                        Vedio video = new Vedio();
                        video.setContentName(videoFile.getOriginalFilename());
                        video.setContentType(videoFile.getContentType());
                        video.setVedioData(videoFile.getBytes());
                        video.setModuleRef(module);
                        videoList.add(video);
                        videoIndex++;
                    } else {
                        break;
                    }
                }
                module.setVedioRef(videoList);
            }

            return courseRepository.save(course);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save course with files", e);
        }
    }
	public Course findById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Modules findModuleById(int courseId, int moduleId) {
        Course course = findById(courseId);
        if (course != null) {
            return course.getModuleList().stream()
                    .filter(module -> module.getModuleId() == moduleId)
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }
	
	
//	@Override
//	public Course addCourseWithFiles(Course course, MultipartFile materialFile, List<MultipartFile> videoFiles) {
//	    try {
//	        for (Modules module : course.getModuleList()) {
//	            // Save the material
//	            if (materialFile != null && !materialFile.isEmpty()) {
//	                module.setMaterialName(materialFile.getOriginalFilename());
//	                module.setMaterialType(materialFile.getContentType());
//	                module.setFiledata(materialFile.getBytes());
//	            }
//
//	            // Save each video
//	            if (videoFiles != null && !videoFiles.isEmpty()) {
//	                for (MultipartFile videoFile : videoFiles) {
//	                    Vedio video = new Vedio();
//	                    video.setContentName(videoFile.getOriginalFilename());
//	                    video.setContentType(videoFile.getContentType());
//	                    video.setVedioData(videoFile.getBytes());
//	                    video.setModuleRef(module);
//	                    module.getVedioRef().add(video);
//	                }
//	            }
//	        }
//	        courseRepository.save(course);
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    return course;
//	}


//	@Override
//	public Course addCourse1(Course course, MultipartFile file) {
//		List<Modules> modulesLists=new ArrayList<Modules>();
//		List<Vedio> videosList=new ArrayList<Vedio>();
//		Modules module=new Modules();
//		module.setMaterialName(file.getOriginalFilename());
//		module.setMaterialType(file.getContentType());
//		try {
//			module.setFiledata(file.getBytes());
//			
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		for(int i=0;i<course.getModuleList().size();i++) {
//			module.setQuizRef(course.getModuleList().get(i).getQuizRef());
//			for(int j=0;j<course.getModuleList().get(i).getVedioRef().size();j++) {
//				Vedio vedio=new Vedio();
//				vedio.setContentName(file.getOriginalFilename());
//				vedio.setContentType(file.getContentType());
//				try {
//				vedio.setVedioData(file.getBytes());
//				}
//				catch (Exception e) {
//					e.printStackTrace();
//				}
//				vedio.setModuleRef(module);
//				vedio.setVedioName(course.getModuleList().get(i).getVedioRef().get(j).getVedioName());
//				
//			}
//			
//			module.setVedioRef(course.getModuleList().get(i).getVedioRef());
//			
//		}
//		module.setQuizRef(course.getModuleList().get(0).);
//		return null;
//	}



}
