package com.ty.car_rental_app_sping_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.car_rental_app_sping_boot.dao.UserDao;
import com.ty.car_rental_app_sping_boot.dto.ResponseStructure;
import com.ty.car_rental_app_sping_boot.dto.Role;
import com.ty.car_rental_app_sping_boot.dto.User;
import com.ty.car_rental_app_sping_boot.exception.InvalidUserCredentials;
import com.ty.car_rental_app_sping_boot.exception.UserIdNotFoundException;
import com.ty.car_rental_app_sping_boot.exception.UserRoleNotFoundException;

@Service
public class UserService {

	
	@Autowired
	UserDao userDaoObject;
	
	public ResponseEntity<ResponseStructure<User>> registerUser(User passedUser)
	{
		userDaoObject.registerUser(passedUser);
		
		ResponseStructure<User > responseStructure= new ResponseStructure<User>();
		responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("User DoesNot Exist For Given Id");
		responseStructure.setData(passedUser);
		
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<ResponseStructure<User>> getUserById(int passedUserId)
	{
		User user=userDaoObject.getUserById(passedUserId);
		
		if(user!=null)
		{
			
	
		ResponseStructure<User > responseStructure= new ResponseStructure<User>();
		responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(user);
		
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.NOT_FOUND);
		}
		else
		{
			throw new UserIdNotFoundException();
		}
		
	}
	
	
	public ResponseEntity<ResponseStructure<User>> updateUserById(int passedUserId,User userDataToUpdate)
	{
		User user=userDaoObject.updateUserById(passedUserId, userDataToUpdate);
		
		if(user!=null)
		{
			
	
		ResponseStructure<User > responseStructure= new ResponseStructure<User>();
		responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("success");
		responseStructure.setData(user);
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.NOT_FOUND);
		}
		else
		{
			throw new UserIdNotFoundException();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<User>> deleteUserById(int passedUserId)
	{
		boolean user=userDaoObject.deleteUserById(passedUserId);
		
		if(user)
		{
		ResponseStructure<User > responseStructure= new ResponseStructure<User>();
		responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("User Deleted Success");
	
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.NOT_FOUND);
		}
		
		else
		{
			throw new UserIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<User>> userLogin(String email,String password)
	{
		User user=userDaoObject.userLogin(email, password);
		
		if(user!=null)
		{
			ResponseStructure<User > responseStructure= new ResponseStructure<User>();
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.NOT_FOUND);	
		}
		else
		{
			throw new InvalidUserCredentials();
		}
			
	}
	
	public ResponseEntity<ResponseStructure<User>> getUserByRole(Role role)
	{
		User user=userDaoObject.getUserByRole(role);
		
		if(user!=null)
		{
			ResponseStructure<User > responseStructure= new ResponseStructure<User>();
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.NOT_FOUND);	
		}
		else
		{
			throw new UserRoleNotFoundException();
		}
			
	}
	
}
