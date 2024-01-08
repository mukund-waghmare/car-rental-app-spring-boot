package com.ty.car_rental_app_sping_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.car_rental_app_sping_boot.dto.ResponseStructure;
import com.ty.car_rental_app_sping_boot.dto.Role;
import com.ty.car_rental_app_sping_boot.dto.User;
import com.ty.car_rental_app_sping_boot.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class UserController {
	
	
	@Autowired
	UserService userServiceObject;
	
	@PostMapping("/registerUser")
	@Operation(description = "Save User", summary = "user saved Successfully")
	@ApiResponses(value = {@ApiResponse(description = "user saved successfully",responseCode = "201"),@ApiResponse(description = "User Not Saved",responseCode = "404")})
	public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody User passedUser)
	{
		return userServiceObject.registerUser(passedUser);
	}
	
	@PostMapping("/updateUser/{id}")
	@Operation(description = "Save User", summary = "user updated Successfully")
	@ApiResponses(value = {@ApiResponse(description = "User Updated Successfully",responseCode = "201"),@ApiResponse(description = "User Not Updated ",responseCode = "404")})
	public ResponseEntity<ResponseStructure<User>> updateUser(@PathVariable int id,@RequestBody User passedUser)
	{
		return userServiceObject.updateUserById(id, passedUser);
	}
	
	@DeleteMapping("/deleteUserById/{id}")
	@Operation(description = "Delete User", summary = "user deleted Successfully")
	@ApiResponses(value = {@ApiResponse(description = "User Deleted Successfully",responseCode = "201"),@ApiResponse(description = "User Deleted Updated ",responseCode = "404")})
	public ResponseEntity<ResponseStructure<User>> deleteByIdUser(@PathVariable int id)
	{
		return userServiceObject.deleteUserById(id);
	}
	
	@GetMapping("/getUserById/{id}")
	@Operation(description = "Get User By Id", summary = "user Found Successfully")
	@ApiResponses(value = {@ApiResponse(description = "User Found Successfully",responseCode = "201"),@ApiResponse(description = "User Not Found Successfully ",responseCode = "404")})
	public ResponseEntity<ResponseStructure<User>> getUserById(@PathVariable int id)
	{
		return userServiceObject.getUserById(id);
	}
	
	@PostMapping("/userLogin/{email}/{password}")
	@Operation(description = "user Login", summary = "User LoggedIn Successfully")
	@ApiResponses(value = {@ApiResponse(description = "User LoggedIn Successfully",responseCode = "201"),@ApiResponse(description = "User LoggedIn Failed Successfully ",responseCode = "404")})
	public ResponseEntity<ResponseStructure<User>> userLogin(@PathVariable String email,@PathVariable String password )
	{
		return userServiceObject.userLogin(email, password);
	}
	
	
	@GetMapping("/getUserByRole/{role}")
	@Operation(description = "Get User By Role ", summary = "User Found Based On Role Successfully")
	@ApiResponses(value = {@ApiResponse(description = "User Found Based On Role Successfully",responseCode = "201"),@ApiResponse(description = "User Doesnot Found Based On Role Successfully ",responseCode = "404")})
	public ResponseEntity<ResponseStructure<User>> getUserByRole(@PathVariable Role role)
	{
		return userServiceObject.getUserByRole(role);
	}

}
