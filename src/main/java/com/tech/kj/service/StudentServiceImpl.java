package com.tech.kj.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.tech.kj.dto.StudentDto;
import com.tech.kj.dto.UserDto;
import com.tech.kj.entity.Student;
import com.tech.kj.repository.StudentRepository;
import static com.tech.kj.constants.AppConstants.BASE_PATH_USER_SER;
import static com.tech.kj.constants.AppConstants.UNEXPECTED_ERROR;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private RestTemplate restTemplate;
    @Value("${userServiceName}")
    private String userServiceName;

    @Autowired
    public StudentServiceImpl(StudentRepository userRepository,RestTemplate restTemplate) {
        this.studentRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    @Override
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
    }


    @Override
    public long createStudent(@RequestBody StudentDto studentReqDto) {
    	//parse dto to entity
    	ModelMapper mapper =new ModelMapper();
    	TypeMap<StudentDto, Student> dtoToEntityMap = mapper.createTypeMap(StudentDto.class, Student.class);
    	dtoToEntityMap.addMapping(StudentDto::getCollageName, Student::setSchoolName);
    	Student student = mapper.map(studentReqDto,Student.class);
    	System.out.println(student);
    	student = studentRepository.save(student);
    	
    	TypeMap<StudentDto, UserDto> dtoToUserDto = mapper.createTypeMap(StudentDto.class, UserDto.class);
    	UserDto userDto = mapper.map(studentReqDto,UserDto.class);
    	
    	
    	ResponseEntity<Object> responseEntity = restTemplate.postForEntity(userServiceName+BASE_PATH_USER_SER, userDto, Object.class);
    	if(!responseEntity.getStatusCode().is2xxSuccessful()) {
    		//throw some error and roolback the current transaction
    		throw new RuntimeException(UNEXPECTED_ERROR);
    	}
    	
        return student.getId();
    }


    @Override
    public long updateStudent(@PathVariable Long id, @RequestBody Student user) {
        Student existingUser = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser = studentRepository.save(existingUser);
        return existingUser.getId();
    }


	@Override
	public long deleteStudent(Long id) {
		studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Record not found in"));
		studentRepository.deleteById(id);
		return 1;
		
	}


	


    
}
